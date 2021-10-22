package com.nt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.bean.StudentBean;
import com.nt.dao.getStudentDao;


@WebServlet("/getStudenturl")
public class getStudentServlet extends HttpServlet {

    
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		getStudentDao studao=new getStudentDao();
		StudentBean bean=null;
		int stu_id=Integer.parseInt(req.getParameter("id"));
		try {
			bean=studao.getStudents(stu_id);
			req.setAttribute("student", bean);
			RequestDispatcher rd=req.getRequestDispatcher("/UpdateStudent.jsp");
			rd.forward(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
