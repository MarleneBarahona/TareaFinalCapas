<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<font face="calibri,arial" color="#1C5FCD">
		<h1>LOGIN</h1>
			<form action="${pageContext.request.contextPath}/prueba" method="post">
				<label>Ingrese correo:</label><br>
				<input type="text" placeholder="usuario@gmail.com" name="email"><br><br>
				<label>Ingrese contrasena:</label><br>
				<input type="password" placeholder="pass123" name="password"><br><br>
				<input type="submit" value="Entrar">
			</form>
	</font>

</body>
</html>