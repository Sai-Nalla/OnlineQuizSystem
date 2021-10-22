package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nt.bean.StudentBean;

public class DeleteStudentDao {
		private static final String  DELETE_QUERY="DELETE FROM STUDENT WHERE STUDENT_ID=?";
		private GetConnection GetCon;
		public int deleteStudent(int stu_id)throws Exception{
			Connection con=null;
			PreparedStatement ps=null;
			int rs=0;
			GetCon=new GetConnection();
			con=GetCon.getPooledJdbcConnection();
			ps=con.prepareStatement(DELETE_QUERY);
			if(ps!=null) {
				ps.setInt(1, stu_id);
				rs=ps.executeUpdate();
			}
			return rs;
		}
		
	}

