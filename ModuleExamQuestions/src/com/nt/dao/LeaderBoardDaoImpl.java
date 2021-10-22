package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nt.bean.LeaderBoadrBean;

public class LeaderBoardDaoImpl {
	private static final String QUERY="SELECT S.Student_id,S.Student_NAME,R.MARKS,R.SUB_ID,SB.SUB_NAME FROM STUDENT S JOIN RESULTS R ON S.Student_id=R.Stu_id JOIN SUBJECT SB ON R.SUB_ID=SB.SUB_ID WHERE SB.SUB_ID=? ORDER BY R.MARKS DESC ";
			   public List<LeaderBoadrBean > getLeaderBoard(int sub_id){
				   Connection con=null;
					PreparedStatement ps=null;
					ResultSet rs=null;
					LeaderBoadrBean bean=null;
					List<LeaderBoadrBean> listbean=new ArrayList<LeaderBoadrBean>();
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						//get connection obj
						con=DriverManager.getConnection("jdbc:mysql:///sai","root","root");
						//get prepared ststement obj
					 ps=con.prepareStatement(QUERY);
					 if(ps!=null) {
						 ps.setInt(1, sub_id);
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
						}//finally
					return listbean;

			   }

}
