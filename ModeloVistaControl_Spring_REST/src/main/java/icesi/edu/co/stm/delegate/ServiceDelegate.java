package icesi.edu.co.stm.delegate;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import icesi.edu.co.stm.model.Tmio1Servicio;
import icesi.edu.co.stm.model.Tmio1ServicioPK;

@Component
public class ServiceDelegate implements IServiceDelegate{

	private final static String URI = "http://localhost:8080";
	
	private RestTemplate restTemplate;
	
	public ServiceDelegate() {
		restTemplate = new RestTemplate();
	}
	
	
	@Override
	public Tmio1Servicio save(Tmio1Servicio entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1Servicio delete(Tmio1Servicio entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1Servicio update(Tmio1Servicio entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1Servicio findById(Tmio1ServicioPK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Tmio1Servicio> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
