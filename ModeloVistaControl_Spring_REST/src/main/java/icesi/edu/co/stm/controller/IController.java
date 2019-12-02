package icesi.edu.co.stm.controller;

public interface IController <T,K>{
	
	public Iterable<T> getALL();
	
	public T get(K id);
	
	public void add(T entity);
	
	public void update(T entity, K id);
	
	public void delete(K id);
	
}
