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
	public Tmio1Bus save(Tmio1Bus entity) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1Bus> transaction = new TransactionBody<>("newCar", entity);
		HttpEntity<TransactionBody<Tmio1Bus>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1Bus>> response = null;

		response = restTemplate.exchange(URI + "/buses/create", HttpMethod.POST, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1Bus>>() {
				});
		System.out.println(entity);

		return entity;
		
	}

	@Override
	public Tmio1Bus delete(Tmio1Bus entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1Bus update(Tmio1Bus entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1Bus findById(Integer id) {
		// TODO Auto-generated method stub
		
		TransactionBody<Integer> transaction = new TransactionBody<>("busid",  id);
		HttpEntity<TransactionBody<Integer>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1Bus>> response = null;

		response = restTemplate.exchange(URI + "/buses/bus/"+id, HttpMethod.GET, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1Bus>>() {
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
		TransactionBody<List<Tmio1Bus>> transaction = new TransactionBody<>("busList",new ArrayList<Tmio1Bus>());
		HttpEntity<TransactionBody<List<Tmio1Bus>>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<List<Tmio1Bus>>> response = null;
	
		response = restTemplate.exchange(URI+"/buses/buses",HttpMethod.GET, request,new ParameterizedTypeReference<TransactionBody<List<Tmio1Bus>>>() {
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
