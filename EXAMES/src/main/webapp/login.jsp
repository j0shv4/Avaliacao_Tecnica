<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div align="center">
		<h2>Login</h2>
		<s:form action="LoginAction" class="loginForm">
			<s:textfield name="userName" label="Usuario" class="formTextField" />
			<s:password name="password" label="Senha" class="formTextField" />
			<s:submit value="Login" class="actionBtn" />
		</s:form>
	</div>
</body>
</html>