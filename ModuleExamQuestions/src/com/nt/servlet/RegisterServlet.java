package com.nt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dao.CustomerDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerurl")
public class RegisterServlet extends HttpServlet {

		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			String username=null,pwd=null,name=null,addrs=null;
			CustomerDao dao=null;
			int result=0;
			//read form data
		username=req.getParameter("uname");
		pwd=req.getParameter("pwd");
		name=req.getParameter("name");
		addrs=req.getParameter("adrs");
		dao=new CustomerDao();
		result=dao.registerCustDetails(username,pwd,name,addrs);
		if(result!=0) {
			res.sendRedirect("Login.jsp");
		}
			
		}

		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
					doGet(req, res);
		}

	}
