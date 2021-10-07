package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import com.nt.bean.SubjectBean;

public class AddSubjectDaoImpl {
	private static final String QUERY="INSERT INTO SUBJECT VALUES(?,?)";
	
	
	
	public boolean  addSubjects(SubjectBean subBean) {
		Connection con=null;
		PreparedStatement ps=null;	
		boolean flag=false;
		int rs=0;
		try {
			//load driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			//get connection obj
			con=DriverManager.getConnection("jdbc:mysql:///sai","root","root");
			//get prepared ststement obj
		 ps=con.prepareStatement(QUERY);
		 if(ps!=null) {
			 ps.setInt(1, subBean.getSubject_id());
			 ps.setString(2,subBean.getSubject_name());
			 rs=ps.executeUpdate();
		 }
		 if(rs==1)
			 flag=true;
		 
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
		return flag;
	}
}
