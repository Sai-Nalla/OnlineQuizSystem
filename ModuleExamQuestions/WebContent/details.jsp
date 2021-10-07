<<jsp:include page="Admin.jsp"></jsp:include>
<h1 style="color:red;text-align:center">Welcome to Details </h1>
<%@ page isELIgnored="false"  import="com.nt.dao.DetailsCustDao,java.util.ArrayList,java.util.List,com.nt.dao.SearchCustDao" %>
<%
String uname=null;
int pwd=0;
boolean flag;
SearchCustDao scd=null;
uname=(String)session.getAttribute("uname");
pwd=(int)session.getAttribute("password");
scd=new SearchCustDao();
flag=scd.SearchDetails(uname, pwd);
if(!flag) {
	response.sendRedirect("Login.jsp");
}
else{
//get Seesion attributes

DetailsCustDao dao=null;
List<String> al=new ArrayList();
dao=new DetailsCustDao();
al=dao.getCustomerDetails(uname, pwd);%>

<table border="1" bgcolor="cyan"align="center">
<tr><td colspan="2">Customer Details</td></tr>
<tr><th>Username</th><td><%=al.get(1) %></td></tr>
<tr>
<th>PassWord</th><td><%=al.get(2) %></td></tr>
<tr><th>Name</th><td><%=al.get(3) %></td></tr>
</table>
<jsp:include page="footer.html">

</jsp:include>
<%} %>