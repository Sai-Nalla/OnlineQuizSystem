package com.nt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.bean.SubjectBean;
import com.nt.dao.getStudentDao;
import com.nt.dao.getSubjectDao;


@WebServlet("/GetSubjecturl")
public class GetSubjectServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		getSubjectDao dao=new getSubjectDao();
		HttpSession ses=req.getSession(true);
		try {
			List<SubjectBean> list=dao.getSubjects();
			System.out.println(list);
			ses.setAttribute("subj", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd=req.getRequestDispatcher("/Subject.jsp");
		rd.forward(req, res);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
