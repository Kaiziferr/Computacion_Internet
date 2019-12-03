package icesi.edu.co.stm.dao;

import java.util.List;

public interface IDao <T,K>{
	
	public void save(T entity);
	
	public void update(T entity);
	
	public void delete(T entity);
	
	public T findById(K id);
	
	public Iterable<T> findAll();
	
}
