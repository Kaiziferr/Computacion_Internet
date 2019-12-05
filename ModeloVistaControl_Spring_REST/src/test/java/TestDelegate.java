import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import icesi.edu.co.stm.delegate.IBusDelegate;

@SpringBootTest
public interface TestDelegate {
	
	RestTemplate restTemplate;
}
