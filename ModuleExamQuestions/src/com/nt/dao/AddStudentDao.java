package com.nt.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bean.StudentBean;

public class AddStudentDao {
	private GetConnection GetCon;
	private static final String Query="INSERT INTO LoginCredential values(?,?)";
	private static final String Query2="INSERT INTO STUDENT values(?,?,?)";
		public int  addStudents(StudentBean bean) throws Exception{
			Connection con=null;
			PreparedStatement ps=null,ps2=null;
			int rs=0;
			GetCon=new GetConnection();
			con=GetCon.getPooledJdbcConnection();
			if(con!=null)
				ps2=con.prepareStatement(Query);
			 ps=con.prepareStatement(Query2);
			if(ps!=null) {
				ps2.setString(1,bean.getStudentName());
				ps2.setInt(2, bean.getStudent_id());
				ps.setInt(1,bean.getStudent_id());
				ps.setString(2, bean.getStudentName());
				ps.setString(3,bean.getAddres());
				
				rs= ps.executeUpdate();	
				 ps2.executeUpdate();
			}
			return rs;
		}
}
		
