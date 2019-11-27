package icesi.edu.co.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import icesi.edu.co.stm.delegate.IServiceDelegate;
import icesi.edu.co.stm.model.Tmio1Servicio;
import icesi.edu.co.stm.model.Tmio1ServicioPK;

@Controller
public class ServicioController implements IServiceController{

	@Autowired
	private IServiceDelegate iServiceDelegate; 
	
	@GetMapping("/service/services")
	@Override
	public Iterable<Tmio1Servicio> getALL() {
		// TODO Auto-generated method stub
		return iServiceDelegate.findAll();
	}

	@GetMapping("/service/service/{id}")
	@Override
	public Tmio1Servicio get(@PathVariable Tmio1ServicioPK id) {
		// TODO Auto-generated method stub
		return iServiceDelegate.findById(id);
	}

	@Override
	public void add(@RequestBody Tmio1Servicio entity) {
		// TODO Auto-generated method stub
		iServiceDelegate.save(entity);
	}

	@Override
	public void update(@RequestBody Tmio1Servicio entity) {
		// TODO Auto-generated method stub
		iServiceDelegate.update(entity);
	}

	@Override
	public void delete(@RequestBody Tmio1Servicio entity) {
		// TODO Auto-generated method stub
		iServiceDelegate.delete(entity);
	}

}
