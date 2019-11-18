package icesi.edu.co.stm.test;

import static org.junit.Assert.assertFalse;
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
@Rollback
@SpringBootTest(classes = StmApplication.class)
public class TestBusDao {

	@Autowired
	private IBusDao IbusDao;
	
	@Autowired
	private IServiceDao iServiceDao;
	
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
		IbusDao.save(bus);

		Tmio1Bus bus1 = new Tmio1Bus();
		bus1.setCapacidad(new BigDecimal(80));
		bus1.setMarca("Chebrolet");
		bus1.setModelo(new BigDecimal(2));
		bus1.setPlaca("abc-124");
		bus1.setTipo("P");
		IbusDao.save(bus1);

		Tmio1Bus bus2 = new Tmio1Bus();
		bus2.setCapacidad(new BigDecimal(60));
		bus2.setMarca("Git");
		bus2.setModelo(new BigDecimal(4));
		bus2.setPlaca("alf-234");
		bus2.setTipo("A");
		IbusDao.save(bus2);

		Tmio1Bus bus3 = new Tmio1Bus();
		bus3.setCapacidad(new BigDecimal(75));
		bus3.setMarca("Blanco");
		bus3.setModelo(new BigDecimal(3));
		bus3.setPlaca("rts-234");
		bus3.setTipo("T");
		IbusDao.save(bus3);

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
		IbusDao.save(bus2);

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
		
		
		Tmio1ServicioPK tmio1ServicioPK3 = new Tmio1ServicioPK();
		tmio1ServicioPK2.setCedulaConductor(busDriver2.getCedula());
		tmio1ServicioPK2.setFechaFin(LocalDate.of(2019, 11, 9));
		tmio1ServicioPK2.setFechaInicio(LocalDate.of(2019,10,9));
		tmio1ServicioPK2.setIdBus(bus2.getId());
		tmio1ServicioPK2.setIdRuta(route2.getId());
		
		Tmio1Servicio service3 = new Tmio1Servicio();
		service3.setId(tmio1ServicioPK3);
		service3.setTmio1Bus(bus2);
		service3.setTmio1Conductore(busDriver2);
		service3.setTmio1Ruta(route2);
		iServiceDao.save(service3);
		
		Tmio1ServicioPK tmio1ServicioPK4 = new Tmio1ServicioPK();
		tmio1ServicioPK4.setCedulaConductor(busDriver2.getCedula());
		tmio1ServicioPK2.setFechaFin(LocalDate.of(2019, 11, 9));
		tmio1ServicioPK2.setFechaInicio(LocalDate.of(2019,10,9));
		tmio1ServicioPK2.setIdBus(bus2.getId());
		tmio1ServicioPK2.setIdRuta(route2.getId());
		
