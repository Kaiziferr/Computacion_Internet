package icesi.edu.co.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import icesi.edu.co.stm.model.Tmio1Route;
import icesi.edu.co.stm.service.IRouteService;
import icesi.edu.co.stm.validation.Step1;

@Controller
public class RouteController {
	
	private IRouteService routeService;
	
	@Autowired
	public RouteController(IRouteService routeService) {
		// TODO Auto-generated constructor stub
		this.routeService = routeService;
	}
	
	@GetMapping("/routes")
	public String indexRoutes(Model model) {
		model.addAttribute("routes", routeService.findAll());
		return "routes/index";
	}
	
	@GetMapping("/routes/add")
	public String addRoute(Model model) {
		model.addAttribute("tmio1Route",new Tmio1Route());
		return "routes/add-route";
	}
	
	@PostMapping("/routes/add")
	public String saveBusDriver(@Validated(Step1.class) Tmio1Route route, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				return "routes/add-route";
			}

			routeService.save(route);
		}
		return "redirect:/routes";
	}
}
