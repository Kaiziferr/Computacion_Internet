package icesi.edu.co.stm.dao;

import java.math.BigDecimal;
import java.util.List;

import icesi.edu.co.stm.model.Tmio1Bus;

public interface IBusDao extends IDao<Tmio1Bus, Integer>{
	
	public List<Tmio1Bus> findByPlaca(String placa);
	
	public List<Tmio1Bus> findByModelo(BigDecimal modelo);
	
	public List<Tmio1Bus> findByMarca(String marca);
}
