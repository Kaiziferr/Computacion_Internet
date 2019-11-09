package icesi.edu.co.stm.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
import icesi.edu.co.stm.dao.IBusDriverDao;
import icesi.edu.co.stm.model.Tmio1BusDriver;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StmApplication.class)
@Rollback
public class TestBusDriverDao {

	@Autowired
	private IBusDriverDao IbusDriverDao;
	
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
}
