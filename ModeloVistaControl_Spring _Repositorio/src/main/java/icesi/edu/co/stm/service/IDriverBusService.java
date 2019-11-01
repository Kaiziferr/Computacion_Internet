package icesi.edu.co.stm.service;

import java.util.Optional;

import icesi.edu.co.stm.model.Tmio1BusDriver;

public interface IDriverBusService {

	public void save(Tmio1BusDriver busdriver);

	public Optional<Tmio1BusDriver> findById(String id);

	public Iterable<Tmio1BusDriver> findAll(boolean flag);

	public void delete(Tmio1BusDriver bus);
	
	public  void setCed(String ced);
}
