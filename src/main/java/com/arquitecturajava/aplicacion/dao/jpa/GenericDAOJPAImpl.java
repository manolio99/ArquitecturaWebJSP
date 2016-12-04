package com.arquitecturajava.aplicacion.dao.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.arquitecturajava.aplicacion.dao.GenericDAO;

public abstract class GenericDAOJPAImpl<T, Id extends Serializable> implements GenericDAO<T, Id> {
	private Class<T> claseDePersistencia;
	
	public EntityManagerFactory entityManagerFactory;
	
	@SuppressWarnings("unchecked")
	public GenericDAOJPAImpl() {
		this.claseDePersistencia = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Override
	public T buscarPorClave(Id id) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		T objeto = null;
		try {
			objeto = (T) manager.find(claseDePersistencia, id);
			return objeto;
		} finally {
			manager.close();
		}
	}

	@Override
	public List<T> buscarTodos() {
		EntityManager manager = entityManagerFactory.createEntityManager();
		List<T> listaDeObjetos = null;
		try {
			TypedQuery<T> consulta = manager.createQuery("select o from " + claseDePersistencia.getSimpleName() + " o",
					claseDePersistencia);
			listaDeObjetos = consulta.getResultList();
			return listaDeObjetos;
		} finally {
			manager.close();
		}
	}

	public void borrar(T objeto) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = manager.getTransaction();
			tx.begin();
			manager.remove(manager.merge(objeto));
			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
			throw e;
		} finally {
			manager.close();
		}
	}

	public void salvar(T objeto) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = manager.getTransaction();
			tx.begin();
			manager.merge(objeto);
			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
			throw e;
		} finally {
			manager.close();
		}
	}

	public void insertar(T objeto) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = manager.getTransaction();
			tx.begin();
			manager.persist(objeto);
			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
			throw e;
		} finally {
			manager.close();
		}
	}


	// GETTERS Y SETTERS
	
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

}
