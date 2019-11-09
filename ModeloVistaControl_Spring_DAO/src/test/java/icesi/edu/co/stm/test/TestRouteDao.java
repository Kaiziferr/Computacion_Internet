package icesi.edu.co.stm.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
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
import icesi.edu.co.stm.dao.IRouteDao;
import icesi.edu.co.stm.model.Tmio1Route;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StmApplication.class)
@Rollback
public class TestRouteDao {
	
	@Autowired
	private IRouteDao iRouteDao;
	
	@Before
	public void setup() {
		Tmio1Route route = new Tmio1Route();
		route.setActiva("Activa");
		route.setDescripcion("es captoca");
		route.setDiaInicio(new BigDecimal(1));
		route.setDiaFin(new BigDecimal(5));
		route.setHoraInicio(new BigDecimal(6));
		route.setHoraFin(new BigDecimal(24));
		route.setNumero("A11");
		iRouteDao.save(route);
		
		Tmio1Route route2 = new Tmio1Route();
		route2.setActiva("Activa");
		route2.setDescripcion("no caoticar");
		route2.setDiaInicio(new BigDecimal(1));
		route2.setDiaFin(new BigDecimal(7));
		route2.setHoraInicio(new BigDecimal(5));
		route2.setHoraFin(new BigDecimal(23));
		route2.setNumero("E21");
		iRouteDao.save(route2);
		
		Tmio1Route route3 = new Tmio1Route();
		route3.setActiva("Activa");
		route3.setDescripcion("Troncal");
		route3.setDiaInicio(new BigDecimal(1));
		route3.setDiaFin(new BigDecimal(7));
		route3.setHoraInicio(new BigDecimal(5));
		route3.setHoraFin(new BigDecimal(23));
		route3.setNumero("E31");
		iRouteDao.save(route3);

		Tmio1Route route4 = new Tmio1Route();
		route4.setActiva("Activa");
		route4.setDescripcion("Trafico");
		route4.setDiaInicio(new BigDecimal(1));
		route4.setDiaFin(new BigDecimal(7));
		route4.setHoraInicio(new BigDecimal(5));
		route4.setHoraFin(new BigDecimal(23));
		route4.setNumero("E41");
		iRouteDao.save(route4);
	
	
		Tmio1Route route5 = new Tmio1Route();
		route5.setActiva("Activa");
		route5.setDescripcion("Es calmad");
		route5.setDiaInicio(new BigDecimal(1));
		route5.setDiaFin(new BigDecimal(5));
		route5.setHoraInicio(new BigDecimal(5));
		route5.setHoraFin(new BigDecimal(23));
		route5.setNumero("A21");
		iRouteDao.save(route5);
	
	}
	
	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testConection() {
		assertNotNull(iRouteDao);
	}
	
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindAll() {
		assertTrue(iRouteDao.findAll().size()==5);
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testSave() {

		Tmio1Route route = new Tmio1Route();
		route.setActiva("Activa");
		route.setDescripcion("Es buena");
		route.setDiaInicio(new BigDecimal(1));
		route.setDiaFin(new BigDecimal(5));
		route.setHoraInicio(new BigDecimal(6));
		route.setHoraFin(new BigDecimal(23));
		route.setNumero("A11");
		iRouteDao.save(route);
		Tmio1Route route2 = iRouteDao.findById(route.getId());
		assertTrue(route2.equals(route));
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testDelete() {
		Tmio1Route route = new Tmio1Route();
		route.setActiva("Desactivada");
		route.setDescripcion("Es Petroncal");
		route.setDiaInicio(new BigDecimal(6));
		route.setDiaFin(new BigDecimal(7));
		route.setHoraInicio(new BigDecimal(6));
		route.setHoraFin(new BigDecimal(22));
		route.setNumero("A11B");
		iRouteDao.save(route);
		iRouteDao.delete(route);
		Tmio1Route routed = iRouteDao.findById(route.getId());
		assertNull(routed);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testUpdate() {
		Tmio1Route route = new Tmio1Route();
		route.setActiva("Activa");
		route.setDescripcion("Es Troncal");
		route.setDiaInicio(new BigDecimal(1));
		route.setDiaFin(new BigDecimal(7));
		route.setHoraInicio(new BigDecimal(5));
		route.setHoraFin(new BigDecimal(24));
		route.setNumero("E21");
		iRouteDao.save(route);
		
		Tmio1Route update = iRouteDao.findById(route.getId());
		update.setActiva("Desactivada");
		update.setDescripcion("Es petroncal");
		update.setDiaInicio(new BigDecimal(2));
		update.setDiaFin(new BigDecimal(6));
		update.setHoraInicio(new BigDecimal(7));
		update.setHoraFin(new BigDecimal(21));
		iRouteDao.update(update);
		
		Tmio1Route update2 =  iRouteDao.findById(route.getId());
		assertTrue(update.equals(update2));
	}
	

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testRangeHours(){
		BigDecimal startHour = new BigDecimal(5);
		BigDecimal endHour = new BigDecimal(23);
		List<Tmio1Route> routes = iRouteDao.findByHour(startHour, endHour);
		int isT = 0;
		if(!routes.isEmpty()) {
			for(int i=0;i<routes.size();i++){
				if(routes.get(i).getHoraInicio().compareTo(startHour)>=0 && routes.get(i).getHoraFin().compareTo(endHour)<=0) {
					isT++;
				}
			}
		}
		assertTrue(isT==routes.size() && routes.size()>0);
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testRangeHoursFail(){
		BigDecimal startHour = new BigDecimal(23);
		BigDecimal endHour = new BigDecimal(24);
		List<Tmio1Route> routes = iRouteDao.findByHour(startHour, endHour);
		int isT = 0;
		if(!routes.isEmpty()) {
			for(int i=0;i<routes.size();i++){
				if(routes.get(i).getHoraInicio().compareTo(startHour)>=0 && routes.get(i).getHoraFin().compareTo(endHour)<=0) {
					isT++;
				}
			}
		}
		assertTrue(isT==0);
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testRangeDay(){
		BigDecimal startDay = new BigDecimal(1);
		BigDecimal endDay = new BigDecimal(5);
		List<Tmio1Route> routes = iRouteDao.findByDay(startDay, endDay);
		int isT = 0;
		if(!routes.isEmpty()) {
			for(int i=0;i<routes.size();i++){
				if(routes.get(i).getDiaInicio().compareTo(startDay)>=0 && routes.get(i).getDiaFin().compareTo(endDay)<=0) {
					isT++;
				}
			}
		}
		assertTrue(isT==routes.size() && routes.size()>0);
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testRangeDayFail(){
		BigDecimal startDay = new BigDecimal(6);
		BigDecimal endDay = new BigDecimal(9);
		List<Tmio1Route> routes = iRouteDao.findByDay(startDay, endDay);
		int isT = 0;
		if(!routes.isEmpty()) {
			for(int i=0;i<routes.size();i++){
				if(routes.get(i).getDiaInicio().compareTo(startDay)>=0 && routes.get(i).getDiaFin().compareTo(endDay)<=0) {
					isT++;
				}
			}
		}
		assertTrue(isT==0);
	}
	
	
}
