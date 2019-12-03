package icesi.edu.co.stm.delegate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import org.springframework.web.client.RestTemplate;

import icesi.edu.co.stm.model.Tmio1Bus;

@Component
public class BusDelegate implements IBusDelegate{

	private final static String URI = "http://localhost:8080";
	
	private RestTemplate restTemplate;
	
	public BusDelegate() {
		restTemplate = new RestTemplate();
	}

	@Override
	public void save(Tmio1Bus entity) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1Bus,Integer> transaction = new TransactionBody<>("newBus", entity,null);
		HttpEntity<TransactionBody<Tmio1Bus,Integer>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1Bus,Integer>> response = null;

		response = restTemplate.exchange(URI + "/api/buses", HttpMethod.POST, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1Bus,Integer>>() {
				});
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1Bus,Integer> transaction = new TransactionBody<>("delBus", null,id);
		HttpEntity<TransactionBody<Tmio1Bus,Integer>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1Bus,Integer>> response = null;

		response = restTemplate.exchange(URI + "/api/buses/"+id, HttpMethod.DELETE, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1Bus,Integer>>() {
				});
	}

	@Override
	public void update(Tmio1Bus entity,Integer id) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1Bus,Integer> transaction = new TransactionBody<>("updateBus", entity,id);
		HttpEntity<TransactionBody<Tmio1Bus,Integer>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1Bus,Integer>> response = null;

		response = restTemplate.exchange(URI + "/api/buses/"+id, HttpMethod.PUT, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1Bus,Integer>>() {
				});
	}

	@Override
	public Tmio1Bus findById(Integer id) {
		// TODO Auto-generated method stub
		
		TransactionBody<Tmio1Bus,Integer> transaction = new TransactionBody<>("busId",null,  id);
		HttpEntity<TransactionBody<Tmio1Bus,Integer>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1Bus,Integer>> response = null;

		response = restTemplate.exchange(URI + "/api/buses/"+id, HttpMethod.GET, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1Bus,Integer>>() {
				});
		try {

			Tmio1Bus bust = response.getBody().getBody();
			return bust;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Iterable<Tmio1Bus> findAll() {
		// TODO Auto-generated method stub
		TransactionBody<Iterable<Tmio1Bus>,Integer> transaction = new TransactionBody<>("busList",new ArrayList<Tmio1Bus>());
		HttpEntity<TransactionBody<Iterable<Tmio1Bus>,Integer>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Iterable<Tmio1Bus>,Integer>> response = null;
	
		response = restTemplate.exchange(URI+"/api/buses",HttpMethod.GET, request,new ParameterizedTypeReference<TransactionBody<Iterable<Tmio1Bus>,Integer>>() {
		});
		try {
			Iterable<Tmio1Bus> tbus = response.getBody().getBody();
			return tbus;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	
	

}
