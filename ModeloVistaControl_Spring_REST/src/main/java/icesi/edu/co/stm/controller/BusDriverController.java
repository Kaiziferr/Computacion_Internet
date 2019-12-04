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

import icesi.edu.co.stm.delegate.IDriverBusDelegate;
import icesi.edu.co.stm.model.Tmio1BusDriver;

@Controller
public class BusDriverController implements IBusDriverController {

	@Autowired
	private IDriverBusDelegate iDriverBusDelegate;

	@Override
	public String getALL(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1BusDriver get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String add(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(Tmio1BusDriver entity, BindingResult bindingResult, String action, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String remove(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Tmio1BusDriver entity, BindingResult bindingResult, String action, Model model) {
		// TODO Auto-generated method stub
		return null;
	}


}
