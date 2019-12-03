package icesi.edu.co.stm.delegate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import icesi.edu.co.stm.model.Tmio1SitiosRuta;
import icesi.edu.co.stm.model.Tmio1SitiosRutaPK;

@Component
public class SitioRutaDelegate implements ISitioRutaDelegate {

	private final static String URI = "http://localhost:8080";

	private RestTemplate restTemplate;

	public SitioRutaDelegate() {
		// TODO Auto-generated constructor stub
		restTemplate = new RestTemplate();
	}


	@Override
	public void save(Tmio1SitiosRuta entity) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1SitiosRuta,Tmio1SitiosRutaPK> transaction = new TransactionBody<>("newBus", entity,null);
		HttpEntity<TransactionBody<Tmio1SitiosRuta,Tmio1SitiosRutaPK>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1SitiosRuta,Tmio1SitiosRutaPK>> response = null;

		response = restTemplate.exchange(URI + "/api/sitioRuta", HttpMethod.POST, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1SitiosRuta,Tmio1SitiosRutaPK>>() {
				});
	}

	@Override
	public void delete(Tmio1SitiosRutaPK id) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1SitiosRuta,Tmio1SitiosRutaPK> transaction = new TransactionBody<>("delBus", null,id);
		HttpEntity<TransactionBody<Tmio1SitiosRuta,Tmio1SitiosRutaPK>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1SitiosRuta,Tmio1SitiosRutaPK>> response = null;

		response = restTemplate.exchange(URI + "/api/sitioRuta/"+id, HttpMethod.DELETE, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1SitiosRuta,Tmio1SitiosRutaPK>>() {
				});
	}

	@Override
	public void update(Tmio1SitiosRuta entity,Tmio1SitiosRutaPK id) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1SitiosRuta,Tmio1SitiosRutaPK> transaction = new TransactionBody<>("updateBus", entity,id);
		HttpEntity<TransactionBody<Tmio1SitiosRuta,Tmio1SitiosRutaPK>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1SitiosRuta,Tmio1SitiosRutaPK>> response = null;

		response = restTemplate.exchange(URI + "/api/sitioRuta/"+id, HttpMethod.PUT, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1SitiosRuta,Tmio1SitiosRutaPK>>() {
				});
	}

	@Override
	public Tmio1SitiosRuta findById(Tmio1SitiosRutaPK id) {
		// TODO Auto-generated method stub
		
		TransactionBody<Tmio1SitiosRuta,Tmio1SitiosRutaPK> transaction = new TransactionBody<>("busId",null,  id);
		HttpEntity<TransactionBody<Tmio1SitiosRuta,Tmio1SitiosRutaPK>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1SitiosRuta,Tmio1SitiosRutaPK>> response = null;

		response = restTemplate.exchange(URI + "/api/sitioRuta/"+id, HttpMethod.GET, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1SitiosRuta,Tmio1SitiosRutaPK>>() {
				});
		try {

			Tmio1SitiosRuta sitioRuta = response.getBody().getBody();
			return sitioRuta;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Iterable<Tmio1SitiosRuta> findAll() {
		// TODO Auto-generated method stub
		TransactionBody<List<Tmio1SitiosRuta>,Integer> transaction = new TransactionBody<>("busList",new ArrayList<Tmio1SitiosRuta>());
		HttpEntity<TransactionBody<List<Tmio1SitiosRuta>,Integer>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<List<Tmio1SitiosRuta>,Integer>> response = null;
	
		response = restTemplate.exchange(URI+"/api/sitioRuta",HttpMethod.GET, request,new ParameterizedTypeReference<TransactionBody<List<Tmio1SitiosRuta>,Integer>>() {
		});
		try {
			Iterable<Tmio1SitiosRuta> sitioRuta = response.getBody().getBody();
			return sitioRuta;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	
}
