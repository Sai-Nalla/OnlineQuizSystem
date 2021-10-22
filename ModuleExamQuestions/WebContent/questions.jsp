<%@ page import="java.util.*,com.nt.bean.Questionbean" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
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
<%
int current=0;
List<Questionbean> list=null;
Questionbean bean1=null;
list=(List<Questionbean>)session.getAttribute("question1");%>
<form action="nexturl" method="POST">

<%
if(request.getAttribute("current")!=null){
	 current=(Integer)request.getAttribute("current");
}
bean1=list.get(current);
session.setAttribute("question_id", bean1.getQuestion_id());

	%>
 <h1><%=bean1.getQuestion_name() %></h1><br>
	<input type="radio" id="A"name="<%=bean1.getQuestion_id()%>" value="A"><%=bean1.getOption1()%><br>
	<input type="radio" id="B"name="<%=bean1.getQuestion_id()%>" value="B"><%=bean1.getOption2() %><br>
	<input type="radio"id="C" name="<%= bean1.getQuestion_id()%>" value="C"><%=bean1.getOption3() %><br>
	<input type="radio"id="D" name="<%= bean1.getQuestion_id()%>" value="D"><%=bean1.getOption4() %>	<br>	

<input type="hidden" name="hidden" value="<%=current%>" >
<% if(current!=list.size()-1) { %>
<input type="submit" name="target" value="next">
<%} %>
<% if(current!=0) {%>
<input type="submit" name="target" value="previous">
<%} %>
<input type="submit" name="target" value="Submit">
</form>


</body>

<script>
window.onload=function check(){
	<%int s=(int)session.getAttribute("question_id"); 
	String str=(String)session.getAttribute(String.valueOf(s));
	request.setAttribute("Abc", str);
	%>
var x="${Abc}";

document.getElementById(x).checked=true;
}
</script>
</html>
	



