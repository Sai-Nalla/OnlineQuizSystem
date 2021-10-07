package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nt.bean.StudentBean;

public class StudentDetailsDao {
	private static final String  SELECT_QUERY="SELECT * FROM STUDENT";
	private GetConnection GetCon;
	public List<StudentBean> getStudents() throws Exception{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<StudentBean> Stulist=new ArrayList<StudentBean>();
		GetCon=new GetConnection();
		con=GetCon.getPooledJdbcConnection();
		ps=con.prepareStatement(SELECT_QUERY);
		if(ps!=null) {
			rs=ps.executeQuery();		
			
		while(rs.next()) {
			StudentBean getbean=new StudentBean();
			getbean.setMobileNo(rs.getInt(1));
			getbean.setStudentName(rs.getString(2));
			getbean.setAddres(rs.getString(3));
			Stulist.add(getbean);
		}	
	}
return Stulist;
}
}