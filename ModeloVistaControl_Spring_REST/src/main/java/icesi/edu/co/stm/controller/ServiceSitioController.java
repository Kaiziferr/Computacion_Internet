package icesi.edu.co.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import icesi.edu.co.stm.delegate.IServicioSitioDelegate;
import icesi.edu.co.stm.model.Tmio1ServiciosSitio;
import icesi.edu.co.stm.model.Tmio1ServiciosSitioPK;

@Controller
public class  implements IServicioSitioController {

	@Autowired
	private IServicioSitioDelegate iServicioSitioDelegate;
	

	@PutMapping("/servicesitio/{id}")
	@Override
	public void update(Tmio1ServiciosSitio entity, Tmio1ServiciosSitioPK id) {
		// TODO Auto-generated method stub
		iServicioSitioDelegate.update(entity, id);
	}

	@DeleteMapping("/servicesitio/{id}")
	@Override
	public void delete(Tmio1ServiciosSitioPK id) {
		// TODO Auto-generated method stub
		iServicioSitioDelegate.delete(id);
	}
	
	@GetMapping("/servicesitio")
	@Override
	public String getALL(Model model) {
		// TODO Auto-generated method stub
		return iServicioSitioDelegate.findAll();
	}
	@GetMapping("/servicesitio/{id}")
	@Override
	public String add(Model model) {
		// TODO Auto-generated method stub
		return iServicioSitioDelegate.findById(id);
	}

	@PostMapping("/servicesitio")
	@Override
	public String save(Tmio1ServiciosSitio entity, BindingResult bindingResult, String action, Model model) {
		// TODO Auto-generated method stub
		iServicioSitioDelegate.save(entity);

	}

	@Override
	public String remove(Tmio1ServiciosSitioPK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Tmio1ServiciosSitioPK id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Tmio1ServiciosSitioPK id, String action, Tmio1ServiciosSitio entity,
			BindingResult bindingResult, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

}
