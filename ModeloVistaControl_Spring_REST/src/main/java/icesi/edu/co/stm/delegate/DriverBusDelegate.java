package icesi.edu.co.stm.delegate;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import icesi.edu.co.stm.model.Tmio1BusDriver;

@Component
public class DriverBusDelegate implements IDriverBusDelegate{

	private final static String URI = "http://localhost:8080";

	private RestTemplate restTemplate;
	
	public DriverBusDelegate() {
		restTemplate = new RestTemplate();
	}
	
	@Override
	public Tmio1BusDriver save(Tmio1BusDriver entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1BusDriver delete(Tmio1BusDriver entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1BusDriver update(Tmio1BusDriver entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1BusDriver findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Tmio1BusDriver> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
