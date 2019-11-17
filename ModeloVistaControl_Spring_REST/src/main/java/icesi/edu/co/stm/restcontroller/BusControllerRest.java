package icesi.edu.co.stm.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import icesi.edu.co.stm.model.Tmio1Bus;
import icesi.edu.co.stm.service.IBusService;

@RestController
public class BusControllerRest implements IBusControllerRest{
	
	@Autowired
	private IBusService busService;
	
	
	@PostMapping("/Tmio1Bus/create")
	@Override
	public void save(Tmio1Bus entity) {
		// TODO Auto-generated method stub
		busService.save(entity);
	}

	@DeleteMapping("/Tmio1Bus/delete")
	@Override
	public void delete(Tmio1Bus entity) {
		// TODO Auto-generated method stub
		busService.delete(entity);
	}

	@PutMapping("/Tmio1Bus/update")
	@Override
	public void update(Tmio1Bus entity) {
		// TODO Auto-generated method stub
		busService.update(entity);
	}
	
	@GetMapping("/Tmio1Bus/bus/{id}")
	@Override
	public Tmio1Bus findById(Integer id) {
		// TODO Auto-generated method stub
		return busService.findById(id);
	}

	@GetMapping("/Tmio1Bus/buses")
	@Override
	public List<Tmio1Bus> findAll() {
		// TODO Auto-generated method stub
		return busService.findAll();
	}
	
	
	
	
}
