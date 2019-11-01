package icesi.edu.co.stm.service;

import java.util.Optional;

import icesi.edu.co.stm.model.Tmio1User;


public interface IUserService {

	public void save(Tmio1User user);

	public Optional<Tmio1User> findById(Integer id);

	public Iterable<Tmio1User> findAll();

	public void delete(Tmio1User user);


	//public UserType[] getTypes();

}
