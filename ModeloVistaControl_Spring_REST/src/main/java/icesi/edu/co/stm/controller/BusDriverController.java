package icesi.edu.co.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import icesi.edu.co.stm.delegate.IDriverBusDelegate;
import icesi.edu.co.stm.model.Tmio1BusDriver;

@Controller
public class BusDriverController implements IBusDriverController{

	@Autowired
	private IDriverBusDelegate iDriverBusDelegate;
	
	@GetMapping("/busdriver")
	@Override
	public Iterable<Tmio1BusDriver> getALL() {
		// TODO Auto-generated method stub
		return iDriverBusDelegate.findAll();
	}

	@GetMapping("/busdriver/{id}")
	@Override
	public Tmio1BusDriver get(@PathVariable String id) {
		// TODO Auto-generated method stub
		return iDriverBusDelegate.findById(id);
	}
	
	@PostMapping("/busdriver")
	@Override
	public void add(@RequestBody Tmio1BusDriver entity) {
		// TODO Auto-generated method stub
		iDriverBusDelegate.save(entity);
	}

	@PutMapping("/busdriver/{id}")
	@Override
	public void update(@RequestBody Tmio1BusDriver entity,@PathVariable String id) {
		// TODO Auto-generated method stub
		iDriverBusDelegate.update(entity,id);
	}

	@DeleteMapping("/busdriver/{id}")
	@Override
	public void delete(@PathVariable String id) {
		// TODO Auto-generated method stub
		iDriverBusDelegate.delete(id);
	}
	
	

}
