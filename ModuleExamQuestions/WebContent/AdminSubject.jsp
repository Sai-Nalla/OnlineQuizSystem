<%@ page import="java.util.*,com.nt.bean.SubjectBean" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%RequestDispatcher rd=request.getRequestDispatcher("/home.jsp");
		rd.include(request, response);%>
		
<%List<SubjectBean> sublist=(List<SubjectBean>)session.getAttribute("subjects"); 
for(SubjectBean bean:sublist){ %>
	 <a href="leaderurl?id=<%=bean.getSubject_id()%>"><button  class="test" style="color:black;height:200px;width:200px;black;size: 50px"><%=bean.getSubject_name()%></button></a>
<%}%>