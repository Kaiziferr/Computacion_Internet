package icesi.edu.co.stm.delegate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
	public void save(Tmio1BusDriver entity) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1BusDriver,String> transaction = new TransactionBody<>("newBusDriver", entity,null);
		HttpEntity<TransactionBody<Tmio1BusDriver,String>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1BusDriver,String>> response = null;

		response = restTemplate.exchange(URI + "/api/busDriver", HttpMethod.POST, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1BusDriver,String>>() {
				});
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1BusDriver,String> transaction = new TransactionBody<>("delBusDriver", null,id);
		HttpEntity<TransactionBody<Tmio1BusDriver,String>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1BusDriver,String>> response = null;

		response = restTemplate.exchange(URI + "/api/busDriver/"+id, HttpMethod.DELETE, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1BusDriver,String>>() {
				});
	}

	@Override
	public void update(Tmio1BusDriver entity, String id) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1BusDriver,String> transaction = new TransactionBody<>("updateBusDriver", entity,id);
		HttpEntity<TransactionBody<Tmio1BusDriver,String>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1BusDriver,String>> response = null;

		response = restTemplate.exchange(URI + "/api/busDriver/"+id, HttpMethod.PUT, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1BusDriver,String>>() {
				});
	}

	@Override
	public Tmio1BusDriver findById(String id) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1BusDriver,String> transaction = new TransactionBody<>("busId",null,  id);
		HttpEntity<TransactionBody<Tmio1BusDriver,String>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1BusDriver,String>> response = null;

		response = restTemplate.exchange(URI + "/api/busDriver/"+id, HttpMethod.GET, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1BusDriver,String>>() {
				});
		try {

			Tmio1BusDriver tBusDriver = response.getBody().getBody();
			return tBusDriver;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Iterable<Tmio1BusDriver> findAll() {
		// TODO Auto-generated method stub
		TransactionBody<List<Tmio1BusDriver>,String> transaction = new TransactionBody<>("busList",new ArrayList<Tmio1BusDriver>());
		HttpEntity<TransactionBody<List<Tmio1BusDriver>,String>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<List<Tmio1BusDriver>,String>> response = null;
	
		response = restTemplate.exchange(URI+"/api/busDriver",HttpMethod.GET, request,new ParameterizedTypeReference<TransactionBody<List<Tmio1BusDriver>,String>>() {
		});
		try {
			Iterable<Tmio1BusDriver> tBusDriver = response.getBody().getBody();
			return tBusDriver;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
}
