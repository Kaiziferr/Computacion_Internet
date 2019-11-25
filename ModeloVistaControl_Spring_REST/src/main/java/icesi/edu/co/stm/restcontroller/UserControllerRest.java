package icesi.edu.co.stm.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import icesi.edu.co.stm.model.Tmio1User;
import icesi.edu.co.stm.service.IUserService;

@RestController
public class UserControllerRest implements IUserControllerRest{
	
	@Autowired
	private IUserService userService;

	@PostMapping("/user/create")
	@Override
	public void save(Tmio1User entity) {
		// TODO Auto-generated method stub
		userService.save(entity);
	}

	@DeleteMapping("/user/delete")
	@Override
	public void delete(Tmio1User entity) {
		// TODO Auto-generated method stub
		userService.delete(entity);
	}

	@PutMapping("/user/update")
	@Override
	public void update(Tmio1User entity) {
		// TODO Auto-generated method stub
		userService.update(entity);
	}

	@GetMapping("/user/user/{id}")
	@Override
	public Tmio1User findById(Integer id) {
		// TODO Auto-generated method stub
		return userService.findById(id);
	}
	
	@GetMapping("/user/users")
	@Override
	public List<Tmio1User> findAll() {
		// TODO Auto-generated method stub
		return userService.findAll();
	}
	
	
	
}
