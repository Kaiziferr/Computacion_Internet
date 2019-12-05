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
import icesi.edu.co.stm.model.Tmio1BusDriver;
import icesi.edu.co.stm.service.IDriverBusService;

@RestController
public class DriverBusControllerRest implements IDriverBusControllerRest{
	
	@Autowired
	private IDriverBusService busDriver;

	@PostMapping("/api/busDriver")
	@Override
	public void save(@RequestBody TransactionBody<Tmio1BusDriver,String> entity) {
		// TODO Auto-generated method stub
		busDriver.save(entity.getBody());
	}

	@DeleteMapping("/api/busDriver/{id}")
	@Override
	public void delete(@PathVariable String id) {
		// TODO Auto-generated method stub
		busDriver.delete(id);
	}

	@PutMapping("/api/busDriver/{id}")
	@Override
	public void update(@RequestBody  TransactionBody<Tmio1BusDriver,String> entity, @PathVariable String id) {
		// TODO Auto-generated method stub
		busDriver.update(entity.getBody(), id);
	}

	@GetMapping("/api/busDriver/{id}")
	@Override
	public TransactionBody<Tmio1BusDriver,String> findById(@PathVariable String id) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1BusDriver,String> transaction = new TransactionBody<>("busDriver",busDriver.findById(id));
		return transaction;
	}

	@GetMapping("/api/busDriver")
	@Override
	public TransactionBody<Iterable<Tmio1BusDriver>,String>findAll() {
		// TODO Auto-generated method stub
		TransactionBody<Iterable<Tmio1BusDriver>,String> transaction = new TransactionBody<>("busDriverList",busDriver.findAll());
		return transaction;
	}
	
}
