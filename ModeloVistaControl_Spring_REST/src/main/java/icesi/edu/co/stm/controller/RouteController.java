package icesi.edu.co.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import icesi.edu.co.stm.delegate.IRouteDelegate;
import icesi.edu.co.stm.model.Tmio1Route;

@Controller
public class RouteController implements IRouteController{

	@Autowired
	private IRouteDelegate iRouteDelegate; 
	
	@GetMapping("/route/routes")
	@Override
	public Iterable<Tmio1Route> getALL() {
		// TODO Auto-generated method stub
		return iRouteDelegate.findAll();
	}

	@GetMapping("/route/route/{id}")
	@Override
	public Tmio1Route get(@PathVariable Integer id) {
		// TODO Auto-generated method stub
		return iRouteDelegate.findById(id);
	}

	@PostMapping("/route/create")
	@Override
	public void add(@RequestBody Tmio1Route entity) {
		// TODO Auto-generated method stub
		iRouteDelegate.save(entity);
	}

	@PutMapping("/route/update")
	@Override
	public void update(@RequestBody Tmio1Route entity) {
		// TODO Auto-generated method stub
		iRouteDelegate.update(entity);
	}

	@DeleteMapping("/route/delete")
	@Override
	public void delete(@RequestBody Tmio1Route entity) {
		// TODO Auto-generated method stub
		iRouteDelegate.delete(entity);
	}
	

}
