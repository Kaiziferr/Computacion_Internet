package icesi.edu.co.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import icesi.edu.co.stm.delegate.IDriverBusDelegate;
import icesi.edu.co.stm.model.Tmio1BusDriver;
import icesi.edu.co.stm.validation.Step1;
import icesi.edu.co.stm.validation.Update;

@Controller
public class BusDriverController implements IBusDriverController {

	@Autowired
	private IDriverBusDelegate iDriverBusDelegate;
	
	@GetMapping("/busdrivers")
	@Override
	public String getALL(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("busdrivers", iDriverBusDelegate.findAll());
		return "busdrivers/index";
	}

	@GetMapping("/busdrivers/{id}")
	@Override
	public Tmio1BusDriver get(@PathVariable String id) {
		// TODO Auto-generated method stub
		return iDriverBusDelegate.findById(id);
	}

	@GetMapping("/busdrivers/add")
	@Override
	public String add(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("tmio1BusDriver",new Tmio1BusDriver());
		return "busdrivers/add-busdriver";
	}

	@PostMapping("/busdrivers/add")
	@Override
	public String save(@Validated(Step1.class) Tmio1BusDriver entity, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {
		// TODO Auto-generated method stub
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				return "busdrivers/add-busdriver";
			}
			iDriverBusDelegate.save(entity);
		}
		return "redirect:/busdrivers";
	}

	

	@Override
	@GetMapping("/busdrivers/remove/{id}")
	public String remove(@PathVariable String id) {
		// TODO Auto-generated method stub
		iDriverBusDelegate.delete(id);
		return "redirect:/busdrivers";
	}

	@GetMapping("/busdrivers/update/{id}")
	@Override
	public String update(@PathVariable String id, Model model) {
		// TODO Auto-generated method stub
		Tmio1BusDriver busDriver2 = iDriverBusDelegate.findById(id);
		model.addAttribute("tmio1BusDriver",busDriver2);
		return "busdrivers/update-busdriver";
	}
	@PostMapping("/busdrivers/update/{id}")
	@Override
	public String update(@PathVariable String id,@RequestParam(value = "action", required = true) String action, @Validated(Update.class) Tmio1BusDriver entity,
			BindingResult bindingResult, Model model) {
		// TODO Auto-generated method stub
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				return "busdrivers/update-busdriver";
			}
			System.out.println(id);
			iDriverBusDelegate.update(entity, id);
		}
		return "redirect:/busdrivers";
	}




}
