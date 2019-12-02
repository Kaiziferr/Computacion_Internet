package icesi.edu.co.stm.delegate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
	public void save(Tmio1Servicio entity) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1Servicio,Tmio1ServicioPK> transaction = new TransactionBody<>("newService", entity,null);
		HttpEntity<TransactionBody<Tmio1Servicio,Tmio1ServicioPK>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1Servicio,Tmio1ServicioPK>> response = null;

		response = restTemplate.exchange(URI + "/api/service", HttpMethod.POST, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1Servicio,Tmio1ServicioPK>>() {
				});
	}

	@Override
	public void delete(Tmio1ServicioPK id) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1Servicio,Tmio1ServicioPK> transaction = new TransactionBody<>("delService", null,id);
		HttpEntity<TransactionBody<Tmio1Servicio,Tmio1ServicioPK>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1Servicio,Tmio1ServicioPK>> response = null;

		response = restTemplate.exchange(URI + "/api/service/"+id, HttpMethod.DELETE, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1Servicio,Tmio1ServicioPK>>() {
				});
	}

	@Override
	public void update(Tmio1Servicio entity,Tmio1ServicioPK id) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1Servicio,Tmio1ServicioPK> transaction = new TransactionBody<>("updateBus", entity,id);
		HttpEntity<TransactionBody<Tmio1Servicio,Tmio1ServicioPK>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1Servicio,Tmio1ServicioPK>> response = null;

		response = restTemplate.exchange(URI + "/api/service/"+id, HttpMethod.PUT, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1Servicio,Tmio1ServicioPK>>() {
				});
	}

	@Override
	public Tmio1Servicio findById(Tmio1ServicioPK id) {
		// TODO Auto-generated method stub
		
		TransactionBody<Tmio1Servicio,Tmio1ServicioPK> transaction = new TransactionBody<>("busId",null,  id);
		HttpEntity<TransactionBody<Tmio1Servicio,Tmio1ServicioPK>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1Servicio,Tmio1ServicioPK>> response = null;

		response = restTemplate.exchange(URI + "/api/service/"+id, HttpMethod.GET, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1Servicio,Tmio1ServicioPK>>() {
				});
		try {

			Tmio1Servicio bust = response.getBody().getBody();
			return bust;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Iterable<Tmio1Servicio> findAll() {
		// TODO Auto-generated method stub
		TransactionBody<List<Tmio1Servicio>,Tmio1ServicioPK> transaction = new TransactionBody<>("busList",new ArrayList<Tmio1Servicio>());
		HttpEntity<TransactionBody<List<Tmio1Servicio>,Tmio1ServicioPK>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<List<Tmio1Servicio>,Tmio1ServicioPK>> response = null;
	
		response = restTemplate.exchange(URI+"/api/service",HttpMethod.GET, request,new ParameterizedTypeReference<TransactionBody<List<Tmio1Servicio>,Tmio1ServicioPK>>() {
		});
		try {
			Iterable<Tmio1Servicio> tService = response.getBody().getBody();
			return  tService;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
}
