package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nt.bean.LeaderBoadrBean;
import com.nt.bean.StudentBean;

public class ResultDao {
	private GetConnection GetCon;
	private static final String  SELECT_QUERY="SELECT S.Student_id,S.Student_NAME,R.MARKS,R.SUB_ID,SB.SUB_NAME FROM STUDENT S JOIN RESULTS R ON S.Student_id=R.Stu_id JOIN SUBJECT SB ON R.SUB_ID=SB.SUB_ID WHERE S.STUDENT_ID=?";
		public List<LeaderBoadrBean>  getResult(int stu_id) throws Exception{	
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			GetCon=new GetConnection();
			con=GetCon.getPooledJdbcConnection();
			LeaderBoadrBean bean=null;
			List<LeaderBoadrBean> listbean=new ArrayList<LeaderBoadrBean>();
			if(con!=null)
				ps=con.prepareStatement(SELECT_QUERY);
			if(ps!=null) {	
				ps.setInt(1, stu_id);
				rs=ps.executeQuery();
			}
				while(rs.next()) {
					 bean=new LeaderBoadrBean();
					 bean.setSid(rs.getInt(1));
					 bean.setSname(rs.getString(2));
					 bean.setMarks(rs.getInt(3));
					 bean.setSub_id(rs.getInt(4));
					 bean.setSub_name(rs.getString(5));
					 listbean.add(bean);
				 }
				return listbean;
				}
			
		}
