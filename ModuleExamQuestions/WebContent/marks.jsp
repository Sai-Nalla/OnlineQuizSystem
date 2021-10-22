<%@ page import="com.nt.bean.LeaderBoadrBean,java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <html>
    <body style="background-image: linear-gradient(90deg,rgba(49, 89, 168,0.5),rgba(115, 20, 27,0.5))">
        <nav style=" border: 2px solid black; background-color: rgba(17, 23, 33);padding:20px; margin-top: -10px;margin-left: -10px;margin-right: -10px;text-align: center;" >
            <a href="StudentPanel.jsp"  target="_self"
         style="
          color:white; text-decoration: none;">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

      <%--  <a href=""target="_blank" style="color:white; text-decoration: none;">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; --%>
        <a href="Subject.jsp"target="_self" style="color:white; text-decoration: none;">QUESTION PAPER </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="Resulturl?id=<%=session.getAttribute("student_id") %>" target="_self" style="color:white;text-decoration: none;">RESULTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <a href="Profileurl?id=<%=session.getAttribute("student_id") %>" target="_self" style="color:white;text-decoration: none;">PROFILE</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="logut.jsp" target="_self" style="color:white;text-decoration: none;">LOGUT</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="leaderurl"  target="_self" style="color:white;text-decoration: none;align:right">LEADERBOARD</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</nav>
</body>

<h1 style="text-align:center">Student Marks</h1>
 <%  List<LeaderBoadrBean> list=(List<LeaderBoadrBean>) request.getAttribute("leader"); %>
               

<table border="1" bgcolor="cyan" align="center">
<tr>
<td>SID</td><td>Sname</td><td>Marks</td><td>SUB_ID</td><td>SUB_NAME</td>
</tr>
<% for(LeaderBoadrBean bean:list){ %>
<tr>
<td> <%=bean.getSid() %></td>
<td> <%=bean.getSname() %></td>
<td> <%=bean.getMarks() %></td>
<td> <%=bean.getSub_id() %></td>
<td> <%=bean.getSub_name() %></td>
</tr>
<%} %>

</table>
</html>
    