package icesi.edu.co.stm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import icesi.edu.co.stm.model.Tmio1SitiosRuta;
import icesi.edu.co.stm.model.Tmio1SitiosRutaPK;

@Repository
public class SitioRutaDao implements ISitioRutaDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Tmio1SitiosRuta entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
	}

	@Override
	public void update(Tmio1SitiosRuta entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);
	}

	@Override
	public void delete(Tmio1SitiosRuta entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);
	}

	@Override
	public Tmio1SitiosRuta findById(Tmio1SitiosRutaPK id) {
		// TODO Auto-generated method stub
		return entityManager.find(Tmio1SitiosRuta.class, id);
	}

	@Override
	public List<Tmio1SitiosRuta> findAll() {
		// TODO Auto-generated method stub
		String jpql = "Select s from Tmio1SitiosRuta s";
		return entityManager.createQuery(jpql).getResultList();
	}

}
