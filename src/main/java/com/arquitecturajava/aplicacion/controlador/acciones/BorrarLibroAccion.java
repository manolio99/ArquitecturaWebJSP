package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.servicios.ServicioLibros;

public class BorrarLibroAccion extends Accion {
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServicioLibros servicioLibros = (ServicioLibros) getBean("servicioLibros", request);

		String isbn = request.getParameter("isbn");
		Libro libro = new Libro(isbn);
		servicioLibros.borrarLibro(libro);
		return "MostrarLibros.do";
	}
}