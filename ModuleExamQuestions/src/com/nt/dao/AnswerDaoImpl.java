package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class AnswerDaoImpl {
	private static final String QUERY="select quest_no,crct_ans from questions where sub_id=?";
	private static final String QUERY2="Insert Into results values(?,?,?)";
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public boolean insertResults(int stu_id,int marks,int sub_id) {
		
		boolean flag=false;
		int rs=0;
		try {
			
		ps=con.prepareStatement(QUERY2);
		if(ps!=null) {
			ps.setInt(1, stu_id);
			ps.setInt(2,marks);
			ps.setInt(3, sub_id);
		 rs=ps.executeUpdate();
		}
		flag=(rs==1)?true:false;
		}
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
	public Map<Integer,String> getAnswers(int sub_id){
	Map<Integer,String> ansMap=new HashMap<>();
	try {
		//load driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		//get connection obj
		con=DriverManager.getConnection("jdbc:mysql:///sai","root","root");
		//get prepared ststement obj
	 ps=con.prepareStatement(QUERY);
	 if(ps!=null) 
		//set query param values
		 ps.setInt(1, sub_id);
		 rs=ps.executeQuery();
		 while(rs.next()) 
			 ansMap.put(rs.getInt(1), rs.getString(2));
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return ansMap;

}
}
