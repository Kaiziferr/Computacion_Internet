package icesi.edu.co.stm.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import icesi.edu.co.stm.delegate.TransactionBody;
import icesi.edu.co.stm.model.Tmio1Bus;
import icesi.edu.co.stm.model.Tmio1ServiciosSitio;
import icesi.edu.co.stm.model.Tmio1ServiciosSitioPK;
import icesi.edu.co.stm.service.IServiceSitioService;

@RestController
public class ServiceSitioControllerRest implements IServiceSitioController{

	@Autowired
	private IServiceSitioService iServiceSitioService; 
	
	@PostMapping("/api/servicesitio")
	@Override
	public void save(@RequestBody TransactionBody<Tmio1ServiciosSitio,Tmio1ServiciosSitioPK>  entity) {
		// TODO Auto-generated method stub
		iServiceSitioService.save(entity.getBody());
	}

	@DeleteMapping("/api/servicesitio/{id}")
	@Override
	public void delete(@PathVariable Tmio1ServiciosSitioPK id) {
		// TODO Auto-generated method stub
		iServiceSitioService.delete(id);
	}

	@PutMapping("/api/servicesitio/{id}")
	@Override
	public void update(@RequestBody Tmio1ServiciosSitio entity, @PathVariable Tmio1ServiciosSitioPK id) {
		// TODO Auto-generated method stub
		iServiceSitioService.update(entity, id);
	}

	@GetMapping("/api/servicesitio/{id}")
	@Override
	public TransactionBody<Tmio1ServiciosSitio,Tmio1ServiciosSitioPK> findById(@PathVariable Tmio1ServiciosSitioPK id) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1ServiciosSitio,Tmio1ServiciosSitioPK> transaction = new TransactionBody<>("service",iServiceSitioService.findById(id));
		return transaction;
	}

	@GetMapping("/api/servicesitio")
	@Override
	public TransactionBody<Iterable<Tmio1ServiciosSitio>,Tmio1ServiciosSitioPK> findAll() {
		// TODO Auto-generated method stub
		TransactionBody<Iterable<Tmio1ServiciosSitio>,Tmio1ServiciosSitioPK> transaction = new TransactionBody<>("serviceList",iServiceSitioService.findAll());
		return transaction;
	}


}
