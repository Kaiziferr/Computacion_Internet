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

import icesi.edu.co.stm.delegate.IServiceDelegate;
import icesi.edu.co.stm.model.Tmio1Servicio;
import icesi.edu.co.stm.model.Tmio1ServicioPK;

@Controller
public class ServicioController implements IServiceController {

	@Autowired
	private IServiceDelegate iServiceDelegate;
	@GetMapping("/service")
	@Override
	public String getALL(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/service/{id}")
	@Override
	public Tmio1Servicio get(Tmio1ServicioPK id) {
		// TODO Auto-generated method stub
		return null;
	}
	@PostMapping("/service")
	@Override
	public String add(Model model) {
		// TODO Auto-generated method stub
		return null;
	}
	@PutMapping("/service/{id}")
	@Override
	public String save(Tmio1Servicio entity, BindingResult bindingResult, String action, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@DeleteMapping("/service/{id}")
	@Override
	public String remove(Tmio1ServicioPK id) {
		// TODO Auto-generated method stub
		return null;
	}
	@GetMapping("/service/{id}")
	@Override
	public String update(Tmio1ServicioPK id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@PutMapping("/service/{id}")
	@Override
	public String update(Tmio1ServicioPK id, String action, Tmio1Servicio entity, BindingResult bindingResult,
			Model model) {
		// TODO Auto-generated method stub
		return null;
	}







}
