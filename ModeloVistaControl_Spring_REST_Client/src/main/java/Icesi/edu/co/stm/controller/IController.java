package Icesi.edu.co.stm.controller;

public interface IController <T,K>{
	
	public Iterable<T> getALL();
	
	public T get();
}
