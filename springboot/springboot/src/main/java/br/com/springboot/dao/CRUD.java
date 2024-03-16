package br.com.springboot.dao;

import java.util.List;

public interface CRUD<T, ID>{
	T pesquisaPeloid(ID id);
	List<T> lista();
	void insere(T t);
	void atualizar(T t);
	void remove (T t);
}
