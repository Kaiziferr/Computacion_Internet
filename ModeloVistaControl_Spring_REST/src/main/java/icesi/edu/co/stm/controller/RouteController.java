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

import icesi.edu.co.stm.delegate.IRouteDelegate;
import icesi.edu.co.stm.model.Tmio1Route;
import icesi.edu.co.stm.validation.Step1;
import icesi.edu.co.stm.validation.Update;

@Controller
public class RouteController implements IRouteController {
	
	@Autowired
	private IRouteDelegate iRouteDelegate;
	
	@GetMapping("/routes")
	@Override
	public String getALL(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("routes", iRouteDelegate.findAll());
		return "routes/index";
	}
	
	@GetMapping("/routes/{id}")
	@Override
	public Tmio1Route get(Integer id) {
		// TODO Auto-generated method stub
		return iRouteDelegate.findById(id);
	}
	@GetMapping("/routes/add")
	@Override
	public String add(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("tmio1Route",new Tmio1Route());
		return "routes/add-route";
	}
	@PostMapping("/routes/add")
	@Override
	public String save(@Validated(Step1.class) Tmio1Route entity, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {
		// TODO Auto-generated method stub
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				return "routes/add-route";
			}
			iRouteDelegate.save(entity);
		}
		return "redirect:/routes";
	}

	@Override
	@GetMapping("/routes/remove/{id}")
	public String remove(@PathVariable Integer id) {
		// TODO Auto-generated method stub
		iRouteDelegate.delete(id);
		return "redirect:/routes";
	}
	@GetMapping("/routes/update/{id}")
	@Override
	public String update(@PathVariable Integer id, Model model) {
		// TODO Auto-generated method stub
		Tmio1Route route2 = iRouteDelegate.findById(id);
		model.addAttribute("tmio1Route",route2);
		return "routes/update-route";
	}
	@PostMapping("/routes/update/{id}")
	@Override
	public String update(@PathVariable Integer id,@RequestParam(value = "action", required = true) String action, @Validated(Update.class) Tmio1Route entity,
			BindingResult bindingResult, Model model) {
		// TODO Auto-generated method stub
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				return "routes/update-route";
			}
			iRouteDelegate.update(entity, id);
		}
		return "redirect:/routes";
	}




}
