package com.nt.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bean.StudentBean;

public class AddStudentDao {
	private GetConnection GetCon;
	private static final String  INSERT_QUERY="INSERT INTO STUDENT VALUES(?,?,?)";
		public int  addStudents(StudentBean bean) throws Exception{
			Connection con=null;
			PreparedStatement ps=null;
			
			GetCon=new GetConnection();
			con=GetCon.getPooledJdbcConnection();
			if(con!=null)
				ps=con.prepareStatement(INSERT_QUERY);
			if(ps!=null) {
				ps.setInt(1,10);
				ps.setString(2, bean.getStudentName());
				ps.setString(3,bean.getAddres());
				return ps.executeUpdate();	
			}
			return 0;
			
		}
}
		
