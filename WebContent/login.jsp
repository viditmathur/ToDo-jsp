<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="Auth" method="post">
		<table><tr>
			<td>User Name :</td>
			<td><input type="text" name="uname"></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td>Login Check:</td>
			<td><input type="submit" value="Login"></td>
		</tr>
		</table>
	</form>
</body>
</html>