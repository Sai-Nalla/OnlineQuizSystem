package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nt.bean.addQuestionsBean;

public class GetSubjectDaoImpl {
	private static final String QUERY="SELECT SUB_ID,SUB_NAME FROM SUBJECT";
	private static final String QUERY2="SELECT SUB_NAME FROM SUBJECT";
	public List<String> SubjectDetails() {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<String> al=new ArrayList<>();
		try {
			//load driver class
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			//get connection obj
			con=DriverManager.getConnection("jdbc:mysql:///sai","root","root");
			//get prepared ststement obj
		 ps=con.prepareStatement(QUERY);
		 if(ps!=null) {
			 rs=ps.executeQuery();
		 }
		while(rs.next()) {
			al.add(rs.getString(1));
		}
		 
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				if(ps!=null) {
					ps.close();
				}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			try {
				if(con!=null) {
					con.close();
				}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
		}//finally
return al;		
	}
	public Map<Integer,String>  getSubjects() {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Map<Integer,String> subjects=new HashMap<>();
		try {
			//load driver class
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			//get connection obj
			con=DriverManager.getConnection("jdbc:mysql:///sai","root","root");
			//get prepared ststement obj
		 ps=con.prepareStatement(QUERY);
		 if(ps!=null) {
			 rs=ps.executeQuery();
		 }
		 while(rs.next()) {
			 subjects.put(rs.getInt(1),rs.getString(2));
			 
		 }
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				if(ps!=null) {
					ps.close();
				}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			try {
				if(con!=null) {
					con.close();
				}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
		}//finally
return subjects;
}
}
