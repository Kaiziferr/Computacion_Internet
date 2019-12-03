package icesi.edu.co.stm.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import icesi.edu.co.stm.model.Tmio1Bus;
@Repository
public class BusDao implements IBusDao{
	
	@PersistenceContext
	public EntityManager entityManager;

	@Override
	public void save(Tmio1Bus entity) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
	}

	@Override
	public void update(Tmio1Bus entity) {
		// TODO Auto-generated method stub
		entityManager.merge(entity);
	}

	@Override
	public void delete(Tmio1Bus entity) {
		// TODO Auto-generated method stub
		entityManager.remove(entity);
	}

	@Override
	public Tmio1Bus findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Tmio1Bus.class, id);
	}

	@Override
	public Iterable<Tmio1Bus> findAll() {
		// TODO Auto-generated method stub
		String jpql = "Select b from Tmio1Bus b";
			return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Tmio1Bus> findByPlaca(String placa) {
		// TODO Auto-generated method stub
		String jpql = "Select b from Tmio1Bus b where b.placa = '"+placa+"'";
		return entityManager.createQuery(jpql).getResultList();	
		
	}

	@Override
	public List<Tmio1Bus> findByModelo(BigDecimal modelo) {
		// TODO Auto-generated method stub
		String jpql = "Select b from Tmio1Bus b where b.modelo ="+ modelo.toString();
		return entityManager.createQuery(jpql).getResultList();	
		
	}

	@Override
	public List<Tmio1Bus> findByMarca(String marca) {
		// TODO Auto-generated method stub
		String jpql = "Select b from Tmio1Bus b where b.marca = '"+marca+"'";
		return entityManager.createQuery(jpql).getResultList();	
	}

	@Override
	public List<Tmio1Bus> findBylistBusesMoreServiceSameDay(BigDecimal dateService) {
		// TODO Auto-generated method stub
		
		String jpql = "Select b from Tmio1Bus b JOIN Tmio1Servicio s on b.id = s.id.idBus where '"+dateService+"' between s.id.fechaInicio and s.id.fechaFin group by b HAVING count(s)>1";
		return entityManager.createQuery(jpql).getResultList();	
	}

}
