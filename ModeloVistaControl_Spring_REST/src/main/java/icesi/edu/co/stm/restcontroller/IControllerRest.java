package icesi.edu.co.stm.restcontroller;

import icesi.edu.co.stm.delegate.TransactionBody;

public interface IControllerRest <T,K> {
	
	public void save(TransactionBody<T,K> entity);
	
	public void delete(K id);
	
	public void update(T entity, K id);

	public TransactionBody<T,K> findById(K id);
		
	public TransactionBody<Iterable<T>, K> findAll();
}
