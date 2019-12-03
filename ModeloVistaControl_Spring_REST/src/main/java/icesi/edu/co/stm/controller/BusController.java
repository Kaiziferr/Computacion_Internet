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

	@PostMapping("/buses")
	@Override
	public String add(@Validated(Step1.class) Tmio1Bus entity, BindingResult bindingResult,
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

	@PutMapping("/buses/{id}")
	@Override
	public void update(@RequestBody Tmio1Bus entity, @PathVariable Integer id) {
		// TODO Auto-generated method stub
		iBusDelegate.update(entity, id);
	}

	@DeleteMapping("/buses/{id}")
	@Override
	public void delete(@PathVariable Integer id) {
		// TODO Auto-generated method stub
		iBusDelegate.delete(id);
	}

}
