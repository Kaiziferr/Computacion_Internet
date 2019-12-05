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
public class  ServiceSitioController implements IServicioSitioController {

	@Autowired
	private IServicioSitioDelegate iServicioSitioDelegate;

	@Override
	public String getALL(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1ServiciosSitio get(Tmio1ServiciosSitioPK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String add(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(Tmio1ServiciosSitio entity, BindingResult bindingResult, String action, Model model) {
		// TODO Auto-generated method stub
		return null;
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
