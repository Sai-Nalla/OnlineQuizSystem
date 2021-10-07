package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.nt.bean.StudentBean;

public class UpdateStudentDao {

	private GetConnection GetCon;
	private static final String  UPDATE_QUERY="UPDATE STUDENT SET SNAME=?,ADDRS=? WHERE SID=?";
	private static final String  SELECT_QUERY="SELECT * FROM STUDENT WHERE SID=1";
	Connection con=null;
	PreparedStatement ps=null;
		public int  UpdateStudents(StudentBean bean) throws Exception{	
			if(con!=null)
				ps=con.prepareStatement(UPDATE_QUERY);
			if(ps!=null) {
				ps.setInt(1,10);
				ps.setString(2, bean.getStudentName());
				ps.setString(3,bean.getAddres());
				return ps.executeUpdate();	
			}
			return 0;
			}
		
			public StudentBean getStudents()  throws Exception{
				ResultSet rs=null;
				StudentBean getbean=new StudentBean();
				GetCon=new GetConnection();
				con=GetCon.getPooledJdbcConnection();
				ps=con.prepareStatement(SELECT_QUERY);
				if(ps!=null) {
					rs=ps.executeQuery();			
				}
				while(rs.next()) {
					getbean.setStudentName(rs.getString(2));
					getbean.setAddres(rs.getString(3));
				}
				return getbean;
					
			}
			
}
