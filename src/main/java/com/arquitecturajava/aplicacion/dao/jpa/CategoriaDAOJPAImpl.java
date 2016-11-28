package com.arquitecturajava.aplicacion.dao.jpa;

import org.apache.log4j.Logger;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.dao.CategoriaDAO;

public class CategoriaDAOJPAImpl extends GenericDAOJPAImpl<Categoria, Integer> implements CategoriaDAO {
	private static final Logger log = Logger.getLogger(CategoriaDAOJPAImpl.class.getPackage().getName());
	
}
