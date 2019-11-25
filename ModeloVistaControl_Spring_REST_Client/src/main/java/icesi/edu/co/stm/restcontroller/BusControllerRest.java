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
	
	
	@PostMapping("/buses/create")
	@Override
	public void save(@RequestBody Tmio1Bus entity) {
		// TODO Auto-generated method stub
		System.out.println("Congratulation" +entity);
		busService.save(entity);
	}

	@DeleteMapping("/buses/delete")
	@Override
	public void delete(Tmio1Bus entity) {
		// TODO Auto-generated method stub
		System.out.println("Congratulation");
		busService.delete(entity);
	}

	@PutMapping("/buses/update")
	@Override
	public void update(Tmio1Bus entity) {
		// TODO Auto-generated method stub
		busService.update(entity);
	}
	
	@GetMapping("/buses/bus/{id}")
	@Override
	public Tmio1Bus findById(@PathVariable Integer id) {
		// TODO Auto-generated method stub
		return busService.findById(id);
	}

	@GetMapping("/buses/buses")
	@Override
	public List<Tmio1Bus> findAll() {
		// TODO Auto-generated method stub
		return busService.findAll();
	}
	
	
	
	
}
