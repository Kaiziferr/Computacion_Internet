package icesi.edu.co.stm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import icesi.edu.co.stm.model.Tmio1User;
import icesi.edu.co.stm.repository.IUserRepository;

@Service
public class UserService implements IUserService{

	@Override
	public void save(Tmio1User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Tmio1User> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Tmio1User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Tmio1User user) {
		// TODO Auto-generated method stub
		
	}

	/*
	private IUserRepository userRepository;

	@Autowired
	public UserService(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void save(Tmio1User user) {
		userRepository.save(user);
	}

	public Iterable<Tmio1User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<Tmio1User> findById(Integer id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}


	@Override
	public void delete(Tmio1User user) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 
	 
	public Optional<Tmio1User> findById(long id) {

		return userRepository.findById(id);
	}
	 
	public Iterable<UserApp> findAllPatients() {
		return userRepository.findByType(UserType.patient);
	}
	
	public Iterable<UserApp> findAllDoctors() {
		return userRepository.findByType(UserType.doctor);
	}


	public void delete(UserApp user) {
		userRepository.delete(user);

	}

	public UserGender[] getGenders() {
		
		return UserGender.values();
	}

	public UserType[] getTypes() {
		// TODO Auto-generated method stub
		return UserType.values();
	}
	*/
}
