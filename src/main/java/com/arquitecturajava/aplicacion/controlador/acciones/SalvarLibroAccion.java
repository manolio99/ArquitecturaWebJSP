
package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.dao.LibroDAO;
import com.arquitecturajava.aplicacion.dao.hibernate.LibroDAOHibernateImpl;
import com.arquitecturajava.aplicacion.dao.jpa.LibroDAOJPAImpl;

public class SalvarLibroAccion extends Accion {
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		LibroDAO libroDAO = new LibroDAOJPAImpl();
		//LibroDAO libroDAO = new LibroDAOHibernateImpl();
		
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria");
		Categoria objetoCategoria = new Categoria(Integer.parseInt(categoria));
		Libro libro = new Libro(isbn, titulo, objetoCategoria);
		libroDAO.salvar(libro);
		return "MostrarLibros.do";
	}
}