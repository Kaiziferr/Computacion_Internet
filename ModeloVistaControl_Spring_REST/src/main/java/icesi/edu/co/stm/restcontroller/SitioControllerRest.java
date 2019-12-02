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

import icesi.edu.co.stm.model.Tmio1Sitio;
import icesi.edu.co.stm.service.ISitioService;

@RestController
public class SitioControllerRest implements ISitioControllerRest{

	@Autowired
	private ISitioService iSitioService;
	
	@PostMapping("/api/sitio")
	@Override
	public void save(@RequestBody Tmio1Sitio entity) {
		// TODO Auto-generated method stub
		iSitioService.save(entity);
	}

	@DeleteMapping("/api/sitio/{id}")
	@Override
	public void delete(@PathVariable Long id) {
		// TODO Auto-generated method stub
		iSitioService.delete(id);
	}

	@PutMapping("/api/sitio/{id}")
	@Override
	public void update(@RequestBody Tmio1Sitio entity,@PathVariable Long id) {
		// TODO Auto-generated method stub
		iSitioService.update(entity, id);
	}

	@GetMapping("/api/sitio/{id}")
	@Override
	public Tmio1Sitio findById(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return iSitioService.findById(id);
	}
	
	@GetMapping("/api/sitio")
	@Override
	public List<Tmio1Sitio> findAll() {
		// TODO Auto-generated method stub
		return iSitioService.findAll();
	}

}
