<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <h1 style="color:red"> ${result}</h1>
   <br>
   <form action="addsubjecturl" method="POST">
   <table border="1" align="center" color="cyan">
   <tr>
   <td>Subject_ID</td>
   <td><input type="text" name="sub_id"></td>
   </tr>
   <tr>
   <td>Subject_Name</td>
   <td><input type="text" name="sub_name"></td>
   </tr>
  <tr><th><input type="submit" value="submit"></th></tr>
   </table>
   </form>
   <a href="getsubject">AddQuestions</a>
    