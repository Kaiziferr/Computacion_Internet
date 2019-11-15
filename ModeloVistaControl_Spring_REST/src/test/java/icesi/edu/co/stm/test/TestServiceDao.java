package icesi.edu.co.stm.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import icesi.edu.co.stm.StmApplication;
import icesi.edu.co.stm.dao.IBusDao;
import icesi.edu.co.stm.dao.IBusDriverDao;
import icesi.edu.co.stm.dao.IRouteDao;
import icesi.edu.co.stm.dao.IServiceDao;
import icesi.edu.co.stm.model.Tmio1Bus;
import icesi.edu.co.stm.model.Tmio1BusDriver;
import icesi.edu.co.stm.model.Tmio1Route;
import icesi.edu.co.stm.model.Tmio1Servicio;
import icesi.edu.co.stm.model.Tmio1ServicioPK;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StmApplication.class)
@Rollback
public class TestServiceDao {

	@Autowired
	private IServiceDao iServiceDao;
	
	@Autowired
	private IBusDao iBusDao;
	
	@Autowired
	private IRouteDao iRouteDao;
	@Autowired
	private IBusDriverDao iBusDriverDao;
	
	@Before
	public void setup() {
		
		Tmio1Bus bus = new Tmio1Bus();
		bus.setCapacidad(new BigDecimal(160));
		bus.setMarca("Mazda");
		bus.setModelo(new BigDecimal(2));
		bus.setPlaca("xyz-234");
		bus.setTipo("T");		
		iBusDao.save(bus);
		
		Tmio1BusDriver busDriver = new Tmio1BusDriver();
		busDriver.setNombre("Fulano");
		busDriver.setApellido("Talcual");
		busDriver.setFechaContratacion(LocalDate.of(2019, 5, 24));
		busDriver.setFechaNacimiento(LocalDate.of(1990, 8, 30));
		busDriver.setCedula("457896213");
		iBusDriverDao.save(busDriver);
		
		Tmio1Route route = new Tmio1Route();
		route.setActiva("Activa");
		route.setDescripcion("es captoca");
		route.setDiaInicio(new BigDecimal(1));
		route.setDiaFin(new BigDecimal(5));
		route.setHoraInicio(new BigDecimal(6));
		route.setHoraFin(new BigDecimal(24));
		route.setNumero("A11");
		iRouteDao.save(route);
		
		Tmio1ServicioPK tmio1ServicioPK = new Tmio1ServicioPK();
		tmio1ServicioPK.setCedulaConductor(busDriver.getCedula());
		tmio1ServicioPK.setFechaFin(LocalDate.of(2019, 11, 9));
		tmio1ServicioPK.setFechaInicio(LocalDate.of(2019,10,9));
		tmio1ServicioPK.setIdBus(bus.getId());
		tmio1ServicioPK.setIdRuta(route.getId());
		
		Tmio1Servicio service = new Tmio1Servicio();
		service.setId(tmio1ServicioPK);
		service.setTmio1Bus(bus);
		service.setTmio1Conductore(busDriver);
		service.setTmio1Ruta(route);
		iServiceDao.save(service);
		
		Tmio1Bus bus2 = new Tmio1Bus();
		bus2.setCapacidad(new BigDecimal(80));
		bus2.setMarca("Chebrolet");
		bus2.setModelo(new BigDecimal(2));
		bus2.setPlaca("abc-124");
		bus2.setTipo("P");
		iBusDao.save(bus2);

		Tmio1BusDriver busDriver2 = new Tmio1BusDriver();
		busDriver2.setNombre("Juliana");
		busDriver2.setApellido("Ramires");
		busDriver2.setFechaNacimiento(LocalDate.of(1999, 5, 21));
		busDriver2.setFechaContratacion(LocalDate.of(2015, 3, 20));
		busDriver2.setCedula("23409777");
		iBusDriverDao.save(busDriver2);
		
		Tmio1Route route2 = new Tmio1Route();
		route2.setActiva("Activa");
		route2.setDescripcion("no caoticar");
		route2.setDiaInicio(new BigDecimal(1));
		route2.setDiaFin(new BigDecimal(7));
		route2.setHoraInicio(new BigDecimal(5));
		route2.setHoraFin(new BigDecimal(23));
		route2.setNumero("E21");
		iRouteDao.save(route2);
		
		Tmio1ServicioPK tmio1ServicioPK2 = new Tmio1ServicioPK();
		tmio1ServicioPK2.setCedulaConductor(busDriver2.getCedula());
		tmio1ServicioPK2.setFechaFin(LocalDate.of(2019, 11, 9));
		tmio1ServicioPK2.setFechaInicio(LocalDate.of(2019,10,9));
		tmio1ServicioPK2.setIdBus(bus2.getId());
		tmio1ServicioPK2.setIdRuta(route2.getId());
		
		Tmio1Servicio service2 = new Tmio1Servicio();
		service2.setId(tmio1ServicioPK2);
		service2.setTmio1Bus(bus2);
		service2.setTmio1Conductore(busDriver2);
		service2.setTmio1Ruta(route2);
		iServiceDao.save(service2);
	}
	
	
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testConection() {
		assertNotNull(iServiceDao);
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindAll() {
		assertTrue(iServiceDao.findAll().size()==2);
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testSave() {
		Tmio1Bus bus = new Tmio1Bus();
		bus.setCapacidad(new BigDecimal(160));
		bus.setMarca("Kia");
		bus.setModelo(new BigDecimal(2));
		bus.setPlaca("abc-234");
		bus.setTipo("P");		
		iBusDao.save(bus);
		
		Tmio1BusDriver busDriver = new Tmio1BusDriver();
		busDriver.setNombre("Carmen");
		busDriver.setApellido("Talcual");
		busDriver.setFechaContratacion(LocalDate.of(2019, 5, 24));
		busDriver.setFechaNacimiento(LocalDate.of(1990, 8, 30));
		busDriver.setCedula("123789564");
		iBusDriverDao.save(busDriver);
		
		Tmio1Route route = new Tmio1Route();
		route.setActiva("Activa");
		route.setDescripcion("es buena");
		route.setDiaInicio(new BigDecimal(1));
		route.setDiaFin(new BigDecimal(5));
		route.setHoraInicio(new BigDecimal(6));
		route.setHoraFin(new BigDecimal(24));
		route.setNumero("A17");
		iRouteDao.save(route);

		Tmio1ServicioPK tmio1ServicioPK = new Tmio1ServicioPK();
		tmio1ServicioPK.setCedulaConductor(busDriver.getCedula());
		tmio1ServicioPK.setFechaFin(LocalDate.of(2019, 11, 9));
		tmio1ServicioPK.setFechaInicio(LocalDate.of(2019,10,9));
		tmio1ServicioPK.setIdBus(bus.getId());
		tmio1ServicioPK.setIdRuta(route.getId());
		
		Tmio1Servicio service = new Tmio1Servicio();
		service.setId(tmio1ServicioPK);
		service.setTmio1Bus(bus);
		service.setTmio1Conductore(busDriver);
		service.setTmio1Ruta(route);
		iServiceDao.save(service);
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testDelete() {
		Tmio1Bus bus = new Tmio1Bus();
		bus.setCapacidad(new BigDecimal(160));
		bus.setMarca("Kia");
		bus.setModelo(new BigDecimal(2));
		bus.setPlaca("abc-234");
		bus.setTipo("P");		
		iBusDao.save(bus);
		
		Tmio1BusDriver busDriver = new Tmio1BusDriver();
		busDriver.setNombre("Carmen");
		busDriver.setApellido("Talcual");
		busDriver.setFechaContratacion(LocalDate.of(2019, 5, 24));
		busDriver.setFechaNacimiento(LocalDate.of(1990, 8, 30));
		busDriver.setCedula("123789564");
		iBusDriverDao.save(busDriver);
		
		Tmio1Route route = new Tmio1Route();
		route.setActiva("Activa");
		route.setDescripcion("es buena");
		route.setDiaInicio(new BigDecimal(1));
		route.setDiaFin(new BigDecimal(5));
		route.setHoraInicio(new BigDecimal(6));
		route.setHoraFin(new BigDecimal(24));
		route.setNumero("A17");
		iRouteDao.save(route);

		Tmio1ServicioPK tmio1ServicioPK = new Tmio1ServicioPK();
		tmio1ServicioPK.setCedulaConductor(busDriver.getCedula());
		tmio1ServicioPK.setFechaFin(LocalDate.of(2019, 11, 9));
		tmio1ServicioPK.setFechaInicio(LocalDate.of(2019,10,9));
		tmio1ServicioPK.setIdBus(bus.getId());
		tmio1ServicioPK.setIdRuta(route.getId());
		
		Tmio1Servicio service = new Tmio1Servicio();
		service.setId(tmio1ServicioPK);
		service.setTmio1Bus(bus);
		service.setTmio1Conductore(busDriver);
		service.setTmio1Ruta(route);
		iServiceDao.save(service);
		iServiceDao.delete(service);
		
		Tmio1Servicio serviceDe = iServiceDao.findById(service.getId());
		assertNull(serviceDe);
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testUpdate() {
		Tmio1Bus bus = new Tmio1Bus();
		bus.setCapacidad(new BigDecimal(160));
		bus.setMarca("Kia");
		bus.setModelo(new BigDecimal(2));
		bus.setPlaca("abc-234");
		bus.setTipo("P");		
		iBusDao.save(bus);
		
		Tmio1BusDriver busDriver = new Tmio1BusDriver();
		busDriver.setNombre("Carmen");
		busDriver.setApellido("Talcual");
		busDriver.setFechaContratacion(LocalDate.of(2019, 5, 24));
		busDriver.setFechaNacimiento(LocalDate.of(1990, 8, 30));
		busDriver.setCedula("123789564");
		iBusDriverDao.save(busDriver);
		
		Tmio1Route route = new Tmio1Route();
		route.setActiva("Activa");
		route.setDescripcion("es buena");
		route.setDiaInicio(new BigDecimal(1));
		route.setDiaFin(new BigDecimal(5));
		route.setHoraInicio(new BigDecimal(6));
		route.setHoraFin(new BigDecimal(24));
		route.setNumero("A17");
		iRouteDao.save(route);

		Tmio1ServicioPK tmio1ServicioPK = new Tmio1ServicioPK();
		tmio1ServicioPK.setCedulaConductor(busDriver.getCedula());
		tmio1ServicioPK.setFechaFin(LocalDate.of(2019, 11, 9));
		tmio1ServicioPK.setFechaInicio(LocalDate.of(2019,10,9));
		tmio1ServicioPK.setIdBus(bus.getId());
		tmio1ServicioPK.setIdRuta(route.getId());
		
		Tmio1Servicio service = new Tmio1Servicio();
		service.setId(tmio1ServicioPK);
		service.setTmio1Bus(bus);
		service.setTmio1Conductore(busDriver);
		service.setTmio1Ruta(route);
		iServiceDao.save(service);
		
		Tmio1Servicio update = iServiceDao.findById(service.getId());
		
		
		Tmio1Bus busUpdate = new Tmio1Bus();
		busUpdate.setCapacidad(new BigDecimal(160));
		busUpdate.setMarca("Mazda");
		busUpdate.setModelo(new BigDecimal(2));
		busUpdate.setPlaca("xyz-234");
		busUpdate.setTipo("T");		
		
		Tmio1BusDriver busDriverUpdate = new Tmio1BusDriver();
		busDriverUpdate.setNombre("Fulano");
		busDriverUpdate.setApellido("Talcual");
		busDriverUpdate.setFechaContratacion(LocalDate.of(2019, 5, 24));
		busDriverUpdate.setFechaNacimiento(LocalDate.of(1990, 8, 30));
		busDriverUpdate.setCedula("457896213");
		
		Tmio1Route routeUpdate = new Tmio1Route();
		routeUpdate.setActiva("Activa");
		routeUpdate.setDescripcion("es captoca");
		routeUpdate.setDiaInicio(new BigDecimal(1));
		routeUpdate.setDiaFin(new BigDecimal(5));
		routeUpdate.setHoraInicio(new BigDecimal(6));
		routeUpdate.setHoraFin(new BigDecimal(24));
		routeUpdate.setNumero("A11");

		
		update.setTmio1Bus(busUpdate);
		update.setTmio1Conductore(busDriverUpdate);
		update.setTmio1Ruta(routeUpdate);
		assertTrue(update.equals(service));
		
	}

	

	/*
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindBylistBusesMoreServiceSameDay(){
		
	}
	*/
}
