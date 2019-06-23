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
	<form action="${pageContext.request.contextPath}/search" method = "post">
	<label>Busqueda por codigo: </label><input type="number" placeholder="Ingrese codigo" name="code">
	<input type="submit" value="Enviar">
	</form>
	
	<form action="${pageContext.request.contextPath}/save" method = "post">
	<input type="submit" value="Agregar un nuevo usuario">
	</form>
	
	<form action="${pageContext.request.contextPath}/searchBy" method="post">
	<input type="text" name="name" placeholder="Ingrese el nombre: ">
	<input type="number" name="age" placeholder="Ingrese la edad: ">
	<button type="submit">Buscar</button>
	</form>

	<table>
		<tr>
			<th>Nombre</th>
			<th>Ubicacion</th>
			<th>Horario</th>
			<th>Mesas</th>
		</tr>
			<c:forEach items="${sucursales}" var="sucursales">
				<tr>
					<td>${sucursales.sNombre}</td>
					<td>${sucursales.sUbicacion}</td>
					<td>${sucursales.sHorarios}</td>
					<td>${sucursales.sNmesas}</td>
					<td>
					<form action="${pageContext.request.contextPath}/update" method="post">
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
</body>
</html>