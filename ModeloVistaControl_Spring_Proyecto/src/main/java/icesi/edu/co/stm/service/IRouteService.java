package icesi.edu.co.stm.service;

import java.util.Optional;

import icesi.edu.co.stm.model.Tmio1Route;


public interface IRouteService {
	
	public void save(Tmio1Route route);

	public Optional<Tmio1Route> findById(Integer id);

	public Iterable<Tmio1Route> findAll();

	public void delete(Tmio1Route route);

}
