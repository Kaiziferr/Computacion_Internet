package icesi.edu.co.stm.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import icesi.edu.co.stm.StmApplication;
import icesi.edu.co.stm.model.Tmio1Bus;

@Service
public class BusDelegate implements IBusDelegate{
	
	private String URI = "http://localhost:8080/";
	
	@Autowired
	private RestTemplate restTemplate;
	

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
	public List<Tmio1Bus> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
