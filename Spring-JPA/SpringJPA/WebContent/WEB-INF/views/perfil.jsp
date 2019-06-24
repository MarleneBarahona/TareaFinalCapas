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
	<font face="calibri,arial" color="#2856A1">
		<form:form action="${pageContext.request.contextPath}/formData" method="POST" modelAttribute="sucursales">
			<form:input type="hidden" name="code" path="cSucursal" value="${sucursales.cSucursal}" />
			
			<font face="calibri,arial" color="#1C5FCD">
				<h2>Perfil de sucursal <label>${sucursales.sNombre}</label></h2>
			</font>
			
			<label>Ubicacion: </label>
			<label>${sucursales.sUbicacion}</label><br>
			
			<label>Horario: </label>
			<label>${sucursales.sHorarios}</label><br>
			
			<label>Numero de mesas : </label>
			<label>${sucursales.sNmesas}</label><br>
				
			<label>Gerente: </label>
			<label>${sucursales.sNomGerente}</label><br>
		</form:form>
		<c:forEach items="${empleados}" var="empleados">
					<tr>
						<td>${empleados.nomEmp}</td>
					</tr>
		</c:forEach><br>
		<form action="${pageContext.request.contextPath}/verEmpleados" method="post">
			<input type="hidden" value="${sucursales.cSucursal}" name="code">
			<input type="submit" value="ver empleados"><br>
		</form>
		<form action="${pageContext.request.contextPath}/volver" method="post">
			<input type="hidden" value="${sucursales.cSucursal}" name="code">
			<input type="submit" value="volver">
		</form>
	</font>
</body>
</html>