package icesi.edu.co.stm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import icesi.edu.co.stm.model.Tmio1Route;
import icesi.edu.co.stm.repository.IRouteRepository;
@Service
public class RouteService implements IRouteService{

	private IRouteRepository routeRepository;
	
	@Autowired
	public RouteService(IRouteRepository routeRepository) {
		// TODO Auto-generated constructor stub
		this.routeRepository = routeRepository;
	}
	
	@Override
	public void save(Tmio1Route route) {
		// TODO Auto-generated method stub
		routeRepository.save(route);
	}

	@Override
	public Optional<Tmio1Route> findById(Integer id) {
		// TODO Auto-generated method stub
		return routeRepository.findById(id);
	}

	@Override
	public Iterable<Tmio1Route> findAll() {
		// TODO Auto-generated method stub
		return routeRepository.findAll();
	}

	@Override
	public void delete(Tmio1Route route) {
		// TODO Auto-generated method stub
		
	}

}
