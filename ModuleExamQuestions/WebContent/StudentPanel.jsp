<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image: linear-gradient(90deg,rgba(49, 89, 168,0.5),rgba(115, 20, 27,0.5))">
        <nav style=" border: 2px solid black; background-color: rgba(17, 23, 33);padding:20px; margin-top: -10px;margin-left: -10px;margin-right: -10px;text-align: center;" >
            <a href="StudentPanel.jsp"  target="_self"
         style="
          color:white; text-decoration: none;">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

      <%--  <a href=""target="_blank" style="color:white; text-decoration: none;">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; --%>
        <a href="GetSubjecturl"target="_self" style="color:white; text-decoration: none;">QUESTION PAPER </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="Resulturl?id=<%=session.getAttribute("student_id") %>" target="_self" style="color:white;text-decoration: none;">RESULTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <a href="Profileurl?id=<%=session.getAttribute("student_id") %>" target="_self" style="color:white;text-decoration: none;">PROFILE</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="logut.jsp" target="_self" style="color:white;text-decoration: none;">LOGUT</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      
</body>
    
</html>