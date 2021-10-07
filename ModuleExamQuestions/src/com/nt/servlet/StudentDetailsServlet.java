package com.nt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.bean.StudentBean;
import com.nt.dao.StudentDetailsDao;


@WebServlet("/StuDetails")
public class StudentDetailsServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentDetailsDao dao=new StudentDetailsDao();
		List<StudentBean> StuList = null;
		try {
			StuList=dao.getStudents();
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("DetailsList", StuList);
		RequestDispatcher rd=req.getRequestDispatcher("/StudentDetails.jsp");
		rd.forward(req, res);
		
			}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
