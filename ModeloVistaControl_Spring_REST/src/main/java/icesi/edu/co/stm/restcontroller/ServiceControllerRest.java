package icesi.edu.co.stm.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import icesi.edu.co.stm.delegate.TransactionBody;
import icesi.edu.co.stm.model.Tmio1Servicio;
import icesi.edu.co.stm.model.Tmio1ServicioPK;
import icesi.edu.co.stm.service.IServiceService;

@RestController
public class ServiceControllerRest implements IServiceControllerRest{

	@Autowired
	private IServiceService serviceService;
	
	@PostMapping("/api/service")
	@Override
	public void save(@RequestBody TransactionBody<Tmio1Servicio,Tmio1ServicioPK> entity) {
		// TODO Auto-generated method stub
		serviceService.save(entity.getBody());
	}

	@DeleteMapping("/api/service/{id}")
	@Override
	public void delete(@PathVariable Tmio1ServicioPK id) {
		// TODO Auto-generated method stub
		serviceService.delete(id);
	}

	@PutMapping("/api/service/{id}")
	@Override
	public void update(@RequestBody TransactionBody<Tmio1Servicio, Tmio1ServicioPK> entity, @PathVariable Tmio1ServicioPK id) {
		// TODO Auto-generated method stub
		serviceService.update(entity.getBody(),id);
	}

	@GetMapping("/api/service/{id}")
	@Override
	public TransactionBody<Tmio1Servicio, Tmio1ServicioPK> findById(@PathVariable Tmio1ServicioPK id) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1Servicio,Tmio1ServicioPK> transaction = new TransactionBody<>("busDriver",serviceService.findById(id));
		return transaction;
	}
	
	@GetMapping("/api/service")
	@Override
	public TransactionBody<Iterable<Tmio1Servicio>, Tmio1ServicioPK> findAll() {
		// TODO Auto-generated method stub
		TransactionBody<Iterable<Tmio1Servicio>,Tmio1ServicioPK> transaction = new TransactionBody<>("busDriverList",serviceService.findAll());
		return transaction;
	}

	
}
