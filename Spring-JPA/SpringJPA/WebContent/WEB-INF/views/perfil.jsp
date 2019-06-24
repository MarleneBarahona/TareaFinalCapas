<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Perfil de sucursal</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/formData" method="POST" modelAttribute="sucursales">
		<form:input type="hidden" name="code" path="cSucursal" value="${sucursales.cSucursal}" />
		
		<h1>Perfil de sucursal <label>${sucursales.sNombre}</label></h1>
		
		<label>Ubicacion: </label>
		<label>${sucursales.sUbicacion}</label><br>
		
		<label>Horario: </label>
		<label>${sucursales.sHorarios}</label><br>
		
		<label>Numero de mesas : </label>
		<label>${sucursales.sNmesas}</label><br>
			
		<label>Gerente: </label>
		<label>${sucursales.sNomGerente}</label><br>
	</form:form>
	
</body>
</html>