package icesi.edu.co.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import icesi.edu.co.stm.delegate.IServiceDelegate;
import icesi.edu.co.stm.model.Tmio1Servicio;
import icesi.edu.co.stm.model.Tmio1ServicioPK;

@Controller
public class ServicioController implements IServiceController{

	@Autowired
	private IServiceDelegate iServiceDelegate; 
	
	@GetMapping("/service")
	@Override
	public Iterable<Tmio1Servicio> getALL() {
		// TODO Auto-generated method stub
		return iServiceDelegate.findAll();
	}

	@GetMapping("/service/{id}")
	@Override
	public Tmio1Servicio get(@PathVariable Tmio1ServicioPK id) {
		// TODO Auto-generated method stub
		return iServiceDelegate.findById(id);
	}

	@PostMapping("/service")
	@Override
	public void add(@RequestBody Tmio1Servicio entity) {
		// TODO Auto-generated method stub
		iServiceDelegate.save(entity);
	}

	@PutMapping("/service/{id}")
	@Override
	public void update(@RequestBody Tmio1Servicio entity,@PathVariable Tmio1ServicioPK id) {
		// TODO Auto-generated method stub
		iServiceDelegate.update(entity,id);
	}

	@Override
	public void delete(@PathVariable Tmio1ServicioPK id) {
		// TODO Auto-generated method stub
		iServiceDelegate.delete(id);
	}

}
