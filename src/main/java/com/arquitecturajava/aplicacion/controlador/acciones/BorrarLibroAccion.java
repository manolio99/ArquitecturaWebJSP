package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.dao.CategoriaDAO;
import com.arquitecturajava.aplicacion.dao.LibroDAO;
import com.arquitecturajava.aplicacion.dao.hibernate.CategoriaDAOHibernateImpl;
import com.arquitecturajava.aplicacion.dao.hibernate.LibroDAOHibernateImpl;
import com.arquitecturajava.aplicacion.dao.jpa.LibroDAOJPAImpl;

public class BorrarLibroAccion extends Accion {
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		LibroDAO libroDAO = new LibroDAOJPAImpl();
		//LibroDAO libroDAO = new LibroDAOHibernateImpl();
		
		String isbn = request.getParameter("isbn");
		Libro libro = new Libro(isbn);
		libroDAO.borrar(libro);
		return "MostrarLibros.do";
	}
}