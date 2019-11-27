package icesi.edu.co.stm.delegate;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import icesi.edu.co.stm.model.Tmio1Sitio;

@Component
public class SitioDelegate implements ISitioDelegate{


	private final static String URI = "http://localhost:8080";
	
	private RestTemplate restTemplate;
	
	public SitioDelegate() {
		restTemplate = new RestTemplate();
	}
	
	@Override
	public Tmio1Sitio save(Tmio1Sitio entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1Sitio delete(Tmio1Sitio entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1Sitio update(Tmio1Sitio entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1Sitio findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Tmio1Sitio> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
