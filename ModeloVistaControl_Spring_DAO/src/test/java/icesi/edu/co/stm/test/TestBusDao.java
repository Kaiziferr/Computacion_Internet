package icesi.edu.co.stm.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import icesi.edu.co.stm.StmApplication;
import icesi.edu.co.stm.dao.IBusDao;
import icesi.edu.co.stm.model.Tmio1Bus;
@RunWith(SpringJUnit4ClassRunner.class)
@Rollback(false)
public class TestBusDao {
	
	@Autowired
	private IBusDao IbusDao;
	
	@Before
	public void setup() {

		Tmio1Bus bus = new Tmio1Bus();
		bus.setCapacidad(new BigDecimal(160));
		bus.setMarca("Mazda");
		bus.setModelo(new BigDecimal(1));
		bus.setPlaca("xyz-234");
		bus.setTipo("T");
		IbusDao.save(bus);
		
		
		Tmio1Bus bus1 = new Tmio1Bus();
		bus1.setCapacidad(new BigDecimal(80));
		bus1.setMarca("Chebrolet");
		bus1.setModelo(new BigDecimal(1));
		bus1.setPlaca("abc-124");
		bus1.setTipo("P");
		IbusDao.save(bus1);
		
		
		Tmio1Bus bus2 = new Tmio1Bus();
		bus2.setCapacidad(new BigDecimal(60));
		bus2.setMarca("Git");
		bus2.setModelo(new BigDecimal(2));
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
	
	

	
	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void tetsFindByModelo() {
		assertNotNull(IbusDao);
		BigDecimal modelo = new BigDecimal(1);
		List<Tmio1Bus> buses = IbusDao.findByModelo(modelo);
		assertTrue(!buses.isEmpty());
		int isT = 0;
		if(!buses.isEmpty()) {
			for(int i=0;i<buses.size();i++) {
				if(buses.get(i).getModelo().equals(modelo)) {
					isT ++;
				}
			}
		}
		assertTrue(isT==buses.size());
	}
	
	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void tetsFindByModeloFail() {
		assertNotNull(IbusDao);
		BigDecimal modelo = new BigDecimal(1000);
		List<Tmio1Bus> buses = IbusDao.findByModelo(modelo);
		assertFalse(!buses.isEmpty());
		int isT = 0;
		if(!buses.isEmpty()) {
			for(int i=0;i<buses.size();i++) {
				if(buses.get(i).getModelo().equals(modelo)) {
					isT ++;
				}
			}
		}
		assertTrue(isT==0);
	}
	
	
	
	
	
	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindByMarca() {
		assertNotNull(IbusDao);
		String marca = "Mazda";
		List<Tmio1Bus> buses = IbusDao.findByMarca(marca);
		assertTrue(!buses.isEmpty());

		int isT = 0;
		if(!buses.isEmpty()) {
			for(int i=0;i<buses.size();i++) {
				if(buses.get(i).getMarca().equals(marca)) {
					isT ++;
				}
			}
		}
		assertTrue(isT==buses.size());
	}

	
	
	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindByMarcaFail() {
		assertNotNull(IbusDao);
		String marca = "Falla";
		List<Tmio1Bus> buses = IbusDao.findByMarca(marca);
		assertFalse(!buses.isEmpty());

		int isT = 0;
		if(!buses.isEmpty()) {
			for(int i=0;i<buses.size();i++) {
				if(buses.get(i).getMarca().equals(marca)) {
					isT ++;
				}
			}
		}
		assertTrue(isT==0);
	}
	
	
	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindByPlaca() {
		
		Tmio1Bus bus3 = new Tmio1Bus();
		bus3.setCapacidad(new BigDecimal(75));
		bus3.setMarca("Blanco");
		bus3.setModelo(new BigDecimal(3));
		bus3.setPlaca("axv-234");
		bus3.setTipo("P");
		IbusDao.save(bus3);
		
		assertNotNull(IbusDao);
		List<Tmio1Bus> buses = IbusDao.findByPlaca(bus3.getPlaca());
		assertTrue(!buses.isEmpty());
		assertTrue(buses.get(0).equals(bus3));
	}
	
	

	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindByPlacaFail() {
		assertNotNull(IbusDao);
		List<Tmio1Bus> buses = IbusDao.findByPlaca("Fail");
		assertFalse(!buses.isEmpty());
	}
}


