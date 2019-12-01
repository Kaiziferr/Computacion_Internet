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

import icesi.edu.co.stm.model.Tmio1BusDriver;
import icesi.edu.co.stm.service.IDriverBusService;

@RestController
public class DriverBusControllerRest implements IDriverBusControllerRest{
	
	@Autowired
	private IDriverBusService busDriver;

	@PostMapping("/api/busDriver")
	@Override
	public void save(@RequestBody Tmio1BusDriver entity) {
		// TODO Auto-generated method stub
		busDriver.save(entity);
	}

	@DeleteMapping("/api/busDriver/{id}")
	@Override
	public void delete(@PathVariable String id) {
		// TODO Auto-generated method stub
		busDriver.delete(id);
	}

	@PutMapping("/api/busDriver/{id}")
	@Override
	public void update(@RequestBody Tmio1BusDriver entity, @PathVariable String id) {
		// TODO Auto-generated method stub
		busDriver.update(entity, id);
	}

	@GetMapping("/api/busDriver/{id}")
	@Override
	public Tmio1BusDriver findById(@PathVariable String id) {
		// TODO Auto-generated method stub
		return busDriver.findById(id);
	}

	@GetMapping("/api/busDriver")
	@Override
	public List<Tmio1BusDriver> findAll() {
		// TODO Auto-generated method stub
		return busDriver.findAll();
	}
	
}
