package icesi.edu.co.stm.delegate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import icesi.edu.co.stm.model.Tmio1Route;

@Component
public class RouteDelegate implements IRouteDelegate{

	private final static String URI = "http://localhost:8080";
	
	private RestTemplate restTemplate;
	
	public RouteDelegate() {
		restTemplate = new RestTemplate();
	}

	@Override
	public void save(Tmio1Route entity) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1Route,Integer> transaction = new TransactionBody<>("newRoute", entity,null);
		HttpEntity<TransactionBody<Tmio1Route,Integer>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1Route,Integer>> response = null;

		response = restTemplate.exchange(URI + "/api/route", HttpMethod.POST, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1Route,Integer>>() {
				});
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1Route,Integer> transaction = new TransactionBody<>("delRoute", null,id);
		HttpEntity<TransactionBody<Tmio1Route,Integer>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1Route,Integer>> response = null;

		response = restTemplate.exchange(URI + "/api/route/"+id, HttpMethod.DELETE, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1Route,Integer>>() {
				});
	}

	@Override
	public void update(Tmio1Route entity,Integer id) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1Route,Integer> transaction = new TransactionBody<>("updateRoute", entity,id);
		HttpEntity<TransactionBody<Tmio1Route,Integer>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1Route,Integer>> response = null;

		response = restTemplate.exchange(URI + "/api/route/"+id, HttpMethod.PUT, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1Route,Integer>>() {
				});
	}

	@Override
	public Tmio1Route findById(Integer id) {
		// TODO Auto-generated method stub
		
		TransactionBody<Tmio1Route,Integer> transaction = new TransactionBody<>("routeId",null,  id);
		HttpEntity<TransactionBody<Tmio1Route,Integer>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1Route,Integer>> response = null;

		response = restTemplate.exchange(URI + "/api/route/"+id, HttpMethod.GET, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1Route,Integer>>() {
				});
		try {

			Tmio1Route route = response.getBody().getBody();
			return route;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Iterable<Tmio1Route> findAll() {
		// TODO Auto-generated method stub
		TransactionBody<List<Tmio1Route>,Integer> transaction = new TransactionBody<>("routeList",new ArrayList<Tmio1Route>());
		HttpEntity<TransactionBody<List<Tmio1Route>,Integer>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<List<Tmio1Route>,Integer>> response = null;
	
		response = restTemplate.exchange(URI+"/api/route",HttpMethod.GET, request,new ParameterizedTypeReference<TransactionBody<List<Tmio1Route>,Integer>>() {
		});
		try {
			Iterable<Tmio1Route> routes = response.getBody().getBody();
			return routes;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	

}
