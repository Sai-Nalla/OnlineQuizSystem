<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%RequestDispatcher rd=request.getRequestDispatcher("/home.jsp");
		rd.include(request, response);%>
    
<form action="addStudenturl" method="post">
<table border="1" align="center" bgcolor="cyan">

<td>Student_id</td>
<td><input type="text" name="student_id"></td>
</tr>
<tr>
<tr>
<td>Student Name</td>
<td><input type="text" name="sname"></td>
</tr>
<tr>
<%-- -<td>BranchName</td>
<td><input type="text" name="branchname"></td>
</tr>
<tr>
<tr>--%>
<td>Address</td>
<td><input type="text" name="addrs"></td>
</tr>
<tr>
<tr>

<td><input type="submit" value="AddStudent"></td>
</tr>
</table>
</form>