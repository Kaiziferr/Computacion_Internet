package Icesi.edu.co.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	public Tmio1Bus get() {
		// TODO Auto-generated method stub
		return null;
	}

}
