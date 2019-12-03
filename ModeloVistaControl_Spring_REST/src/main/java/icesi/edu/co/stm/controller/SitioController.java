package icesi.edu.co.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import icesi.edu.co.stm.delegate.ISitioDelegate;
import icesi.edu.co.stm.model.Tmio1Sitio;

@Controller
public class SitioController implements ISitioController {

	@Autowired
	private ISitioDelegate iSitioDelegate;

	@GetMapping("/sitio")
	@Override
	public Iterable<Tmio1Sitio> getALL() {
		// TODO Auto-generated method stub
		return iSitioDelegate.findAll();
	}

	@GetMapping("/sitio/{id}")
	@Override
	public Tmio1Sitio get(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return iSitioDelegate.findById(id);
	}

	@PostMapping("/sitio")
	@Override
	public void add(@RequestBody Tmio1Sitio entity) {
		// TODO Auto-generated method stub
		iSitioDelegate.save(entity);
	}

	@PutMapping("/sitio/{id}")
	@Override
	public void update(@RequestBody Tmio1Sitio entity, @PathVariable Long id) {
		// TODO Auto-generated method stub
		iSitioDelegate.update(entity, id);
	}

	@DeleteMapping("/sitio/{id}")
	@Override
	public void delete(@PathVariable Long id) {
		// TODO Auto-generated method stub
		iSitioDelegate.delete(id);
	}

}
