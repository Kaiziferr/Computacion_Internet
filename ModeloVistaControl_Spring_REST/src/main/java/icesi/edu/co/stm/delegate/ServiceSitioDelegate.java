package icesi.edu.co.stm.delegate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
	public void save(Tmio1ServiciosSitio entity) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1ServiciosSitio,Tmio1ServiciosSitioPK> transaction = new TransactionBody<>("newServicioSitio", entity,null);
		HttpEntity<TransactionBody<Tmio1ServiciosSitio,Tmio1ServiciosSitioPK>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1ServiciosSitio,Tmio1ServiciosSitioPK>> response = null;

		response = restTemplate.exchange(URI + "/api/servicesitio", HttpMethod.POST, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1ServiciosSitio,Tmio1ServiciosSitioPK>>() {
				});
	}

	@Override
	public void delete(Tmio1ServiciosSitioPK id) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1ServiciosSitio,Tmio1ServiciosSitioPK> transaction = new TransactionBody<>("delBus", null,id);
		HttpEntity<TransactionBody<Tmio1ServiciosSitio,Tmio1ServiciosSitioPK>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1ServiciosSitio,Tmio1ServiciosSitioPK>> response = null;

		response = restTemplate.exchange(URI + "/api/servicesitio/"+id, HttpMethod.DELETE, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1ServiciosSitio,Tmio1ServiciosSitioPK>>() {
				});
	}

	@Override
	public void update(Tmio1ServiciosSitio entity,Tmio1ServiciosSitioPK id) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1ServiciosSitio,Tmio1ServiciosSitioPK> transaction = new TransactionBody<>("updateBus", entity,id);
		HttpEntity<TransactionBody<Tmio1ServiciosSitio,Tmio1ServiciosSitioPK>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1ServiciosSitio,Tmio1ServiciosSitioPK>> response = null;

		response = restTemplate.exchange(URI + "/api/servicesitio/"+id, HttpMethod.PUT, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1ServiciosSitio,Tmio1ServiciosSitioPK>>() {
				});
	}

	@Override
	public Tmio1ServiciosSitio findById(Tmio1ServiciosSitioPK id) {
		// TODO Auto-generated method stub
		
		TransactionBody<Tmio1ServiciosSitio,Tmio1ServiciosSitioPK> transaction = new TransactionBody<>("busId",null,  id);
		HttpEntity<TransactionBody<Tmio1ServiciosSitio,Tmio1ServiciosSitioPK>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1ServiciosSitio,Tmio1ServiciosSitioPK>> response = null;

		response = restTemplate.exchange(URI + "/api/servicesitio/"+id, HttpMethod.GET, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1ServiciosSitio,Tmio1ServiciosSitioPK>>() {
				});
		try {

			Tmio1ServiciosSitio serviciosSitios = response.getBody().getBody();
			return serviciosSitios;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Iterable<Tmio1ServiciosSitio> findAll() {
		// TODO Auto-generated method stub
		TransactionBody<List<Tmio1ServiciosSitio>,Tmio1ServiciosSitioPK> transaction = new TransactionBody<>("busList",new ArrayList<Tmio1ServiciosSitio>());
		HttpEntity<TransactionBody<List<Tmio1ServiciosSitio>,Tmio1ServiciosSitioPK>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<List<Tmio1ServiciosSitio>,Tmio1ServiciosSitioPK>> response = null;
	
		response = restTemplate.exchange(URI+"/api/servicesitio/",HttpMethod.GET, request,new ParameterizedTypeReference<TransactionBody<List<Tmio1ServiciosSitio>,Tmio1ServiciosSitioPK>>() {
		});
		try {
			Iterable<Tmio1ServiciosSitio> tService = response.getBody().getBody();
			return  tService;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	

}
