package icesi.edu.co.stm.dao;

import java.math.BigDecimal;
import java.util.List;

import icesi.edu.co.stm.model.Tmio1Route;

public interface IRouteDao extends IDao<Tmio1Route, Integer>{
	
	public List<Tmio1Route> findByDate(BigDecimal startDay, BigDecimal finalDay);
	
	public List<Tmio1Route> findByHour(BigDecimal startHour, BigDecimal finalHour);
}
