package icesi.edu.co.stm.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public interface IController<T, K> {

	public String getALL(Model model);

	public T get(K id);

	public String add(Model model);
	
	public String save(T entity, BindingResult bindingResult, String action, Model model);

	public void update(T entity, K id);

	public String delete(T entity, BindingResult bindingResult, String action, K id);
	

}
