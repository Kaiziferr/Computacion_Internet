package icesi.edu.co.stm.dao;

import java.time.LocalDate;
import java.util.List;

import icesi.edu.co.stm.model.Tmio1BusDriver;
import icesi.edu.co.stm.model.Tmio1Servicio;

public interface IBusDriverDao extends IDao<Tmio1BusDriver, String>{
	
	public List<Tmio1BusDriver> findByName(String name);
	
	public List<Tmio1BusDriver> findByLastName(String lastname);
	
	public List<Tmio1BusDriver> findByDateDriversItinerary(LocalDate dateService);
	
}
