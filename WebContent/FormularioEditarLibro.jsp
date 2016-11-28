<%@ page import="java.util.List"%>
<%@page import="com.arquitecturajava.aplicacion.bo.Libro"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- cabecera y javascript omitido-->
<body>
	<form id="formularioEdicion" action="SalvarLibro.do">
		<fieldset>
			<legend>Formulario edicion libro</legend>
			<p>
				<label for="isbn">ISBN:</label> <input type="text" id="isbn"
					name="isbn" value="${libro.isbn}" />
			</p>
			<p>
				<label for="titulo">Titulo:</label><input type="text" id="titulo"
					name="titulo" value="${libro.titulo}" />
			</p>
			<p>
				<label for="categoria">Categoria:</label> <select name="categoria">
					<c:forEach var="categoria" items="${listaDeCategorias}">
						<option value="${categoria.id}">${categoria.descripcion}</option>
					</c:forEach>
				</select> <br />
			</p>
			<p>
				<input type="submit" value="Salvar" />
			</p>
		</fieldset>
	</form>
</body>
</html>