<%@ page import="com.nt.bean.StudentBean"  language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
   <%StudentBean bean=(StudentBean)request.getAttribute("student");%>
<!DOCTYPE html>
<form action="UpdateStudenturl" method="post">
<table border="1" align="center" bgcolor="cyan">
<tr>
<td>Student_id</td>
<td><input type="text" name="stu_id"value=<%=bean.getStudent_id()%>></td>
</tr>
<tr>
<tr>
<td>Student Name</td>
<td><input type="text" name="sname" value=<%=bean.getStudentName() %>></td>
</tr>
<tr>
<td>Address</td>
<td><input type="text" name="addrs"value=<%=bean.getAddres() %>></td>
</tr>
<tr>

<td><input type="submit" value="Update"></td>
</tr>
</table>
</form>