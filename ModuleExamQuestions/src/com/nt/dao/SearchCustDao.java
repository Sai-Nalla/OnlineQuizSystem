package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchCustDao {
	private static final String Query="SELECT * FROM LOGINCREDENTIAL";
	public boolean SearchDetails(String uname,int pwd) {
	
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//load driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			//get connection obj
			con=DriverManager.getConnection("jdbc:mysql:///sai","root","root");
			//get prepared ststement obj
		 ps=con.prepareStatement(Query);
		 if(ps!=null) {
			 rs=ps.executeQuery();
		 }
		 if(rs!=null) {
			 while(rs.next()) {
				 if(uname.equalsIgnoreCase(rs.getString(1))) {
					 if(pwd==rs.getInt(2)) {
						 return true;
					 }
				 }		 
			 }
		 }
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}//catch
		finally {
			try {
			if(rs!=null) {
				rs.close();
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
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
		}
		return false;
}//
	}//class