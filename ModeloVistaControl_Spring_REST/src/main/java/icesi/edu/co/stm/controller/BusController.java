package icesi.edu.co.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import icesi.edu.co.stm.delegate.IBusDelegate;
import icesi.edu.co.stm.model.Tmio1Bus;
import icesi.edu.co.stm.validation.Step1;

@Controller
public class BusController implements IBusController {

	@Autowired
	private IBusDelegate iBusDelegate;

	@GetMapping("/buses")
	@Override
	public String getALL(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("buses", iBusDelegate.findAll());
		return "buses/index";
	}

	@GetMapping("/buses/{id}")
	@Override
	public Tmio1Bus get(@PathVariable Integer id) {
		// TODO Auto-generated method stub
		return iBusDelegate.findById(id);
	}
	
	
	@GetMapping("/buses/add")
	@Override
	public String add(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("tmio1Bus",new Tmio1Bus());
		return "buses/add-bus";
	}

	@PostMapping("/buses/add")
	@Override
	public String save(@Validated(Step1.class) Tmio1Bus entity, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {
		// TODO Auto-generated method stub
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				return "buses/add-bus";
			}
			iBusDelegate.save(entity);
		}
		return "redirect:/buses";
	}


	@Override
	@GetMapping("/buses/remove/{id}")
	public String remove(@PathVariable Integer id) {
		iBusDelegate.delete(id);
		return "redirect:/buses";
	}
	
	@GetMapping("/buses/update/{id}")
	@Override
	public String update(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("tmio1Bus",new Tmio1Bus());
		return "buses/update-bus";
	}

	@PutMapping("/buses/update/{id}")
	@Override
	public String update(@Validated(Step1.class) Tmio1Bus entity, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {
		// TODO Auto-generated method stub
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				return "buses/update-bus";
			}
		
		}
		return "redirect:/buses";
	}

	





}