		Tmio1Servicio service4 = new Tmio1Servicio();
		service4.setId(tmio1ServicioPK3);
		service4.setTmio1Bus(bus2);
		service4.setTmio1Conductore(busDriver2);
		service4.setTmio1Ruta(route2);
		iServiceDao.save(service4);
		
		
	}
	
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testConection() {
		assertNotNull(IbusDao);
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindAll() {
		assertTrue(IbusDao.findAll().size()==4);
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testSave() {
		Tmio1Bus bus3 = new Tmio1Bus();
		bus3.setCapacidad(new BigDecimal(75));
		bus3.setMarca("Blanco y Negro");
		bus3.setModelo(new BigDecimal(8));
		bus3.setPlaca("rlm-222");
		bus3.setTipo("T");
		IbusDao.save(bus3);
		Tmio1Bus bus = IbusDao.findById(bus3.getId());
		assertTrue(bus.equals(bus3));
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testDelete() {
		Tmio1Bus bus3 = new Tmio1Bus();
		bus3.setCapacidad(new BigDecimal(75));
		bus3.setMarca("Blanco y Negro");
		bus3.setModelo(new BigDecimal(8));
		bus3.setPlaca("rts-234");
		bus3.setTipo("T");
		IbusDao.save(bus3);
		IbusDao.delete(bus3);
		Tmio1Bus bus = IbusDao.findById(bus3.getId());
		assertNull(bus);
		
	}
	
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testUpdate() {
		Tmio1Bus bus = new Tmio1Bus();
		bus.setCapacidad(new BigDecimal(160));
		bus.setMarca("Mazda");
		bus.setModelo(new BigDecimal(2));
		bus.setPlaca("beta-999");
		bus.setTipo("T");
		IbusDao.save(bus);
		
		Tmio1Bus busUpd = IbusDao.findById(bus.getId());
		 busUpd.setCapacidad(new BigDecimal(80));
		 busUpd.setMarca("Kiu");
		 busUpd.setModelo(new BigDecimal(1));
		 busUpd.setPlaca("beta-999");
		 busUpd.setTipo("P");
		 IbusDao.update( busUpd);
		 
		Tmio1Bus busUpd2 = IbusDao.findById(bus.getId());

		assertTrue(busUpd2.getCapacidad().equals(busUpd.getCapacidad()) && busUpd2.getMarca().equals(busUpd.getMarca())
				&& busUpd2.getModelo().equals(busUpd.getModelo()) && busUpd2.getPlaca().equals(busUpd.getPlaca())
				&& busUpd2.getTipo().equals(busUpd.getTipo()));
	}
	
	
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void tetsFindByModelo() {
		BigDecimal modelo = new BigDecimal(2);
		List<Tmio1Bus> buses = IbusDao.findByModelo(modelo);
		int isT = 0;
		if (!buses.isEmpty()) {
			for (int i = 0; i < buses.size(); i++) {
				if (buses.get(i).getModelo().equals(modelo)) {
					isT++;
				}
			}
		}
		assertTrue(isT == buses.size() && buses.size() > 0);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void tetsFindByModeloFail() {
		BigDecimal modelo = new BigDecimal(1000);
		List<Tmio1Bus> buses = IbusDao.findByModelo(modelo);
		int isT = 0;
		if (!buses.isEmpty()) {
			for (int i = 0; i < buses.size(); i++) {
				if (buses.get(i).getModelo().equals(modelo)) {
					isT++;
				}
			}
		}
		assertTrue(isT == 0);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindByMarca() {
		String marca = "Mazda";
		List<Tmio1Bus> buses = IbusDao.findByMarca(marca);
		int isT = 0;
		if (!buses.isEmpty()) {
			for (int i = 0; i < buses.size(); i++) {
				if (buses.get(i).getMarca().equals(marca)) {
					isT++;
				}
			}
		}
		assertTrue(isT == buses.size() && buses.size() > 0);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindByMarcaFail() {
		String marca = "Falla";
		List<Tmio1Bus> buses = IbusDao.findByMarca(marca);

		int isT = 0;
		if (!buses.isEmpty()) {
			for (int i = 0; i < buses.size(); i++) {
				if (buses.get(i).getMarca().equals(marca)) {
					isT++;
				}
			}
		}
		assertTrue(isT == 0);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindByPlaca() {
		Tmio1Bus bus3 = new Tmio1Bus();
		bus3.setCapacidad(new BigDecimal(75));
		bus3.setMarca("Blanco");
		bus3.setModelo(new BigDecimal(3));
		bus3.setPlaca("axv-234");
		bus3.setTipo("P");
		IbusDao.save(bus3);

		List<Tmio1Bus> buses = IbusDao.findByPlaca(bus3.getPlaca());
		assertTrue(!buses.isEmpty());
		assertTrue(buses.get(0).equals(bus3));
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindByPlacaFail() {
		List<Tmio1Bus> buses = IbusDao.findByPlaca("Fail");
		assertFalse(!buses.isEmpty());

	}
	

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindByDateDriversItinerary(){
		setup2();
	}
}
