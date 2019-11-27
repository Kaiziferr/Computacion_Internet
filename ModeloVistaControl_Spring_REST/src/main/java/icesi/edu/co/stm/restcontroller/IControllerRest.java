package icesi.edu.co.stm.restcontroller;

import java.util.List;


public interface IControllerRest <T,K> {
	
	public void save(T entity);
	
	public void delete(K id);
	
	public void update(T entity, K id);

	public T findById(K id);
	
	public List<T> findAll();
}
