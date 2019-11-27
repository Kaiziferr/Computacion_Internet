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

import icesi.edu.co.stm.model.Tmio1Bus;
import icesi.edu.co.stm.service.IBusService;

@RestController
public class BusControllerRest implements IBusControllerRest{
	
	@Autowired
	private IBusService busService;
	
	
	@PostMapping("/api/buses/create")
	@Override
	public void save(@RequestBody Tmio1Bus entity) {
		// TODO Auto-generated method stub

		busService.save(entity);
	}

	@DeleteMapping("/api/buses/delete/{id}")
	@Override
	public void delete(@PathVariable Integer id) {
		// TODO Auto-generated method stub
		busService.delete(id);
	}

	@PutMapping("/api/buses/update/{id}")
	@Override
	public void update(@RequestBody Tmio1Bus entity, @PathVariable Integer id) {
		// TODO Auto-generated method stub
		busService.update(entity,id);
	}
	
	@GetMapping("/api/buses/bus/{id}")
	@Override
	public Tmio1Bus findById(@PathVariable Integer id) {
		// TODO Auto-generated method stub
		return busService.findById(id);
	}

	@GetMapping("/api/buses/buses")
	@Override
	public List<Tmio1Bus> findAll() {
		// TODO Auto-generated method stub
		return busService.findAll();
	}
}
