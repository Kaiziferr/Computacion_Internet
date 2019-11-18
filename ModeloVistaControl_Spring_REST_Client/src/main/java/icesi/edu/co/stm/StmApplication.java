package icesi.edu.co.stm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import icesi.edu.co.stm.model.Tmio1User;
import icesi.edu.co.stm.repository.IUserRepository;

@SpringBootApplication

public class StmApplication {
	
	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(StmApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(IUserRepository userRepository) {
		return (args) -> {
			//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        
			Tmio1User user = new Tmio1User();
			user.setName("steve");
			user.setPassword("{noop}123");
			user.setType(icesi.edu.co.stm.model.UserType.admin);
			user.setLastname("bernal");
			user.setUsername("kilito");
			userRepository.save(user);
			
			Tmio1User user2 = new Tmio1User();
			user2.setName("ana");
			user2.setPassword("{noop}123");
			user2.setType(icesi.edu.co.stm.model.UserType.operator);
			user2.setLastname("bernal");
			user2.setUsername("anita");
			userRepository.save(user2);
			};
		}

}
