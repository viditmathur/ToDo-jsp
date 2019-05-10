
<%@ taglib uri = "http://java.sun.com/jstl/core" prefix = "c" %>

<%@page import="classes.Controllers.Task_controller"%>
<%@page import="classes.Tasks"%>
<%@page import="java.util.ArrayList" %>
<%@page import= "java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome User</title>	
</head>
<body>
  <%
  
  Task_controller t = new Task_controller();
   
   request.setAttribute("list", t.getTasksList());
  %>
  <b>TO Do Tasks</b>
<table border="1">
    <tr>
      <th>S.Number</th>
      <th>Task Name</th>
      <th>Description</th>
      <th>Status</th>
    </tr>
<%
String username= session.getAttribute("username").toString();
ArrayList<Tasks> tasklist =new ArrayList<Tasks>(t.gettodo(username));
int siz=tasklist.size();
for(int i=0; i<siz ;i++){%> 
        <%-- Arranging data in tabular form 
        --%> 
            <tr> 
                <td><%=tasklist.get(i).getS_no()%></td> 
                <td><%=tasklist.get(i).getTask_name()%></td> 
                <td><%=tasklist.get(i).getDescription()%></td>  
                <td><%=tasklist.get(i).getStatus()%></td> 
            </tr> 
            <%}%> 
  

</table>  
<a href="create.jsp"><button >Add</button></a><br>
<a href="delete.jsp"><button >Delete</button></a>

</body>
</html>