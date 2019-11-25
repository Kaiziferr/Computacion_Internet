package Icesi.edu.co.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import icesi.edu.co.stm.delegate.IBusDelegate;
import icesi.edu.co.stm.model.Tmio1Bus;

@Controller
public class BusController implements IBusController{

	@Autowired
	private IBusDelegate iBusDelegate; 
	
	
	@GetMapping("/buses/buses")
	@Override
	public Iterable<Tmio1Bus> getALL() {
		// TODO Auto-generated method stub
		return iBusDelegate.findAll();
	}

	@GetMapping("/buses/buses/{id}")
	@Override
	public Tmio1Bus get(@PathVariable Integer i) {
		// TODO Auto-generated method stub
		return iBusDelegate.findById(i);
	}
	
	@PostMapping("/buses/create")
	@Override
	public Tmio1Bus add(@RequestBody   Tmio1Bus entity) {
		// TODO Auto-generated method stub
		return iBusDelegate.save(entity);
	}

}
