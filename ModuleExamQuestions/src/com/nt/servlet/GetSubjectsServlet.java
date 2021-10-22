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

import com.nt.bean.SubjectBean;
import com.nt.dao.GetSubjectDaoImpl;
import com.nt.dao.getSubjectDao;

/**
 * Servlet implementation class GetSubjectsServlet
 */
@WebServlet("/getsubject")
public class GetSubjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getSubjectDao dao=new getSubjectDao();
		HttpSession ses=request.getSession(true);
		try {
			List<SubjectBean> list=dao.getSubjects();
			System.out.println(list);
			ses.setAttribute("subjects",list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		RequestDispatcher rd=request.getRequestDispatcher("/addQuestion.jsp");
		rd.forward(request, response);		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
