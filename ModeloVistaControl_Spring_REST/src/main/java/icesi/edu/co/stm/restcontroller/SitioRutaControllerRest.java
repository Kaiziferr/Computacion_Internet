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

import icesi.edu.co.stm.model.Tmio1SitiosRuta;
import icesi.edu.co.stm.model.Tmio1SitiosRutaPK;
import icesi.edu.co.stm.service.ISitioRutaService;
@RestController
public class SitioRutaControllerRest implements ISitioRutaControllerRest{

	@Autowired
	private ISitioRutaService iSitioRutaService; 
	
	
	@PostMapping("/api/sitioRuta")
	@Override
	public void save(@RequestBody Tmio1SitiosRuta entity) {
		// TODO Auto-generated method stub
		iSitioRutaService.save(entity);
	}

	@DeleteMapping("/api/sitioRuta/{id}")
	@Override
	public void delete(@PathVariable Tmio1SitiosRutaPK id) {
		// TODO Auto-generated method stub
		iSitioRutaService.delete(id);
	}

	@PutMapping("/api/sitioRuta/{id}")
	@Override
	public void update(@RequestBody Tmio1SitiosRuta entity, @PathVariable Tmio1SitiosRutaPK id) {
		// TODO Auto-generated method stub
		iSitioRutaService.update(entity, id);
	}

	@GetMapping("/api/sitioRuta/{id}")
	@Override
	public Tmio1SitiosRuta findById(@PathVariable Tmio1SitiosRutaPK id) {
		// TODO Auto-generated method stub
		return iSitioRutaService.findById(id);
	}

	@GetMapping("/api/sitioRuta")
	@Override
	public List<Tmio1SitiosRuta> findAll() {
		// TODO Auto-generated method stub
		return iSitioRutaService.findAll();
	}

}
