<%@ page import="java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%Map<Integer,String> subject=(Map<Integer,String>)session.getAttribute("subjects");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
<br><h1 style="color:red"> ${result}</h1> <br>
<h1 style="color:bule"> Add Questions</h1><br>
<form action="addurl" method="post">
<table  border="1",align="right">
Choose Subject::<select  name="subject">
<%for(Map.Entry<Integer,String> map:subject.entrySet()) {%>
 <option value="<%=map.getKey()%>"><%=map.getValue() %></option>
<%} %>
</select>
<tr>Question</tr><br>

<tr><textarea rows="2" cols="50" name="question"></textarea></tr><br>

<tr>Option1</tr><br>
<tr><input type="text" name="opt1"></tr><br>
<tr>Option2</tr><br>
<tr><input type="text" name="opt2"></tr><br>
<tr>Option3</tr><br>
<tr><input type="text" name="opt3"></tr><br>
<tr>Option4</tr><br>
<tr><input type="text" name="opt4"></tr><br>
<tr>CrctAns</tr><br>
<tr><input type="text" name="crctans"></tr><br>
<tr><input type="submit" value="submit"></tr>
</table>
</form>


</body>
</html>