package com.nt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.bean.StudentBean;
import com.nt.dao.UpdateStudentDao;

@WebServlet("/UpdateStudenturl")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UpdateStudentDao dao=new UpdateStudentDao();
		StudentBean bean=new StudentBean();
		int result=0;
		bean.setStudent_id(Integer.parseInt(req.getParameter("stu_id")));
		bean.setStudentName(req.getParameter("sname"));
		bean.setAddres(req.getParameter("addrs"));
		try {
			result=dao.UpdateStudents(bean);
			System.out.println(result);
			if(result==1) {
				RequestDispatcher rd=req.getRequestDispatcher("/StuDetails");
			rd.forward(req, res);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
