package icesi.edu.co.stm.delegate;

import java.util.List;

public interface IDelegate<T, K>{
	
	public void save(T entity);
	
	public void delete(T entity);
	
	public void update(T entity);
	
	public T findById(K id);
	
	public List<T> findAll();

}
