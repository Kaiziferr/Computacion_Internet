package icesi.edu.co.stm.test;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import icesi.edu.co.stm.dao.IBusDao;
import icesi.edu.co.stm.model.Tmio1Bus;
@SpringBootTest
public class TestBusDao {
	
	@Autowired
	private IBusDao IbusDao;
	

		public void setupStage() {
		Tmio1Bus bus = new Tmio1Bus();
		bus.setId(1);
		bus.setCapacidad(new BigDecimal(75));
		bus.setMarca("Mazda");
		bus.setModelo(new BigDecimal(3));
		bus.setPlaca("xyz-234");
		bus.setTipo("T");
	}
	
	@Test
	public void tetsFindByModelo() {
		
		setupStage();
		BigDecimal modelo = new BigDecimal(2);
		
		System.out.println(IbusDao.findByModelo(modelo).get(0)+"Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
		List<Tmio1Bus> buses = IbusDao.findByModelo(modelo);
		boolean ismodel = true;
		for(int i=0;i<buses.size() && ismodel;i++) {
	    	if(buses.get(i).getModelo()!= modelo) {
	    		ismodel = false;
	    	}
	    }
		
		assertTrue(ismodel);
	}
}


