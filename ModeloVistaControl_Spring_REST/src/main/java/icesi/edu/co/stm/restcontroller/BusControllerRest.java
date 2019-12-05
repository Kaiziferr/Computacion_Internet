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
import icesi.edu.co.stm.model.Tmio1Bus;
import icesi.edu.co.stm.service.IBusService;

@RestController
public class BusControllerRest implements IBusControllerRest{
	
	@Autowired
	private IBusService busService;
	
	
	@PostMapping("/api/buses")
	@Override
	public void save(@RequestBody TransactionBody<Tmio1Bus,Integer> entity) {
		// TODO Auto-generated method stub
		busService.save(entity.getBody());
	}

	@DeleteMapping("/api/buses/{id}")
	@Override
	public void delete(@PathVariable Integer id) {
		// TODO Auto-generated method stub
		busService.delete(id);
	}

	@PutMapping("/api/buses/{id}")
	@Override
	public void update(@RequestBody TransactionBody<Tmio1Bus,Integer> entity, @PathVariable Integer id) {
		// TODO Auto-generated method stub
		busService.update(entity.getBody(),id);
	}
	
	@GetMapping("/api/buses/{id}")
	@Override
	public TransactionBody<Tmio1Bus,Integer> findById(@PathVariable Integer id) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1Bus,Integer> transaction = new TransactionBody<>("bus",busService.findById(id));
		return transaction;
	}
	
	@GetMapping("/api/buses")	
	@Override
	public TransactionBody<Iterable<Tmio1Bus>, Integer> findAll() {
		// TODO Auto-generated method stub
		TransactionBody<Iterable<Tmio1Bus>,Integer> transaction = new TransactionBody<>("busList",busService.findAll());
		return transaction;
	}


	
}
