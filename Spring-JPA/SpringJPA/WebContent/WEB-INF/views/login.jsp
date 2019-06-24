<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<font face="calibri,arial" color="#2E70DD"> <h1>Bienvenido a Rustico</h1></font>
	<font face="calibri,arial" color="#1C5FCD">
		<h2>LOGIN</h2>
			<form action="${pageContext.request.contextPath}/verificar" method="post">
				<label>Ingrese usuario:</label><br>
				<input type="text" name="email"><br><br>
				<label>Ingrese contrasena:</label><br>
				<input type="password" name="password"><br><br>
				<input type="submit" value="Entrar">
			</form>
	</font>

</body>
</html>