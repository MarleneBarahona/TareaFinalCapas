<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sucursales</title>
</head>
<body>
	<font color="#2856A1" face="calibri,arial">

		<form action="${pageContext.request.contextPath}/saveEmpleado" method = "post">
		<input type="submit" value="Agregar una nuev empleado"><br>
		</form>
		<h3>Listado de empleados</h3>
		<table>
			<tr>
				<th>Nombre</th>
				<th>Edad</th>
				<th>Genero</th>
				<th>Estado</th>
			</tr>
				<c:forEach items="${empleados}" var="empleados">
					<tr>
						<td>${empleados.eNombre}</td>
						<td>${empleados.eEdad}</td>
						<td>${empleados.eGenero}</td>
						<td>${empleados.eEstado}</td>
						<td>
						<form action="${pageContext.request.contextPath}/perfil" method="post">
							<input type=hidden value="nada" name="code">
							<input type="submit" value="ver perfil">
						</form>
						</td>
						<td>
						<form action="${pageContext.request.contextPath}/update" method="post">
							<input type="hidden" value="nada" name="code">
							<input type="submit" value="editar">
						</form>
						</td>
						<td>
						<form action="${pageContext.request.contextPath}/delete" method="post">
							<input type="hidden" value="nada" name="code">
							<input type="submit" value="eliminar">
						</form>
						</td>
					</tr>	
				</c:forEach>
		</table>
	</font>
</body>
</html>