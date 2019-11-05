package icesi.edu.co.stm.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import icesi.edu.co.stm.model.Tmio1Route;

@Repository
public class RouteDao implements IRouteDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void save(Tmio1Route entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
	}

	@Override
	public void update(Tmio1Route entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);
	}

	@Override
	public void delete(Tmio1Route entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);
	}

	@Override
	public Tmio1Route findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Tmio1Route.class, id);
	}
	


	@Override
	public List<Tmio1Route> findAll() {
		// TODO Auto-generated method stub
		String jpql = "Select r from Tmio1Route r";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Tmio1Route> findByDate(BigDecimal startDay, BigDecimal finalDay) {
		// TODO Auto-generated method stub
		String jpql = "Select r from Tmio1Route r where r.diaFin ="+ finalDay +" and r.diaInicio = "+startDay;
		return entityManager.createQuery(jpql).getResultList();	
	}

	@Override
	public List<Tmio1Route> findByHour(BigDecimal startHour, BigDecimal finalHour) {
		// TODO Auto-generated method stub
		String jpql = "Select r from Tmio1Route r where r.horaFin ="+ finalHour +" and r.horaInicio = "+startHour;
		return entityManager.createQuery(jpql).getResultList();
	}
	
	
}
