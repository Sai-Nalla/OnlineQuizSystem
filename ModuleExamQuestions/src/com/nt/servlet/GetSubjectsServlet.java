package com.nt.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.dao.GetSubjectDaoImpl;

/**
 * Servlet implementation class GetSubjectsServlet
 */
@WebServlet("/getsubject")
public class GetSubjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetSubjectDaoImpl subjectdao=new GetSubjectDaoImpl();
		Map<Integer,String> subject;
		subject=subjectdao.getSubjects();
		HttpSession session=request.getSession(true);
		session.setAttribute("subjects", subject);
		RequestDispatcher rd=request.getRequestDispatcher("/addQuestion.jsp");
		rd.forward(request, response);		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
