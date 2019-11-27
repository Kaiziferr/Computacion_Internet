package icesi.edu.co.stm.delegate;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import icesi.edu.co.stm.model.Tmio1ServiciosSitio;
import icesi.edu.co.stm.model.Tmio1ServiciosSitioPK;

@Component
public class ServiceSitioDelegate implements IServicioSitioDelegate{

	private final static String URI = "http://localhost:8080";
	
	private RestTemplate restTemplate;
	
	public ServiceSitioDelegate() {
		restTemplate = new RestTemplate();
	}

	
	@Override
	public Tmio1ServiciosSitio save(Tmio1ServiciosSitio entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1ServiciosSitio delete(Tmio1ServiciosSitio entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1ServiciosSitio update(Tmio1ServiciosSitio entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1ServiciosSitio findById(Tmio1ServiciosSitioPK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Tmio1ServiciosSitio> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
