package icesi.edu.co.stm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import icesi.edu.co.stm.delegate.IDriverBusDelegate;
import icesi.edu.co.stm.model.Tmio1BusDriver;
import icesi.edu.co.stm.validation.Step1;

@Controller
public class BusDriverController {
	
	private IDriverBusDelegate driverBusDelegate;
	
		
	@Autowired
	public BusDriverController(IDriverBusDelegate driverBusDelegate) {
		this.driverBusDelegate = driverBusDelegate;
	}
	
	@GetMapping("/busdrivers")
	public String indexBusDrivers(Model model) {
		
		return "busdrivers/index";
	}
	 
	
	@GetMapping("/busdrivers/show")
	public String showBusDriver(Model model) {
	
		return "busdrivers/show-busdriver";
	}


	@PostMapping("/busdrivers/show")
	public String showBusDrivers(@Validated(Step1.class) Tmio1BusDriver busDriver, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {
		System.out.println(busDriver.getCedula());
		//Optional<Tmio1BusDriver> busDri = driverBusService.findById(busDriver.getCedula());
		if(!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				return "busdrivers/show-busdriver";
			}

		//	driverBusService.setCed(busDriver.getCedula());
			
		}
		return "/busdrivers";
	}
    
	/**
	 * 
	 * @param model
	 * @return
	*/ 
	@GetMapping("/busdrivers/add")
	public String addBusDriver(Model model) {
		model.addAttribute("tmio1BusDriver", new Tmio1BusDriver());
		return "busdrivers/add-busdriver";
	}
	
	
	
	
	@PostMapping("/busdrivers/add")
	public String saveBusDriver(@Validated(Step1.class) Tmio1BusDriver busDriver, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {

		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				return "busdrivers/add-busdriver";
			}

			
		}
		return "redirect:/busdrivers";
	}

}
