package icesi.edu.co.stm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import icesi.edu.co.stm.model.Tmio1Sitio;

@Repository
public class SitioDao implements ISitioDao {

	@PersistenceContext
	private EntityManager entityManager; 
	
	@Override
	public void save(Tmio1Sitio entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
	}

	@Override
	public void update(Tmio1Sitio entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);
	}

	@Override
	public void delete(Tmio1Sitio entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);
	}

	@Override
	public Tmio1Sitio findById(Long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Tmio1Sitio.class, id);
	}

	@Override
	public List<Tmio1Sitio> findAll() {
		// TODO Auto-generated method stub
		String jpql = "Select s from Tmio1Sitio s";
		return entityManager.createQuery(jpql).getResultList();
	}

	
}
