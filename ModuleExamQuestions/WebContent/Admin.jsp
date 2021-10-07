<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%-- if the user directly request this account he should not login instead it redirects to login page
we have to check the user is available or if not we have to ask him for register 
or login because he has logouted from his acount ie we have to do authentication if the user is valid or not---%>
<body>
<h1 style=color:red,text-align:center>Home</h1>"
<form action="details.jsp" method="post" align="center">
<input type="submit" value="Details">
</form>
<form action="logut.jsp" method="post" align="right">
<input type="submit" value="Logut">
</form>
<form action="addStudents.jsp" method="post" align="" >
<input type="submit" value="AddStudent">
</form>
<form action="/StuDetails" method="post" align="right" >
<input type="submit" value="StudentDetails">
</form>
<h1 style ="color:blue;text-align:center">Welcome to Home Page</h1>
</body>
</html>
<br><br><br>
<br><br><br>
<h2><a href="getsubject">AddQuestions</a></h2>
<h1 align="right"><br><a href="addSubject.jsp">AddSubject</a> </h1>
