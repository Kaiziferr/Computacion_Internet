package icesi.edu.co.stm.service;

import java.util.Optional;

import icesi.edu.co.stm.model.Tmio1Bus;

public interface IBusService {
	
	public void save(Tmio1Bus bus);

	public Optional<Tmio1Bus> findById(Integer id);

	public Iterable<Tmio1Bus> findAll();

	public void delete(Tmio1Bus bus);
}
