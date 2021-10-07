package com.nt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.bean.SubjectBean;
import com.nt.dao.AddSubjectDaoImpl;

/**
 * Servlet implementation class AddSubjectServlet
 */
@WebServlet("/addsubjecturl")
public class AddSubjectServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		AddSubjectDaoImpl subDao=new AddSubjectDaoImpl();
		SubjectBean subBean=new SubjectBean();
		subBean.setSubject_id(Integer.parseInt(req.getParameter("sub_id")));
		subBean.setSubject_name(req.getParameter("sub_name"));
		
		boolean flag=subDao.addSubjects(subBean);
		if(flag)
		req.setAttribute("result", "SubjectAdded Succefully");
		else
			req.setAttribute("result", "Subject not Added Succefully");
		RequestDispatcher rd=req.getRequestDispatcher("/addSubject.jsp");
		rd.forward(req, res);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
