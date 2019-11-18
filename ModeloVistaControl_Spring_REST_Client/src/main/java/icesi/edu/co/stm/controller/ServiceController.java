package icesi.edu.co.stm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import icesi.edu.co.stm.delegate.IBusDelegate;
import icesi.edu.co.stm.delegate.IDriverBusDelegate;
import icesi.edu.co.stm.delegate.IRouteDelegate;
import icesi.edu.co.stm.delegate.IServiceDelegate;
import icesi.edu.co.stm.model.Tmio1Bus;
import icesi.edu.co.stm.model.Tmio1BusDriver;
import icesi.edu.co.stm.model.Tmio1Route;
import icesi.edu.co.stm.model.Tmio1Servicio;
import icesi.edu.co.stm.model.Tmio1ServicioPK;


@Controller
public class ServiceController {
	
	private IServiceDelegate serviceDelegate;
	
	private IBusDelegate busDelegate;
	
	private IRouteDelegate routeDelegate;
	
	private IDriverBusDelegate busDriverDelegate;
	

	
	
	
	@Autowired
	public ServiceController(IServiceDelegate serviceDelegate, IBusDelegate busDelegate, IDriverBusDelegate busDriverDelegate, IRouteDelegate routeDelegate) {
		// TODO Auto-generated constructor stub
		this.serviceDelegate = serviceDelegate;
		this.busDelegate = busDelegate;
		this.routeDelegate = routeDelegate;
		this.busDriverDelegate = busDriverDelegate;
	
	}
	
	
	@GetMapping("/services")
	public String indexServices(Model model) {
		model.addAttribute("services", serviceDelegate.findAll());
		return "services/index";
	}
	@GetMapping("/services/add")
	public String addService(Model model) {
		model.addAttribute("tmio1ServicioPK", new Tmio1ServicioPK());
		model.addAttribute("buses", serviceDelegate.findAll());
		model.addAttribute("routes", routeDelegate.findAll());
		model.addAttribute("busDrivers", busDriverDelegate.findAll());
		return "services/add-service";
	}
	
	@PostMapping("/services/add")
	public String saveApps(@RequestParam(value = "action", required = true) String action, @Valid Tmio1ServicioPK service,
			BindingResult bindingResult, Model model) {
		System.out.println(service);
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				return "/services/add-service";
			} 
			
			
			Tmio1Servicio servicio = new Tmio1Servicio();
			servicio.setId(service);
			//servicio.setTmio1Bus(busService.findById(service.getIdBus()).get());
			//servicio.setTmio1Ruta(routeService.findById(service.getIdRuta()).get());
			//servicio.setTmio1Conductore(busDriverService.findById(service.getCedulaConductor()).get());
			
			System.out.println(servicio);
			serviceDelegate.save(servicio);
		}
		return "redirect:/services";
	}
}
