package icesi.edu.co.stm.repository;

import java.util.List;

import org.hibernate.usertype.UserType;
import org.springframework.data.repository.CrudRepository;


import icesi.edu.co.stm.model.Tmio1User;

public interface IUserRepository extends CrudRepository<Tmio1User, Integer>{
	
    List<Tmio1User> findByName(String name);
	
	List<Tmio1User> findByUsername(String username);
	
	List<Tmio1User> findByType(UserType type);

}
