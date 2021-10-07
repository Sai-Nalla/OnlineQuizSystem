package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.bean.StudentBean;
import com.nt.dao.AddStudentDao;

@WebServlet("/addStudenturl")
public class AddStudentServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		  int MobileNo=0;
		  StudentBean bean =new StudentBean();
		  AddStudentDao dao=new AddStudentDao();
		  bean.setStudentName(req.getParameter("sname"));
		  bean.setBranch(req.getParameter("branchname"));
		  bean.setAddres(req.getParameter("addrs"));
		  bean.setMobileNo(Integer.parseInt(req.getParameter("Phoneno")));
		  pw=res.getWriter();
		  pw.print("Hello");
		  try {
			System.out.println(dao.addStudents(bean));
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		  pw.print("Hello");
		

			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
