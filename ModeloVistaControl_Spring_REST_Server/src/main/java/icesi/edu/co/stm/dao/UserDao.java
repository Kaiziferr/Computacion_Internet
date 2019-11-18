package icesi.edu.co.stm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import icesi.edu.co.stm.model.Tmio1User;

@Repository
public class UserDao implements IUserDao{

	@PersistenceContext
	private EntityManager entityManager; 
	
	@Override
	public void save(Tmio1User entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
	}

	@Override
	public void update(Tmio1User entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);
	}

	@Override
	public void delete(Tmio1User entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);
	}

	@Override
	public Tmio1User findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Tmio1User.class, id);
	}

	@Override
	public List<Tmio1User> findAll() {
		// TODO Auto-generated method stub
		String jpql = "Select u from Tmio1User u";
		return entityManager.createQuery(jpql).getResultList();
	}

}
