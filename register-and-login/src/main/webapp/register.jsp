<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new account: </title>
</head>
<body>

<h2>Enter your information below:</h2>

<form method="post" action="<%=request.getContextPath()%>/RegisterUser">
First Name:<br>
<input type="text" name="firstname">
<br>
Last Name:<br>
<input type="text" name="lastname">
<br>
User Name:<br>
<input type="text" name="username">
<br>
Password:<br>
<input type="text" name="password">
<br>
<input type="submit" value="Register">
<br>
</form>

<a href="login.jsp">I'm already registered, continue to login</a>

</body>
</html>