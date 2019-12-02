package icesi.edu.co.stm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import icesi.edu.co.stm.model.Tmio1User;

@Service
public class UserService implements IUserService{

	@Override
	public void save(Tmio1User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Tmio1User entity, Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tmio1User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tmio1User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
