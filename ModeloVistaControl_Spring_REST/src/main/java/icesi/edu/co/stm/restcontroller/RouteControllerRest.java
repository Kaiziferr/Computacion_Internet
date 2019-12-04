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
import icesi.edu.co.stm.model.Tmio1Route;
import icesi.edu.co.stm.service.IRouteService;

@RestController
public class RouteControllerRest implements IRouteControllerRest{

	@Autowired
	private IRouteService routeService;
	
	@PostMapping("/api/route")
	@Override
	public void save(@RequestBody TransactionBody<Tmio1Route,Integer> entity) {
		// TODO Auto-generated method stub
		routeService.save(entity.getBody());
	}

	@DeleteMapping("/api/route/{id}")
	@Override
	public void delete(@PathVariable Integer id) {
		// TODO Auto-generated method stub
		routeService.delete(id);
	}

	@PutMapping("/api/route/{id}")
	@Override
	public void update(@RequestBody Tmio1Route entity, @PathVariable Integer id) {
		// TODO Auto-generated method stub
		routeService.update(entity, id);
	}

	@GetMapping("/api/route/{id}")
	@Override
	public TransactionBody<Tmio1Route,Integer> findById(@PathVariable Integer id) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1Route,Integer> transaction = new TransactionBody<>("bus",routeService.findById(id));
		return transaction;
	}

	@GetMapping("/api/route")
	@Override
	public TransactionBody<Iterable<Tmio1Route>,Integer> findAll() {
		// TODO Auto-generated method stub
		TransactionBody<Iterable<Tmio1Route>,Integer> transaction = new TransactionBody<>("busList",routeService.findAll());
		return transaction;
	}

}
