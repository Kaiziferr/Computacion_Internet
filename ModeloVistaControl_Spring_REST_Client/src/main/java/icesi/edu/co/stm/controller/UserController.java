package icesi.edu.co.stm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import icesi.edu.co.stm.delegate.IUserDelegate;
import icesi.edu.co.stm.model.Tmio1User;
import icesi.edu.co.stm.validation.Step1;

@Controller
public class UserController {
	
	private IUserDelegate userDelegate;

	@Autowired
	public UserController(IUserDelegate userDelegate) {
		this.userDelegate = userDelegate;
	}

	@GetMapping("/login")
	public String login() {
		return "customlogin";
	}
	
	@GetMapping("/users")
	public String indexUser(Model model) {
		model.addAttribute("users", userDelegate.findAll());
		return "users/index";
	}
	
	@GetMapping("/users/add")
	public String addUser(Model model) {
		model.addAttribute("tmio1User",new Tmio1User());
		return "users/add-user";
	}
		
	
	@PostMapping("/users/add")
	public String saveUser(@Validated(Step1.class) Tmio1User user, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {
		if(!action.equals("Cancel")) {
			if(bindingResult.hasErrors()) {
				return "users/add-user";	
			}	
				userDelegate.save(user);
		}
		return "redirect:/users";
	}
}
