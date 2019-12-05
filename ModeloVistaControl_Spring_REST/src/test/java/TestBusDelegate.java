import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import icesi.edu.co.stm.delegate.IBusDelegate;
import icesi.edu.co.stm.delegate.TransactionBody;
import icesi.edu.co.stm.model.Tmio1Bus;

@SpringBootTest
public class TestBusDelegate {
	
	private final static String URI = "http://localhost:8080";
	@Mock
	private RestTemplate restTemplate;
	@Autowired
	@InjectMocks
	private IBusDelegate iBusDelegate;
	
	
	@BeforeMethod
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void save() {
		
		Tmio1Bus bus = new Tmio1Bus();
		bus.setCapacidad(new BigDecimal(160));
		bus.setMarca("Mazda");
		bus.setModelo(new BigDecimal(2));
		bus.setPlaca("xyz-234");
		bus.setTipo("T");
		
		TransactionBody<Tmio1Bus,Integer> transaction = new TransactionBody<>("newBus", bus,null);
		HttpEntity<TransactionBody<Tmio1Bus,Integer>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1Bus,Integer>> response = null;

		response = restTemplate.exchange(URI + "/api/buses", HttpMethod.POST, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1Bus,Integer>>() {
				});
		
		
		TransactionBody<Tmio1Bus,Integer> transaction2 = new TransactionBody<>("busId",null,bus.getId());
		HttpEntity<TransactionBody<Tmio1Bus,Integer>> request2 = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Tmio1Bus,Integer>> response2 = null;

		when(restTemplate.exchange(URI + "/api/buses/"+bus.getId(), HttpMethod.GET, request,
				new ParameterizedTypeReference<TransactionBody<Tmio1Bus,Integer>>() {
				})).thenReturn();
		Tmio1Bus bust = response.getBody().getBody();

		assertEquals(bus, bust);
		
	}

}
