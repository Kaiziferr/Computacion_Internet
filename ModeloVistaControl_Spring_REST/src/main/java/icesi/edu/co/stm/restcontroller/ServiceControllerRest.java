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

import icesi.edu.co.stm.model.Tmio1Servicio;
import icesi.edu.co.stm.model.Tmio1ServicioPK;
import icesi.edu.co.stm.service.IServiceService;

@RestController
public class ServiceControllerRest implements IServiceControllerRest{

	@Autowired
	private IServiceService serviceService;
	
	@PostMapping("/api/service/create")
	@Override
	public void save(@RequestBody Tmio1Servicio entity) {
		// TODO Auto-generated method stub
		serviceService.save(entity);
	}

	@DeleteMapping("/api/service/delete")
	@Override
	public void delete(@RequestBody Tmio1Servicio entity) {
		// TODO Auto-generated method stub
		serviceService.delete(entity);
	}

	@PutMapping("/api/service/update")
	@Override
	public void update(@RequestBody Tmio1Servicio entity) {
		// TODO Auto-generated method stub
		serviceService.delete(entity);
	}

	@GetMapping("/api/service/service/{id}")
	@Override
	public Tmio1Servicio findById(@PathVariable Tmio1ServicioPK id) {
		// TODO Auto-generated method stub
		return serviceService.findById(id);
	}
	
	@GetMapping("/api/service/services")
	@Override
	public List<Tmio1Servicio> findAll() {
		// TODO Auto-generated method stub
		return serviceService.findAll();
	}

	
}
