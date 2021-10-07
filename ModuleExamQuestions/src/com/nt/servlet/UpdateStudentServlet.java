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
		StudentBean bean;
		try {
			bean=dao.getStudents();
			req.setAttribute("Sbean", bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd=req.getRequestDispatcher("/UpdateStudent.jsp");
		rd.forward(req, res);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
