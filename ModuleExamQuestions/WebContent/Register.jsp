
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="registerurl" method="post">
<table border="1" align="center" bgcolor="cyan">
<tr>
<td>Name</td>
<td><input type="text" name="name"></td>
</tr>
<tr>
<td>Address</td>
<td><input type="text" name="adrs"></td>
</tr>
<tr>
<td>Username</td>
<td><input type="text" name="uname"></td>
</tr>
<tr>
<td>password</td>
<td><input type="text" name="pwd"></td>
</tr>
<tr>
<td><input type="submit" value="Register"></td>
<td><a href="Login.jsp">Login</a>
</tr>
</table>
</form>


</body>
</html>