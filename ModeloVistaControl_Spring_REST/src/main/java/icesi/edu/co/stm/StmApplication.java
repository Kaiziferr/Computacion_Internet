package icesi.edu.co.stm;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import icesi.edu.co.stm.model.Tmio1Bus;
import icesi.edu.co.stm.model.Tmio1User;
import icesi.edu.co.stm.repository.IBusRepository;
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
	public CommandLineRunner demo(IBusRepository busRepository) {
		return (args) -> {
			//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        /*
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
			*/
			
			Tmio1Bus bus1 = new Tmio1Bus();
			bus1.setCapacidad(new BigDecimal(1));
			bus1.setMarca("ALibaba");
			bus1.setPlaca("XLOS");
			bus1.setModelo(new BigDecimal(12));
			bus1.setTipo("125");
			busRepository.save(bus1);
			
			Tmio1Bus bus2 = new Tmio1Bus();
			bus2.setCapacidad(new BigDecimal(1));
			bus2.setMarca("ALibaba");
			bus2.setPlaca("XLOS");
			bus2.setModelo(new BigDecimal(12));
			bus2.setTipo("125");
			busRepository.save(bus2);
			
		};
	}
}
