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

import icesi.edu.co.stm.delegate.IRouteDelegate;
import icesi.edu.co.stm.delegate.ISitioDelegate;
import icesi.edu.co.stm.delegate.ISitioRutaDelegate;
import icesi.edu.co.stm.model.Tmio1SitiosRuta;
import icesi.edu.co.stm.model.Tmio1SitiosRutaPK;
import icesi.edu.co.stm.validation.Step1;
import icesi.edu.co.stm.validation.Update;

@Controller
public class SitioRutaController implements ISitioRutaController {

	@Autowired
	private ISitioRutaDelegate iSitioRutaDelegate;

	@Autowired
	private ISitioDelegate iSitioDelegate; 

	@Autowired
	private IRouteDelegate iRutaDelegate; 

	
	@GetMapping("/sitiorutas")
	@Override
	public String getALL(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("sitRutas", iSitioRutaDelegate.findAll());
		return "sitiorutas/index";
	}

	@GetMapping("/sitiorutas/{id}")
	@Override
	public Tmio1SitiosRuta get(@PathVariable Tmio1SitiosRutaPK id) {
		// TODO Auto-generated method stub
		return iSitioRutaDelegate.findById(id);
	}
	
	
	@GetMapping("/sitiorutas/add")
	@Override
	public String add(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("tmio1Bus",new Tmio1SitiosRuta());
		//model.addAttribute("tmio1Sitio",iSitioDelegate.findAll());
		model.addAttribute("tmio1Route",iRutaDelegate.findAll());
		return "sitiorutas/add-sitioruta";
	}

	@PostMapping("/sitiorutas/add")
	@Override
	public String save(@Validated(Step1.class) Tmio1SitiosRuta entity, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {
		// TODO Auto-generated method stub
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				return "sitiorutas/add-sitioruta";
			}
			iSitioRutaDelegate.save(entity);
		}
		return "redirect:/sitiorutas";
	}


	@Override
	@GetMapping("/sitiorutas/remove/{id}")
	public String remove(@PathVariable Tmio1SitiosRutaPK id) {
		iSitioRutaDelegate.delete(id);
		return "redirect:/sitiorutas";
	}

	@GetMapping("/sitiorutas/update/{id}")
	@Override
	public String update(@PathVariable Tmio1SitiosRutaPK id, Model model) {
		// TODO Auto-generated method stub
		Tmio1SitiosRuta bus2 = iSitioRutaDelegate.findById(id);
		model.addAttribute("tmio1Bus",bus2);
		return "sitiorutas/update-sitioruta";
	}
	@PostMapping("/sitiorutas/update/{id}")
	@Override
	public String update(@PathVariable Tmio1SitiosRutaPK id,@RequestParam(value = "action", required = true) String action, @Validated(Update.class) Tmio1SitiosRuta entity,
			BindingResult bindingResult, Model model) {
		// TODO Auto-generated method stub
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				return "sitiorutas/update-sitioruta";
			}
			iSitioRutaDelegate.update(entity, id);
		}
		return "redirect:/sitiorutas";
	}
}
