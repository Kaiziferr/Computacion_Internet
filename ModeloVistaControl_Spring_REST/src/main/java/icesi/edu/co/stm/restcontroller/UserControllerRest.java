package icesi.edu.co.stm.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import icesi.edu.co.stm.delegate.TransactionBody;
import icesi.edu.co.stm.model.Tmio1User;
import icesi.edu.co.stm.service.IUserService;

@RestController
public class UserControllerRest implements IUserControllerRest{

	@Override
	public void save(TransactionBody<Tmio1User, Integer> entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TransactionBody<Tmio1User, Integer> entity, Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TransactionBody<Tmio1User, Integer> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionBody<Iterable<Tmio1User>, Integer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
