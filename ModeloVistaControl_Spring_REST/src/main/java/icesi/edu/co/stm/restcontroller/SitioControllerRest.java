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
import icesi.edu.co.stm.model.Tmio1Sitio;
import icesi.edu.co.stm.service.ISitioService;

@RestController
public class SitioControllerRest implements ISitioControllerRest{

	@Autowired
	private ISitioService iSitioService;
	
	@PostMapping("/api/sitio")
	@Override
	public void save(@RequestBody TransactionBody<Tmio1Sitio,Long> entity) {
		// TODO Auto-generated method stub
		iSitioService.save(entity.getBody());
	}

	@DeleteMapping("/api/sitio/{id}")
	@Override
	public void delete(@PathVariable Long id) {
		// TODO Auto-generated method stub
		iSitioService.delete(id);
	}

	@PutMapping("/api/sitio/{id}")
	@Override
	public void update(@RequestBody TransactionBody<Tmio1Sitio,Long> entity,@PathVariable Long id) {
		// TODO Auto-generated method stub
		iSitioService.update(entity.getBody(), id);
	}

	@GetMapping("/api/sitio/{id}")
	@Override
	public TransactionBody<Tmio1Sitio,Long> findById(@PathVariable Long id) {
		// TODO Auto-generated method stub
		TransactionBody<Tmio1Sitio,Long> transaction = new TransactionBody<>("sitios",iSitioService.findById(id)); 
		return transaction;
	}
	
	@GetMapping("/api/sitio")
	@Override
	public TransactionBody<Iterable<Tmio1Sitio>,Long> findAll() {
		// TODO Auto-generated method stub
		TransactionBody<Iterable<Tmio1Sitio>,Long> transaction = new TransactionBody<>("sitiosList",iSitioService.findAll());
		return transaction;
	}

}
