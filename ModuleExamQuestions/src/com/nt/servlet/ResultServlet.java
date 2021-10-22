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

import com.nt.bean.LeaderBoadrBean;
import com.nt.dao.LeaderBoardDaoImpl;
import com.nt.dao.ResultDao;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/Resulturl")
public class ResultServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ResultDao dao=new ResultDao();
		List<LeaderBoadrBean> list;
		
		int stu_id=Integer.parseInt(req.getParameter("id"));
		try {
			list=dao.getResult(stu_id);
			req.setAttribute("leader", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		RequestDispatcher rd=req.getRequestDispatcher("/marks.jsp");
		rd.forward(req, res);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
