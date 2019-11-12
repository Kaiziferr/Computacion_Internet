package icesi.edu.co.stm.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
public class TestBusDriverDao {

	@Autowired
	private IBusDriverDao IbusDriverDao;
	
	@Autowired
	private IBusDao IbusDao;
	
	@Autowired
	private IServiceDao iServiceDao;
	
	@Autowired
	private IRouteDao iRouteDao;
	
	@Before
	public void setup() {
		
		Tmio1BusDriver busDriver2 = new Tmio1BusDriver();
		busDriver2.setNombre("Camilo");
		busDriver2.setApellido("Galviz");
		busDriver2.setFechaNacimiento(LocalDate.of(1999, 5, 21));
		busDriver2.setFechaContratacion(LocalDate.of(2015, 3, 20));
		busDriver2.setCedula("23456677");
		IbusDriverDao.save(busDriver2);

		
		Tmio1BusDriver busDriver3 = new Tmio1BusDriver();
		busDriver3.setNombre("Juliana");
		busDriver3.setApellido("Ramires");
		busDriver3.setFechaNacimiento(LocalDate.of(1999, 5, 21));
		busDriver3.setFechaContratacion(LocalDate.of(2015, 3, 20));
		busDriver3.setCedula("23409777");
		IbusDriverDao.save(busDriver3);
		
		Tmio1BusDriver busDriver = new Tmio1BusDriver();
		busDriver.setNombre("Daniel");
		busDriver.setApellido("Galvis");
		busDriver.setFechaNacimiento(LocalDate.of(2000, 3, 15));
		busDriver.setFechaContratacion(LocalDate.of(2019, 10, 5));
		busDriver.setCedula("12345667");
		IbusDriverDao.save(busDriver);
		
		Tmio1BusDriver busDriver4 = new Tmio1BusDriver();
		busDriver4.setNombre("Daniel");
		busDriver4.setApellido("Gomes");
		busDriver4.setFechaNacimiento(LocalDate.of(1999, 5, 21));
		busDriver4.setFechaContratacion(LocalDate.of(2015, 3, 20));
		busDriver4.setCedula("123456547");
		IbusDriverDao.save(busDriver4);
		
	
		
	}
	
