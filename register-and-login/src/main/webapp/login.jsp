<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<h2>Enter your login credentials:</h2>

<form method="post" action="<%=request.getContextPath()%>/Login">
User Name:<br>
<input type="text" name="username">
<br>
Password:<br>
<input type="text" name="password">
<br>
<input type="submit" value="Login">
<br>
</form>
<br>
<a href="register.jsp">I don't have a login yet. Click here to register.</a>
</body>
</html>