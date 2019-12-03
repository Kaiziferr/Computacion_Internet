package icesi.edu.co.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import icesi.edu.co.stm.delegate.IServicioSitioDelegate;
import icesi.edu.co.stm.model.Tmio1ServiciosSitio;
import icesi.edu.co.stm.model.Tmio1ServiciosSitioPK;

@Controller
public class ServiceSitioController implements IServicioSitioController {

	@Autowired
	private IServicioSitioDelegate iServicioSitioDelegate;

	@GetMapping("/servicesitio")
	@Override
	public Iterable<Tmio1ServiciosSitio> getALL() {
		// TODO Auto-generated method stub
		return iServicioSitioDelegate.findAll();
	}

	@GetMapping("/servicesitio/{id}")
	@Override
	public Tmio1ServiciosSitio get(Tmio1ServiciosSitioPK id) {
		// TODO Auto-generated method stub
		return iServicioSitioDelegate.findById(id);
	}

	@PostMapping("/servicesitio")
	@Override
	public void add(Tmio1ServiciosSitio entity) {
		// TODO Auto-generated method stub
		iServicioSitioDelegate.save(entity);
	}

	@PutMapping("/servicesitio/{id}")
	@Override
	public void update(Tmio1ServiciosSitio entity, Tmio1ServiciosSitioPK id) {
		// TODO Auto-generated method stub
		iServicioSitioDelegate.update(entity, id);
	}

	@DeleteMapping("/servicesitio/{id}")
	@Override
	public void delete(Tmio1ServiciosSitioPK id) {
		// TODO Auto-generated method stub
		iServicioSitioDelegate.delete(id);
	}

}
