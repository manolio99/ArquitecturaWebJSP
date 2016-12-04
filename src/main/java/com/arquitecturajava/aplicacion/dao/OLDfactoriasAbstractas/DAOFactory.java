package com.arquitecturajava.aplicacion.dao.OLDfactoriasAbstractas;

import com.arquitecturajava.aplicacion.dao.CategoriaDAO;
import com.arquitecturajava.aplicacion.dao.LibroDAO;

public interface DAOFactory {
	public CategoriaDAO getCategoriaDAO();

	public LibroDAO getLibroDAO();
}
