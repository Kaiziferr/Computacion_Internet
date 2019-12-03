package icesi.edu.co.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import icesi.edu.co.stm.delegate.IRouteDelegate;
import icesi.edu.co.stm.model.Tmio1Route;

@Controller
public class RouteController implements IRouteController {
	
	@Autowired
	private IRouteDelegate iRouteDelegate;

	
	@Override
	public String getALL(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1Route get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@GetMapping("/route/add")
	@Override
	public String add(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping("/route/add")
	@Override
	public String save(Tmio1Route entity, BindingResult bindingResult, String action, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("(/route/")
	@Override
	public String remove(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Tmio1Route entity, BindingResult bindingResult, String action, Model model) {
		// TODO Auto-generated method stub
		return null;
	} 


}
