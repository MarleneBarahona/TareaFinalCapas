<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Introducir informacion de sucursal</title>
</head>
<body>
	<font face="calibri,arial" color="#1C5FCD">
		<h2>Editar sucursal</h2>
	</font>
	<font color="#2856A1" face="calibri,arial">
		<form:form  action="${pageContext.request.contextPath}/formData" method="POST" modelAttribute="sucursales">
			<form:input type="hidden" name="code" path="cSucursal" value="${sucursales.cSucursal}" />
			<label>Nombre : </label>
			<form:input type="text" name="nombre" path="sNombre" value="${sucursales.sNombre}"/><br>
			
			<label>Ubicacion: </label>
			<form:input type="text" name="ubicacion" path="sUbicacion" value="${sucursales.sUbicacion}"/><br>
			
			<label>Horario: </label>
			<form:input type="text" name="horario" path="sHorarios" value="${sucursales.sHorarios}"/><br>
			
			<label>Numero de mesas : </label>
			<form:input type="number" name="mesas" path="sNmesas" value="${sucursales.sNmesas}"/><br>
				
			<label>Gerente: </label>
			<form:input type="text" name="gerente" path="sNomGerente" value="${sucursales.sNomGerente}"/><br><br>
				
			<input type="submit" value="Guardar">
		</form:form>
	</font>
</body>
</html>