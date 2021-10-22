package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nt.bean.StudentBean;

public class getStudentDao {
	private static final String  SELECT_QUERY="SELECT * FROM STUDENT where student_id=?";
	private GetConnection GetCon;
	public StudentBean getStudents(int sid) throws Exception{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		StudentBean getbean=new StudentBean();
		GetCon=new GetConnection();
		con=GetCon.getPooledJdbcConnection();
		ps=con.prepareStatement(SELECT_QUERY);
		if(ps!=null) {
			ps.setInt(1,sid);
			rs=ps.executeQuery();		
				rs.next();
			getbean.setStudent_id(rs.getInt(1));
			getbean.setStudentName(rs.getString(2));
			getbean.setAddres(rs.getString(3));
	}
return getbean;
}
}
