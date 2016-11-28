package com.arquitecturajava.aplicacion.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.arquitecturajava.aplicacion.HibernateHelper;
import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.dao.CategoriaDAO;

public class CategoriaDAOHibernateImpl implements CategoriaDAO {

	public List<Categoria> buscarTodos() {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		List<Categoria> listaDeCategorias = session.createQuery(" from Categoria categoria").list();
		return listaDeCategorias;
	}
	
	public Categoria buscarPorClave(Integer id) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		Query consulta = session.createQuery(" from Categoria c where c.id=:categoria");
		consulta.setString("categoria", Integer.toString(id));
		Categoria categoria = (Categoria) consulta.uniqueResult();
		return categoria;
	}
}
