<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>LOGIN</h1>
	<form action="${pageContext.request.contextPath}/verificar" method="post">
	<input type="text" placeholder="Ingrese correo" name="email">
	<input type="text" placeholder="Ingrese contrasena" name="password">
	<input type="submit" value="Entrar">
	</form>
</body>
</html>