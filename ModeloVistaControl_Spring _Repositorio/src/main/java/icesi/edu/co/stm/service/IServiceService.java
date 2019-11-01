package icesi.edu.co.stm.service;

import java.util.Optional;

import icesi.edu.co.stm.model.Tmio1Servicio;
import icesi.edu.co.stm.model.Tmio1ServicioPK;

public interface IServiceService {
	
	public void save(Tmio1Servicio service);

	public Optional<Tmio1Servicio> findById(Tmio1ServicioPK id);

	public Iterable<Tmio1Servicio> findAll();

	public void delete(Tmio1Servicio service);
}
