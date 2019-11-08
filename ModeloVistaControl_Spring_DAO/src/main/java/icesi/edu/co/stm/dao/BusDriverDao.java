package icesi.edu.co.stm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import icesi.edu.co.stm.model.Tmio1BusDriver;
@Repository
public class BusDriverDao implements IBusDriverDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void save(Tmio1BusDriver entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
	}

	@Override
	public void update(Tmio1BusDriver entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);
	}

	@Override
	public void delete(Tmio1BusDriver entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);
	}

	@Override
	public Tmio1BusDriver findById(String id) {
		// TODO Auto-generated method stub
		return entityManager.find(Tmio1BusDriver.class, id);
	}

	@Override
	public List<Tmio1BusDriver> findAll() {
		// TODO Auto-generated method stub
		String jpql = "Select d from Tmio1BusDriver d";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Tmio1BusDriver> findByName(String name) {
		// TODO Auto-generated method stub
		String jpql = "Select d from Tmio1BusDriver d where d.nombre ='"+name+"'";
		return entityManager.createQuery(jpql).getResultList();	
	}

	@Override
	public List<Tmio1BusDriver> findByLastName(String lastname) {
		// TODO Auto-generated method stub
		String jpql = "Select d from Tmio1BusDriver d where d.apellido ='"+lastname+"'";
		return entityManager.createQuery(jpql).getResultList();	
	}

}
