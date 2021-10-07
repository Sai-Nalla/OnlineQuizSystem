package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDao {
	private static final String Query="INSERT INTO LoginCredential values(?,?)";
	private static final String Query2="INSERT INTO STUDENT values(?,?,?)";
	public int registerCustDetails(String uname,String pwd,String name,String addrs) {
		Connection con=null;
		PreparedStatement ps=null,ps2=null;
		int rs=0;
		try {
			//load driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			//get connection obj
			con=DriverManager.getConnection("jdbc:mysql:///sai","root","root");
			//get prepared ststement obj
		 ps=con.prepareStatement(Query);
		 ps2=con.prepareStatement(Query2);
		 if(ps!=null) {
			//set query param values
			 ps.setString(1,uname);
			 ps.setInt(2, Integer.parseInt(pwd));
			 ps2.setInt(1, Integer.parseInt(pwd));
			 ps2.setString(2,name);
			 ps2.setString(3, addrs);
			
			 
			 //ps.setString(3, name);
			 //ps.setString(4, addrs);
			 rs= ps2.executeUpdate();
			 ps.executeUpdate();
			 
		return rs;	
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
		}
		return 0;
	}
}
