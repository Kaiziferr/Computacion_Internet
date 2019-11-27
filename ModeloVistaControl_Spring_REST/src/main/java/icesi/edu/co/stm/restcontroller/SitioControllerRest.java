package icesi.edu.co.stm.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import icesi.edu.co.stm.model.Tmio1Sitio;

@RestController
public class SitioControllerRest implements ISitioControllerRest{

	
	@PostMapping("/api/sitio/create")
	@Override
	public void save(@RequestBody Tmio1Sitio entity) {
		// TODO Auto-generated method stub
		
	}

	@DeleteMapping("/api/sitio/delete")
	@Override
	public void delete(@RequestBody Tmio1Sitio entity) {
		// TODO Auto-generated method stub
		
	}

	@PutMapping("/api/sitio/update")
	@Override
	public void update(@RequestBody Tmio1Sitio entity) {
		// TODO Auto-generated method stub
		
	}

	@GetMapping("/api/sitio/sitio/{id}")
	@Override
	public Tmio1Sitio findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@GetMapping("/api/sitio/sitios")
	@Override
	public List<Tmio1Sitio> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
