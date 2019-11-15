package icesi.edu.co.stm.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import icesi.edu.co.stm.model.Tmio1Servicio;
import icesi.edu.co.stm.model.Tmio1ServicioPK;

@Repository
public class ServiceDao implements IServiceDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Tmio1Servicio entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
	}

	@Override
	public void update(Tmio1Servicio entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);
	}

	@Override
	public void delete(Tmio1Servicio entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);
	}

	@Override
	public Tmio1Servicio findById(Tmio1ServicioPK id) {
		// TODO Auto-generated method stub
		return entityManager.find(Tmio1Servicio.class, id);
	}

	@Override
	public List<Tmio1Servicio> findAll() {
		// TODO Auto-generated method stub
		String jpql = "Select s from Tmio1Servicio s";
		return entityManager.createQuery(jpql).getResultList();
	}


}
