package com.arquitecturajava.aplicacion.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, Id extends Serializable> {
	T buscarPorClave(Id id);

	List<T> buscarTodos();

	void salvar(T objeto);

	void borrar(T objeto);
}