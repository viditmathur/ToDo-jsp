<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Task</title>
</head>
<body>
<%
String Username= session.getAttribute("username").toString();
request.setAttribute("username", Username);
%>
<b>Create a new Task</b>
<form action="create" method="post">
S.No<input type="number" name="s_no" placeholder="S.No"></input><br>
Task <input type="text" name="task_name" placeholder="Task Name"></input><br>
Description <input type="text" name="description" placeholder="Description"></input><br>
Status <input type="text" name="status" placeholder="Status"></input><br>
<input type="submit" value="Add"></input>
</form>
</body>
</html>