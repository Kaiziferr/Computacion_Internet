package icesi.edu.co.stm.delegate;

import java.util.List;

public interface IDelegate<T, K>{
	
	public T save(T entity);
	
	public T delete(T entity);
	
	public T update(T entity);
	
	public T findById(K id);
	
	public Iterable<T> findAll();

}
