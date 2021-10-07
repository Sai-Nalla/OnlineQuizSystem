package com.nt.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DetailsCustDao {
	private static final String Query="SELECT * FROM LOGINCREDENTIAL WHERE UNAME=? AND Pwd=?";
	public List<String> getCustomerDetails(String uname,int pwd) {
		List<String> al=new ArrayList();
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
			 //set query params
			 ps.setString(1,uname);
			 ps.setInt(2, pwd);
			 rs=ps.executeQuery();
		 }
		 if(rs!=null) {
			 if(rs.next()) {
				 //add record to collection
				 al.add(rs.getString(1));
				 al.add(String.valueOf(rs.getInt(2)));
				// al.add(rs.getString(3));
				// al.add(rs.getString(4));
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
		return al;
	
	}

}
