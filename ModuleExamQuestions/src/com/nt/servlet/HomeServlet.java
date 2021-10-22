package com.nt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.dao.SearchCustDao;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
			SearchCustDao scd=null;
			String username=null;
			int pwd=0;
			boolean flag=false;
			HttpSession ses = req.getSession();
			ses.getAttribute("uname");
			pwd=(int)ses.getAttribute("password");
			
			scd=new SearchCustDao();
			flag=scd.SearchDetails(username, pwd);
			}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
