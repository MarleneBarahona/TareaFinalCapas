<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar sucursal</title>
</head>
<body>
	<font face="calibri,arial" color="#1C5FCD">
		<h2>Introducir informacion de empleado</h2>
	</font>
	<font color="#2856A1" face="calibri,arial">
		<form:form  action="${pageContext.request.contextPath}/formDataEmpleado" method="POST" modelAttribute="empleados">
			<form:input type="hidden" name="code" path="cEmpleado" value="${empleados.cEmpleado}" />
			<label>Nombre : </label>
			<form:input type="text" name="nombre" path="eNombre" value="${empleados.eNombre}"/><br>
			
			<label>Edad: </label>
			<form:input type="text" name="edad" path="eEdad" value="${empleados.eEdad}"/><br>
			
			<label>Genero: </label>
			<form:input type="text" name="genero" path="eGenero" value="${empleados.eGenero}"/><br>
			
			<label>Estado del empleado: </label>
			<form:input type="number" name="estado" path="eEstado" value="${empleados.eEstado}"/><br>
				
			<input type="submit" value="Guardar">
		</form:form>
	</font>
</body>
</html>