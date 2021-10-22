<%@ page import="java.util.*,com.nt.bean.LeaderBoadrBean" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
    rd.include(request, response);%>
    <%  List<LeaderBoadrBean> list=(List<LeaderBoadrBean>) request.getAttribute("leader"); %>
               
<h1 style="text-align:center">LEADERBOARD</h1>
<table border="1" bgcolor="cyan" align="center">
<tr>
<th>SID</th><th>Sname</th><th>Marks</th><th>Sub_id</th><th>Sub_name</th>
</tr>
<% for(LeaderBoadrBean bean:list){ %>
<tr>
<td> <%=bean.getSid() %></td>
<td> <%=bean.getSname() %></td>
<td> <%=bean.getMarks() %></td>
<td> <%=bean.getSub_id()%></td>
<td> <%=bean.getSub_name()%></td>
</tr>
<%} %>

</table>

