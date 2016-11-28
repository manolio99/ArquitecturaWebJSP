<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.arquitecturajava.aplicacion.bo.Libro"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<link rel="stylesheet" type="text/css" href="css/formato.css" />
<script type="text/javascript" src="js/validacion.js"></script>
<title>Formulario Libro</title>
</head>
<body>
	<h1>Formulario alta Libro</h1>
	<form action="InsertarLibro.do" onsubmit="return validacion();">
		<fieldset>
			<legend>Formulario alta libro</legend>

			<p>
				<label for="isbn">ISBN:</label> <input id="isbn" type="text"
					name="isbn" />
			</p>
			<p>
				<label for="titulo">Titulo:</label> <input id="titulo" type="text"
					name="titulo" />
			</p>
			<p>
				<select name="categoria">
					<option value="seleccionar">seleccionar</option>
					<c:forEach var="categoria" items="${listaDeCategorias}">
						<option value="${categoria.id}">${categoria.descripcion}</option>
					</c:forEach>
				</select> <br />
			</p>

			<p>
				<input type="submit" value="InsertarLibro" />
			</p>
		</fieldset>
	</form>
</body>
</html>