	public void setup2() {
		Tmio1Bus bus = new Tmio1Bus();
		bus.setCapacidad(new BigDecimal(160));
		bus.setMarca("Mazda");
		bus.setModelo(new BigDecimal(2));
		bus.setPlaca("xyz-234");
		bus.setTipo("T");		
		IbusDao.save(bus);
		
		Tmio1BusDriver busDriver = new Tmio1BusDriver();
		busDriver.setNombre("Fulano");
		busDriver.setApellido("Talcual");
		busDriver.setFechaContratacion(LocalDate.of(2019, 5, 24));
		busDriver.setFechaNacimiento(LocalDate.of(1990, 8, 30));
		busDriver.setCedula("123e455");
		IbusDriverDao.save(busDriver);
		
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
		IbusDao.save(bus2);

		Tmio1BusDriver busDriver2 = new Tmio1BusDriver();
		busDriver2.setNombre("Juliana");
		busDriver2.setApellido("Ramires");
		busDriver2.setFechaNacimiento(LocalDate.of(1999, 5, 21));
		busDriver2.setFechaContratacion(LocalDate.of(2015, 3, 20));
		busDriver2.setCedula("5678yr45");
		IbusDriverDao.save(busDriver2);
		
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
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testConection() {
		assertNotNull(IbusDriverDao);
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindAll() {
		assertTrue(IbusDriverDao.findAll().size()==4);
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testSave() {
		Tmio1BusDriver busDriver = new Tmio1BusDriver();
		busDriver.setNombre("Fulano");
		busDriver.setApellido("Talcual");
		busDriver.setFechaContratacion(LocalDate.of(2019, 5, 24));
		busDriver.setFechaNacimiento(LocalDate.of(1990, 8, 30));
		busDriver.setCedula("457896213");
		IbusDriverDao.save(busDriver);
		Tmio1BusDriver alfa = IbusDriverDao.findById(busDriver.getCedula());
		assertTrue(alfa.equals(busDriver));
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testDelete() {
		Tmio1BusDriver busDriver = new Tmio1BusDriver();
		busDriver.setNombre("Carmen");
		busDriver.setApellido("Diaz");
		busDriver.setFechaContratacion(LocalDate.of(2019, 5, 24));
		busDriver.setFechaNacimiento(LocalDate.of(1990, 8, 30));
		busDriver.setCedula("1479638520");
		IbusDriverDao.save(busDriver);
		IbusDriverDao.delete(busDriver);
		Tmio1BusDriver beta = IbusDriverDao.findById(busDriver.getCedula());
		assertNull(beta);
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testUpdate() {
		Tmio1BusDriver busDriver = new Tmio1BusDriver();
		busDriver.setNombre("Tunomre");
		busDriver.setApellido("TuApellido");
		busDriver.setFechaContratacion(LocalDate.of(2015, 5, 24));
		busDriver.setFechaNacimiento(LocalDate.of(1980, 8, 30));
		busDriver.setCedula("1559963274");
		IbusDriverDao.save(busDriver);
		
		Tmio1BusDriver update1 = IbusDriverDao.findById(busDriver.getCedula());
		update1.setNombre("CambioName");
		update1.setApellido("CambioApellido");
		update1.setFechaContratacion(LocalDate.of(2013, 9, 12));
		update1.setFechaNacimiento(LocalDate.of(1991, 12, 24));
		IbusDriverDao.update(update1);
		
		Tmio1BusDriver update2 = IbusDriverDao.findById(busDriver.getCedula());
		
		assertTrue(update1.equals(update2));
		
	}
	
	
	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindByName() {
	
		String name = "Daniel";
		List<Tmio1BusDriver> busDriver = IbusDriverDao.findByName(name);
		int isT = 0;
		if(!busDriver.isEmpty()) {
			for(int i=0;i<busDriver.size();i++) {
				if(busDriver.get(i).getNombre().equals(name)) {
					isT ++;
				}
			}
		}
		assertTrue(isT==busDriver.size() && busDriver.size()>0);

	}
	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindByNameFail() {
		String name = "Anita";
		List<Tmio1BusDriver> busDriver = IbusDriverDao.findByName(name);
		int isT = 0;
		if(!busDriver.isEmpty()) {
			for(int i=0;i<busDriver.size();i++) {
				if(busDriver.get(i).getNombre().equals(name)) {
					isT ++;
				}
			}
		}
		assertTrue(isT==0);

	}
	
	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindByLastName() {		
		String lastName = "Galvis";
		List<Tmio1BusDriver> busDriver = IbusDriverDao.findByLastName(lastName);
		int isT = 0;
		if(!busDriver.isEmpty()) {
			for(int i=0;i<busDriver.size();i++) {
				if(busDriver.get(i).getApellido().equals(lastName)) {
					isT ++;
				}
			}
		}
		assertTrue(isT==busDriver.size() && busDriver.size()>0);
	}
	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindByLastNameFail() {
		String lastName = "Takuello";
		List<Tmio1BusDriver> busDriver = IbusDriverDao.findByLastName(lastName);
		int isT = 0;
		if(!busDriver.isEmpty()) {
			for(int i=0;i<busDriver.size();i++) {
				if(busDriver.get(i).getApellido().equals(lastName)) {
					isT ++;
				}
			}
		}
		assertTrue(isT==0);
	}
	

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void findByDateDriversItinerary(){
		setup2();
		String lastName = "Galvis";
		List<Tmio1BusDriver> busDriver =IbusDriverDao.findByDateDriversItinerary(LocalDate.of(2019, 10, 10));
		
		assertTrue( busDriver.size()>0);
	}
}
