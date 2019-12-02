package icesi.edu.co.stm.delegate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
	public void save(Tmio1Sitio entity) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1Sitio,Long> transaction = new TransactionBody<>("newSitio", entity,null);
		HttpEntity<TransactionBody<Tmio1Sitio,Long>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1Sitio,Long>> response = null;

		response = restTemplate.exchange(URI + "/api/sitio", HttpMethod.POST, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1Sitio,Long>>() {
				});
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1Sitio,Long> transaction = new TransactionBody<>("delSitio", null,id);
		HttpEntity<TransactionBody<Tmio1Sitio,Long>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1Sitio,Long>> response = null;

		response = restTemplate.exchange(URI + "/api/sitio/"+id, HttpMethod.DELETE, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1Sitio,Long>>() {
				});
	}

	@Override
	public void update(Tmio1Sitio entity,Long id) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1Sitio,Long> transaction = new TransactionBody<>("updateSitio", entity,id);
		HttpEntity<TransactionBody<Tmio1Sitio,Long>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1Sitio,Long>> response = null;

		response = restTemplate.exchange(URI + "/api/sitio/"+id, HttpMethod.PUT, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1Sitio,Long>>() {
				});
	}

	@Override
	public Tmio1Sitio findById(Long id) {
		// TODO Auto-generated method stub
		
		TransactionBody<Tmio1Sitio,Long> transaction = new TransactionBody<>("sitioId",null,  id);
		HttpEntity<TransactionBody<Tmio1Sitio,Long>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1Sitio,Long>> response = null;

		response = restTemplate.exchange(URI + "/api/sitio/"+id, HttpMethod.GET, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1Sitio,Long>>() {
				});
		try {

			Tmio1Sitio sitio = response.getBody().getBody();
			return sitio;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Iterable<Tmio1Sitio> findAll() {
		// TODO Auto-generated method stub
		TransactionBody<List<Tmio1Sitio>,Long> transaction = new TransactionBody<>("sitioList",new ArrayList<Tmio1Sitio>());
		HttpEntity<TransactionBody<List<Tmio1Sitio>,Long>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<List<Tmio1Sitio>,Long>> response = null;
	
		response = restTemplate.exchange(URI+"/api/sitio",HttpMethod.GET, request,new ParameterizedTypeReference<TransactionBody<List<Tmio1Sitio>,Long>>() {
		});
		try {
			Iterable<Tmio1Sitio> sitio = response.getBody().getBody();
			return sitio;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

}
