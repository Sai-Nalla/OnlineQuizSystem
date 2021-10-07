package com.nt.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.dao.AnswerDaoImpl;


@WebServlet("/answerurl")
public class AnswerServlet extends HttpServlet {
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Map<Integer,String > map=new HashMap<>();
			  int  count=0;
			HttpSession ses=request.getSession(true);
			int Sub_id= (int) ses.getAttribute("subject_id");
			int stu_id=(int)ses.getAttribute("student_id");
			AnswerDaoImpl ansdao=new AnswerDaoImpl();		
			map=ansdao.getAnswers(Sub_id);
				for(Map.Entry<Integer,String> entry:map.entrySet()) {
					
				System.out.println(entry.getValue()+" "+ses.getAttribute(String.valueOf(entry.getKey())));
					if(entry.getValue().trim().equals(ses.getAttribute(String.valueOf(entry.getKey())))) {
						System.out.println(count);
						count++;
					}
			}
		System.out.print(count);
		System.out.println(ansdao.insertResults(stu_id,count,Sub_id));
				request.setAttribute("marks", count);
		
			ses.removeAttribute("subject_id");
			RequestDispatcher rd=request.getRequestDispatcher("/result.jsp");
			rd.forward(request, response);
			}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
