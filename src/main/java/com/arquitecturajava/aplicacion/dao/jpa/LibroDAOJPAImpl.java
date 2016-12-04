package com.arquitecturajava.aplicacion.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.dao.LibroDAO;

public class LibroDAOJPAImpl extends GenericDAOJPAImpl<Libro, String> implements LibroDAO {
	private static final Logger log = Logger.getLogger(LibroDAOJPAImpl.class.getPackage().getName());

	public List<Libro> buscarPorCategoria(Categoria categoria) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		TypedQuery<Libro> consulta = manager.createQuery("Select l from Libro l where l.categoria=?1", Libro.class);
		consulta.setParameter(1, categoria);
		List<Libro> listaDeLibros = null;
		try {
			listaDeLibros = consulta.getResultList();
		} finally {
			manager.close();
			return listaDeLibros;
		}
	}
	
	@Override
	public List<Libro> buscarTodos() {
		EntityManager manager = entityManagerFactory.createEntityManager();
		List<Libro> listaDeLibros = null;
		try {
			TypedQuery<Libro> consulta = manager.createQuery("SELECT l FROM Libro l JOIN FETCH l.categoria",Libro.class);
			listaDeLibros = consulta.getResultList();
			return listaDeLibros;
		} finally {
			manager.close();
		}
	}

}