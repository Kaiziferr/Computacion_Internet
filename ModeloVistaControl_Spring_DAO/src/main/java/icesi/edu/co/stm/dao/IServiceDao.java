package icesi.edu.co.stm.dao;

import java.time.LocalDate;
import java.util.List;

import icesi.edu.co.stm.model.Tmio1Servicio;
import icesi.edu.co.stm.model.Tmio1ServicioPK;

public interface IServiceDao extends IDao<Tmio1Servicio, Tmio1ServicioPK>{
	
	public List<Tmio1Servicio> findByDateDriversItinerary(LocalDate dateService);
	
	public List<Tmio1Servicio> findByRoutesLessDate(LocalDate dateService);
	
	public List<Tmio1Servicio> findBylistBusesMoreServiceSameDay(LocalDate dateService);
}
