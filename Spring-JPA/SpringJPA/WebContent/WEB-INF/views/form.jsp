<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form:form  action="${pageContext.request.contextPath}/formData" method="POST" modelAttribute="sucursal">
		
		<form:input type="hidden" name="code" path="cSucursal" value="${sucursales.cSucursal}" />
	
		<label>Ingrese un nombre : </label>
		<form:input type="text" name="nombre" path="sNombre" value="${sucursales.sNombre}"/><br>
		
		<label>Ingrese un apellido : </label>
		<form:input type="text" name="horario" path="sHorarios" value="${sucursales.sHorarios}"/><br>
		
		<label>Ingrese edad : </label>
		<form:input type="number" name="mesas" path="sNmesas" value="${sucursales.sNmesas}"/><br>
			
		<input type="submit" value="Agregar estudiante">
	</form:form>
</body>
</html>