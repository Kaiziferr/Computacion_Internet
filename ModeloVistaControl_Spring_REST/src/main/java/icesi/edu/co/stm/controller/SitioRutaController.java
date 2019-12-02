package icesi.edu.co.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import icesi.edu.co.stm.delegate.ISitioRutaDelegate;
import icesi.edu.co.stm.model.Tmio1SitiosRuta;
import icesi.edu.co.stm.model.Tmio1SitiosRutaPK;

@Controller
public class SitioRutaController implements ISitioRutaController{

	@Autowired
	private ISitioRutaDelegate iSitioRutaDelegate; 
	
	
	@GetMapping("/sitioRuta")
	@Override
	public Iterable<Tmio1SitiosRuta> getALL() {
		// TODO Auto-generated method stub
		return iSitioRutaDelegate.findAll();
	}

	@GetMapping("/sitioRuta/{id}")
	@Override
	public Tmio1SitiosRuta get(@PathVariable Tmio1SitiosRutaPK id) {
		// TODO Auto-generated method stub
		return iSitioRutaDelegate.findById(id);
	}

	@PostMapping("/sitioRuta")
	@Override
	public void add(@RequestBody Tmio1SitiosRuta entity) {
		// TODO Auto-generated method stub
		iSitioRutaDelegate.save(entity);
	}

	@PutMapping("/sitioRuta/{id}")
	@Override
	public void update(@RequestBody Tmio1SitiosRuta entity, @PathVariable Tmio1SitiosRutaPK id) {
		// TODO Auto-generated method stub
		iSitioRutaDelegate.update(entity, id);
	}

	@DeleteMapping("/sitioRuta/{id}")
	@Override
	public void delete(@PathVariable Tmio1SitiosRutaPK id) {
		// TODO Auto-generated method stub
		iSitioRutaDelegate.delete(id);
	}

}
