package icesi.edu.co.stm.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import icesi.edu.co.stm.model.Tmio1BusDriver;
import icesi.edu.co.stm.service.IDriverBusService;

@RestController
public class DriverBusControllerRest implements IDriverBusControllerRest{
	
	@Autowired
	private IDriverBusService busDriver;

	@PostMapping("/busDriver/create")
	@Override
	public void save(Tmio1BusDriver entity) {
		// TODO Auto-generated method stub
		busDriver.save(entity);
	}

	@DeleteMapping("/busDriver/delete")
	@Override
	public void delete(Tmio1BusDriver entity) {
		// TODO Auto-generated method stub
		busDriver.delete(entity);
	}

	@PutMapping("/busDriver/update")
	@Override
	public void update(Tmio1BusDriver entity) {
		// TODO Auto-generated method stub
		busDriver.update(entity);
	}

	@GetMapping("/busDriver/busDriver/{id}")
	@Override
	public Tmio1BusDriver findById(String id) {
		// TODO Auto-generated method stub
		return busDriver.findById(id);
	}

	@GetMapping("/busDriver/busDrivers")
	@Override
	public List<Tmio1BusDriver> findAll() {
		// TODO Auto-generated method stub
		return busDriver.findAll();
	}
	
}
