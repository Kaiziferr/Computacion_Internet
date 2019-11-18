package icesi.edu.co.stm.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import icesi.edu.co.stm.dao.IBusDao;
import icesi.edu.co.stm.model.Tmio1User;
import icesi.edu.co.stm.repository.IUserRepository;

@Service
public class MyCustomUserDetailsService implements UserDetailsService {
	
	private IBusDao userRepository;

	@Autowired
	public MyCustomUserDetailsService(IBusDao userRepository) {
		this.userRepository = userRepository;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Tmio1User user = userRepository.findByUsername(username).get(0);
		if (user != null) {
			User.UserBuilder builder = User.withUsername(username).password(user.getPassword())
					.roles(user.getType().toString());
			return builder.build();
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
	}
}