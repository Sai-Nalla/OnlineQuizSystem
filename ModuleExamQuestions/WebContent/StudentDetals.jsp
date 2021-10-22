
<%@ page import="java.util.*,com.nt.bean.StudentBean" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%RequestDispatcher rd=request.getRequestDispatcher("/home.jsp");
		rd.include(request, response);%>
    
    <%List<StudentBean> stulist=(List<StudentBean>)request.getAttribute("DetailsList") ;%>
    <html>
    <body>
    <h1 style="color:Blue">StudentDetails</h1>
    <nav>
    <table border="1">
  <th>  <a style="font-size:50px;color:cyan">Student_id</a></th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <th> <a style="font-size:50px;color:cyan">StudentName</a></th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <th> <a style="font-size:50px;color:cyan">Address</a></th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <%for(StudentBean bean:stulist) {%>
    <tr>
   <td> <a style="font-size:50px;color:black;"><%= bean.getStudent_id()%></td></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <td><a  style="font-size:50px;color:black;"><%= bean.getStudentName()%></a></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <td><a  style="font-size:50px;color:black;"><%= bean.getAddres()%></a></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  
   <td> <a  href="getStudenturl?id=<%=bean.getStudent_id()%>"><button  style="color:green;background:black;size: 50px">Update</button></a></td>
     <td><a  href="DeleteStudenturl?id=<%=bean.getStudent_id()%>"><button  style="color:green;background:black">Delete</button></a></td>
       </tr>
       
    <%} %>
       </table>
    </nav>
    </body>
    </html>
