package icesi.edu.co.stm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import icesi.edu.co.stm.model.Tmio1ServiciosSitio;
import icesi.edu.co.stm.model.Tmio1ServiciosSitioPK;
@Repository
public class ServiceSitio implements IServiciosSitioDao{

	@PersistenceContext
	private EntityManager entityManager; 
	
	@Override
	public void save(Tmio1ServiciosSitio entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
	}

	@Override
	public void update(Tmio1ServiciosSitio entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);
	}

	@Override
	public void delete(Tmio1ServiciosSitio entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);
	}

	@Override
	public Tmio1ServiciosSitio findById(Tmio1ServiciosSitioPK id) {
		// TODO Auto-generated method stub
		return entityManager.find(Tmio1ServiciosSitio.class, id);
	}

	@Override
	public List<Tmio1ServiciosSitio> findAll() {
		// TODO Auto-generated method stub
		String jpql = "Select s from Tmio1Bus s";
		return entityManager.createQuery(jpql).getResultList();
	}

}
