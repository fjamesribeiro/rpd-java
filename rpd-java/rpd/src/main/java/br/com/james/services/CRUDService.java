package br.com.james.services;

import java.util.List;

public interface CRUDService<T> {
	public List<T> findAll();

	public T findById(Long id);

	public T update(T t);

	public T create(T t);

	public void delete(Long id);

}
