package icesi.edu.co.stm.restcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import icesi.edu.co.stm.delegate.TransactionBody;
import icesi.edu.co.stm.model.Tmio1SitiosRuta;
import icesi.edu.co.stm.model.Tmio1SitiosRutaPK;
import icesi.edu.co.stm.service.ISitioRutaService;
@RestController
public class SitioRutaControllerRest implements ISitioRutaControllerRest{

	@Autowired
	private ISitioRutaService iSitioRutaService; 
	
	
	@PostMapping("/api/sitioRuta")
	@Override
	public void save(@RequestBody TransactionBody<Tmio1SitiosRuta, Tmio1SitiosRutaPK> entity) {
		// TODO Auto-generated method stub
		iSitioRutaService.save(entity.getBody());
	}

	@DeleteMapping("/api/sitioRuta/{id}")
	@Override
	public void delete(@PathVariable Tmio1SitiosRutaPK id) {
		// TODO Auto-generated method stub
		iSitioRutaService.delete(id);
	}

	@PutMapping("/api/sitioRuta/{id}")
	@Override
	public void update(@RequestBody TransactionBody<Tmio1SitiosRuta, Tmio1SitiosRutaPK> entity, @PathVariable Tmio1SitiosRutaPK id) {
		// TODO Auto-generated method stub
		iSitioRutaService.update(entity.getBody(), id);
	}

	@GetMapping("/api/sitioRuta/{id}")
	@Override
	public TransactionBody<Tmio1SitiosRuta, Tmio1SitiosRutaPK> findById(@PathVariable Tmio1SitiosRutaPK id) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1SitiosRuta,Tmio1SitiosRutaPK> transaction = new TransactionBody<>("sitioRuta",iSitioRutaService.findById(id));
		return transaction;
	}

	@GetMapping("/api/sitioRuta")
	@Override
	public TransactionBody<Iterable<Tmio1SitiosRuta>, Tmio1SitiosRutaPK> findAll() {
		// TODO Auto-generated method stub
		TransactionBody<Iterable<Tmio1SitiosRuta>,Tmio1SitiosRutaPK> transaction = new TransactionBody<>("sitiosList",iSitioRutaService.findAll());
		return transaction;
	}

}
