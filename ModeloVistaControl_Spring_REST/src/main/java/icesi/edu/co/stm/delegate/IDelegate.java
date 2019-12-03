package icesi.edu.co.stm.delegate;

public interface IDelegate<T, K>{
	
	public void save(T entity);
	
	public void delete(K id);
	
	public void update(T entity, K id);
	
	public T findById(K id);
	
	public Iterable<T> findAll();

}
