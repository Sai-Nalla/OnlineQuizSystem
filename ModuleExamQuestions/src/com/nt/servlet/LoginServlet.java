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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginurl")
public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=null;
		int pwd=0;
		SearchCustDao scd=null;
		boolean flag=false;
		//read form data
	username=req.getParameter("uname");
	pwd=Integer.parseInt(req.getParameter("pwd"));
	//keep the creditentials in Seesion attribute
	HttpSession ses = req.getSession();
	ses.setAttribute("uname", username);
	ses.setAttribute("student_id", pwd);
	
	scd=new SearchCustDao();
	flag=scd.SearchDetails(username, pwd);
	if(flag&&username.equals("Admin")) 
		resp.sendRedirect("Admin.jsp");
		else  if(flag)
			resp.sendRedirect("Students.jsp");
		else{
			resp.sendRedirect("Login.jsp");
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				doGet(req, resp);
	}

}
