package icesi.edu.co.stm.service;

import java.util.List;

public interface IServices <T,K>{

	public void save(T entity);
	
	public void delete(T entity);
	
	public void update(T entity);
	
	public T findById(K id);
	
	public List<T> findAll();
}
