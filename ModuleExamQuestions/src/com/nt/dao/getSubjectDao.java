package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nt.bean.LeaderBoadrBean;
import com.nt.bean.SubjectBean;

public class getSubjectDao {
	private GetConnection GetCon;
	private static final String  SELECT_QUERY="SELECT * FROM SUBJECT";
		public List<SubjectBean>  getSubjects() throws Exception{	
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			GetCon=new GetConnection();
			con=GetCon.getPooledJdbcConnection();
			
			List<SubjectBean> listbean=new ArrayList<SubjectBean>();
			if(con!=null)
				ps=con.prepareStatement(SELECT_QUERY);
			if(ps!=null) {		
				rs=ps.executeQuery();
			}
			while(rs.next()) {
				SubjectBean bean=new SubjectBean();
					bean.setSubject_id(rs.getInt(1));	
					bean.setSubject_name(rs.getString(2));
				listbean.add(bean);
			}
			return listbean;
		}

}
