package icesi.edu.co.stm.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import icesi.edu.co.stm.model.Tmio1Servicio;
import icesi.edu.co.stm.model.Tmio1ServicioPK;
import icesi.edu.co.stm.service.IServiceService;

@RestController
public class ServiceControllerRest implements IServiceControllerRest{

	@Autowired
	private IServiceService serviceService;
	
	@PostMapping("/Tmio1Servicio/create")
	@Override
	public void save(Tmio1Servicio entity) {
		// TODO Auto-generated method stub
		serviceService.save(entity);
	}

	@DeleteMapping("/Tmio1Servicio/delete")
	@Override
	public void delete(Tmio1Servicio entity) {
		// TODO Auto-generated method stub
		serviceService.delete(entity);
	}

	@PutMapping("/Tmio1Servicio/update")
	@Override
	public void update(Tmio1Servicio entity) {
		// TODO Auto-generated method stub
		serviceService.delete(entity);
	}

	@GetMapping("/Tmio1Servicio/service/{id}")
	@Override
	public Tmio1Servicio findById(Tmio1ServicioPK id) {
		// TODO Auto-generated method stub
		return serviceService.findById(id);
	}
	
	@GetMapping("/Tmio1Servicio/services")
	@Override
	public List<Tmio1Servicio> findAll() {
		// TODO Auto-generated method stub
		return serviceService.findAll();
	}

	
}
