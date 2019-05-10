<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="validate" method="get">
S.No<input type="number" name="s_no">
UserName<input type="text" name="username">
<input type="submit" value="Check">
</form>
<form action="update" method="post">
Task <input type="text" name="task_name" placeholder="Task Name"></input><br>
Description <input type="text" name="description" placeholder="Description"></input><br>
Status <input type="text" name="status" placeholder="Status"></input><br>
</form>

</body>
</html>