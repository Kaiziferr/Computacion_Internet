package icesi.edu.co.stm.delegate;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import icesi.edu.co.stm.model.Tmio1Route;

@Component
public class RouteDelegate implements IRouteDelegate{

	private final static String URI = "http://localhost:8080";
	
	private RestTemplate restTemplate;
	
	public RouteDelegate() {
		restTemplate = new RestTemplate();
	}
	
	@Override
	public Tmio1Route save(Tmio1Route entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1Route delete(Tmio1Route entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1Route update(Tmio1Route entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1Route findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Tmio1Route> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
