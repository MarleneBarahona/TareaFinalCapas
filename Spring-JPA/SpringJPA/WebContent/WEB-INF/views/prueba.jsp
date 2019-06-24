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
	<font face="calibri,arial" color="#1C5FCD"> <h1>Bienvenido</h1></font>
	<font color="#2856A1" face="calibri,arial">

		<form action="${pageContext.request.contextPath}/save" method = "post">
		<input type="submit" value="Agregar una nueva sucursal"><br>
		</form>
		<h3>Listado de sucursales</h3>
		<table>
			<tr>
				<th>Nombre</th>
				<th>Ubicacion</th>
				<th>Horario</th>
				<th>Mesas</th>
				<th>Gerente</th>
			</tr>
				<c:forEach items="${sucursales}" var="sucursales">
					<tr>
						<td>${sucursales.sNombre}</td>
						<td>${sucursales.sUbicacion}</td>
						<td>${sucursales.sHorarios}</td>
						<td>${sucursales.sNmesas}</td>
						<td>${sucursales.sNomGerente}</td>
						<td>
						<form action="${pageContext.request.contextPath}/perfil" method="post">
							<input type=hidden value="${sucursales.cSucursal}" name="code">
							<input type="submit" value="ver perfil">
						</form>
						</td>
						<td>
						<form action="${pageContext.request.contextPath}/update" method="post">
							<input type="hidden" value="${sucursales.cSucursal}" name="code">
							<input type="submit" value="editar">
						</form>
						</td>
						<td>
						<form action="${pageContext.request.contextPath}/delete" method="post">
							<input type="hidden" value="${sucursales.cSucursal}" name="code">
							<input type="submit" value="eliminar">
						</form>
						</td>
					</tr>	
				</c:forEach>
		</table>
	</font>
</body>
</html>