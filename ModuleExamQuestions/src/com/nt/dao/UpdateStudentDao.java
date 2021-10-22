package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.nt.bean.StudentBean;

public class UpdateStudentDao {

	private GetConnection GetCon;
	private static final String  UPDATE_QUERY="UPDATE STUDENT SET STUDENT_NAME=?,ADDRES=? WHERE STUDENT_ID=?";
		public int  UpdateStudents(StudentBean bean) throws Exception{	
			Connection con=null;
			PreparedStatement ps=null;
			GetCon=new GetConnection();
			con=GetCon.getPooledJdbcConnection();
			int rs=0;
			if(con!=null)
				ps=con.prepareStatement(UPDATE_QUERY);
			
			if(ps!=null) {
				ps.setInt(3,bean.getStudent_id());
				ps.setString(1, bean.getStudentName());
				ps.setString(2,bean.getAddres());
				rs= ps.executeUpdate();	
			}
			return rs;
			}
		
			
			
}
