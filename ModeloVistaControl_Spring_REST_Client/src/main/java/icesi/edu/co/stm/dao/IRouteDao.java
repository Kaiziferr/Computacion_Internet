package icesi.edu.co.stm.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import icesi.edu.co.stm.model.Tmio1Route;
import icesi.edu.co.stm.model.Tmio1Servicio;

public interface IRouteDao extends IDao<Tmio1Route, Integer>{
	
	public List<Tmio1Route> findByDay(BigDecimal startDay, BigDecimal finalDay);
	
	public List<Tmio1Route> findByHour(BigDecimal startHour, BigDecimal finalHour);
	
	public List<Tmio1Servicio> findByRoutesLessDate(LocalDate dateService);

}
