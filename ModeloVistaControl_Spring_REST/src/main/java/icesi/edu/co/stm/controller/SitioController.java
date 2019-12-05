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

import icesi.edu.co.stm.delegate.ISitioDelegate;
import icesi.edu.co.stm.model.Tmio1Bus;
import icesi.edu.co.stm.model.Tmio1Sitio;
import icesi.edu.co.stm.validation.Step1;

@Controller
public class SitioController implements ISitioController {

	@Autowired
	private ISitioDelegate iSitioDelegate;

	@GetMapping("/sitios")
	@Override
	public String getALL(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("sitios", iSitioDelegate.findAll());
		return "sitios/index";
	}

	@GetMapping("/sitios/{id}")
	@Override
	public Tmio1Sitio get(Long id) {
		// TODO Auto-generated method stub
		return iSitioDelegate.findById(id);
	}

	@GetMapping("/sitios/add")
	@Override
	public String add(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("tmio1Sitio",new Tmio1Sitio());
		return "buses/add-sitios";
	}

	@PostMapping("/sitios/add")
	@Override
	public String save(@Validated(Step1.class) Tmio1Sitio entity, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {
		// TODO Auto-generated method stub
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				return "buses/add-sitios";
			}
			iSitioDelegate.save(entity);
		}
		return "redirect:/sitios";
	}

	@Override
	@GetMapping("/sitios/remove/{id}")
	public String remove(Long id) {
		// TODO Auto-generated method stub
		iSitioDelegate.delete(id);
		return "redirect:/sitios";
	}

	@Override
	public String update(Long id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Long id, String action, Tmio1Sitio entity, BindingResult bindingResult, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
