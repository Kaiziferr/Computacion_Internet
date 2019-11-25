package icesi.edu.co.stm.delegate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import icesi.edu.co.stm.StmApplication;
import icesi.edu.co.stm.model.Tmio1Bus;

@Component
public class BusDelegate implements IBusDelegate{

	private final static String URI = "http://localhost:8080/";
	
	private RestTemplate restTemplate;
	
	public BusDelegate() {
		restTemplate = new RestTemplate();
	}

	
	@Override
	public void save(Tmio1Bus entity) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1Bus> transaction = new TransactionBody<>("apiContext",entity);
		HttpEntity<TransactionBody<Tmio1Bus>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1Bus>> response = null;
		
		try {
			response = restTemplate.exchange(URI+"/buses/create", HttpMethod.POST, request, new ParameterizedTypeReference<TransactionBody<Tmio1Bus>>() {
			
			});
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.getBody();
		
	}

	@Override
	public void delete(Tmio1Bus entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Tmio1Bus entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tmio1Bus findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
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
