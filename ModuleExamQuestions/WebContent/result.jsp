<%@ page isELIgnored="false" import="java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%session.removeAttribute("1");
    session.removeAttribute("2");
    session.removeAttribute("3");
    session.removeAttribute("4");
    %>
    <h1 style="color:red;text-align='center'">Results</h1>
    
   YourScore::${marks}
   <br><a href="Students.jsp">Home</a>
  
   
   