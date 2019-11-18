package icesi.edu.co.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import icesi.edu.co.stm.delegate.IBusDelegate;
import icesi.edu.co.stm.model.Tmio1Bus;
import icesi.edu.co.stm.validation.Step1;

@Controller
public class BusController {

	private IBusDelegate busDelegate;

	@Autowired
	public BusController(IBusDelegate busDelegate) {
		this.busDelegate = busDelegate;
	}

	/*
	@GetMapping("/buses/")
	public String indexBuses(Model model) {
		model.addAttribute("buses", busService.findAll());
		return "buses/index";
	}
	
	

	@GetMapping("/buses/add")
	public String addBus(Model model) {
		model.addAttribute("tmio1Bus", new Tmio1Bus());
		return "buses/add-bus";
	}
	
	*/
	
	@PostMapping("/buses/add")
	public String saveBus(@Validated(Step1.class) Tmio1Bus bus, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				return "buses/add-bus";
			}
			busDelegate.save(bus);
		}
		return "redirect:/buses";
	}
}
