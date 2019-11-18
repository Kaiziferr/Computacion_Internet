package icesi.edu.co.stm.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import icesi.edu.co.stm.model.Tmio1Route;
import icesi.edu.co.stm.service.IRouteService;

@RestController
public class RouteControllerRest implements IRouteControllerRest{

	@Autowired
	private IRouteService routeService;
	
	@PostMapping("/route/create")
	@Override
	public void save(Tmio1Route entity) {
		// TODO Auto-generated method stub
		routeService.save(entity);
	}

	@DeleteMapping("/route/delete")
	@Override
	public void delete(Tmio1Route entity) {
		// TODO Auto-generated method stub
		routeService.delete(entity);
	}

	@PutMapping("/route/update")
	@Override
	public void update(Tmio1Route entity) {
		// TODO Auto-generated method stub
		routeService.update(entity);
	}

	@GetMapping("/route/route/{id}")
	@Override
	public Tmio1Route findById(Integer id) {
		// TODO Auto-generated method stub
		return routeService.findById(id);
	}

	@GetMapping("/route/routes")
	@Override
	public List<Tmio1Route> findAll() {
		// TODO Auto-generated method stub
		return routeService.findAll();
	}

}
