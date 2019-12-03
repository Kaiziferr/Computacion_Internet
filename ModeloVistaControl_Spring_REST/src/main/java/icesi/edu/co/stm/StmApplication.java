package icesi.edu.co.stm;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import icesi.edu.co.stm.dao.IBusDao;
import icesi.edu.co.stm.model.Tmio1Bus;
import icesi.edu.co.stm.model.Tmio1BusDriver;
import icesi.edu.co.stm.model.Tmio1Route;
import icesi.edu.co.stm.model.Tmio1Servicio;
import icesi.edu.co.stm.model.Tmio1ServicioPK;

import icesi.edu.co.stm.repository.IBusRepository;
import icesi.edu.co.stm.repository.IDriverBusRepository;
import icesi.edu.co.stm.repository.IRouteRepository;
import icesi.edu.co.stm.repository.IServiceRepository;

@SpringBootApplication
public class StmApplication {

	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}

	public static void main(String[] args) {
		SpringApplication.run(StmApplication.class, args);
	}

	public CommandLineRunner demo(IBusDao busDao) {
		return (args) -> {
			// BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			/*
			 * Tmio1User user = new Tmio1User(); user.setName("steve");
			 * user.setPassword("{noop}123");
			 * user.setType(icesi.edu.co.stm.model.UserType.admin);
			 * user.setLastname("bernal"); user.setUsername("kilito");
			 * userRepository.save(user);
			 * 
			 * Tmio1User user2 = new Tmio1User(); user2.setName("ana");
			 * user2.setPassword("{noop}123");
			 * user2.setType(icesi.edu.co.stm.model.UserType.operator);
			 * user2.setLastname("bernal"); user2.setUsername("anita");
			 * userRepository.save(user2); };
			 */

			Tmio1Bus bus = new Tmio1Bus();
			bus.setCapacidad(new BigDecimal(160));
			bus.setMarca("Mazda");
			bus.setModelo(new BigDecimal(2));
			bus.setPlaca("xyz-234");
			bus.setTipo("T");
			busDao.save(bus);

//			Tmio1BusDriver busDriver = new Tmio1BusDriver();
//			busDriver.setNombre("Fulano");
//			busDriver.setApellido("Talcual");
//			busDriver.setFechaContratacion(LocalDate.of(2019, 5, 24));
//			busDriver.setFechaNacimiento(LocalDate.of(1990, 8, 30));
//			busDriver.setCedula("457896213");
//			busDriverDao.save(busDriver);
//
//			Tmio1Route route = new Tmio1Route();
//			route.setActiva("Activa");
//			route.setDescripcion("es captoca");
//			route.setDiaInicio(new BigDecimal(1));
//			route.setDiaFin(new BigDecimal(5));
//			route.setHoraInicio(new BigDecimal(6));
//			route.setHoraFin(new BigDecimal(24));
//			route.setNumero("A11");
//			routeDao.save(route);
//
//			Tmio1ServicioPK tmio1ServicioPK = new Tmio1ServicioPK();
//			tmio1ServicioPK.setCedulaConductor(busDriver.getCedula());
//			tmio1ServicioPK.setFechaFin(LocalDate.of(2019, 11, 9));
//			tmio1ServicioPK.setFechaInicio(LocalDate.of(2019, 10, 9));
//			tmio1ServicioPK.setIdBus(bus.getId());
//			tmio1ServicioPK.setIdRuta(route.getId());
//
//			Tmio1Servicio service = new Tmio1Servicio();
//			service.setId(tmio1ServicioPK);
//			service.setTmio1Bus(bus);
//			service.setTmio1Conductore(busDriver);
//			service.setTmio1Ruta(route);
//			serviceDao.save(service);

			Tmio1Bus bus2 = new Tmio1Bus();
			bus2.setCapacidad(new BigDecimal(80));
			bus2.setMarca("Chebrolet");
			bus2.setModelo(new BigDecimal(2));
			bus2.setPlaca("abc-124");
			bus2.setTipo("P");
			busDao.save(bus2);
//
//			Tmio1BusDriver busDriver2 = new Tmio1BusDriver();
//			busDriver2.setNombre("Juliana");
//			busDriver2.setApellido("Ramires");
//			busDriver2.setFechaNacimiento(LocalDate.of(1999, 5, 21));
//			busDriver2.setFechaContratacion(LocalDate.of(2015, 3, 20));
//			busDriver2.setCedula("23409777");
//			busDriverDao.save(busDriver2);
//
//			Tmio1Route route2 = new Tmio1Route();
//			route2.setActiva("Activa");
//			route2.setDescripcion("no caoticar");
//			route2.setDiaInicio(new BigDecimal(1));
//			route2.setDiaFin(new BigDecimal(7));
//			route2.setHoraInicio(new BigDecimal(5));
//			route2.setHoraFin(new BigDecimal(23));
//			route2.setNumero("E21");
//			routeDao.save(route2);
//
//			Tmio1ServicioPK tmio1ServicioPK2 = new Tmio1ServicioPK();
//			tmio1ServicioPK2.setCedulaConductor(busDriver2.getCedula());
//			tmio1ServicioPK2.setFechaFin(LocalDate.of(2019, 11, 9));
//			tmio1ServicioPK2.setFechaInicio(LocalDate.of(2019, 10, 9));
//			tmio1ServicioPK2.setIdBus(bus2.getId());
//			tmio1ServicioPK2.setIdRuta(route2.getId());
//
//			Tmio1Servicio service2 = new Tmio1Servicio();
//			service2.setId(tmio1ServicioPK2);
//			service2.setTmio1Bus(bus2);
//			service2.setTmio1Conductore(busDriver2);
//			service2.setTmio1Ruta(route2);
//			serviceDao.save(service2);

		};
	}
}
