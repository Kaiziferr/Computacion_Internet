package icesi.edu.co.stm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import icesi.edu.co.stm.delegate.IBusDelegate;
import icesi.edu.co.stm.model.Tmio1Bus;

@Controller
public class BusController implements IBusController{

	@Autowired
	private IBusDelegate iBusDelegate; 
	
	
	@GetMapping("/buses")
	@Override
	public Iterable<Tmio1Bus> getALL() {
		// TODO Auto-generated method stub
		return iBusDelegate.findAll();
	}

	@GetMapping("/buses/{id}")
	@Override
	public Tmio1Bus get(@PathVariable Integer id) {
		// TODO Auto-generated method stub
		return iBusDelegate.findById(id);
	}
	
	@PostMapping("/buses")
	@Override
	public void add(@RequestBody Tmio1Bus entity) {
		// TODO Auto-generated method stub
		 iBusDelegate.save(entity);
	}
	
	@PutMapping("/buses/{id}")
	@Override
	public void update(@RequestBody Tmio1Bus entity,@PathVariable Integer id) {
		// TODO Auto-generated method stub
		iBusDelegate.update(entity,id);
	}

	@DeleteMapping("/buses/{id}")
	@Override
	public void delete(@PathVariable Integer id) {
		// TODO Auto-generated method stub
		iBusDelegate.delete(id);
	}

}
