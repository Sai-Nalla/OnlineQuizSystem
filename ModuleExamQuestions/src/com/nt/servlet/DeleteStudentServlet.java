package com.nt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dao.DeleteStudentDao;

@WebServlet("/DeleteStudenturl")
public class DeleteStudentServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		DeleteStudentDao dao=new DeleteStudentDao();
		int stu_id=Integer.parseInt(req.getParameter("id"));
		try {
			int result=dao.deleteStudent(stu_id);
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
