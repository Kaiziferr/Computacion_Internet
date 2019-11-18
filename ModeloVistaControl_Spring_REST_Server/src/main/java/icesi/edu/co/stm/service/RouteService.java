package icesi.edu.co.stm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import icesi.edu.co.stm.dao.IRouteDao;
import icesi.edu.co.stm.model.Tmio1Route;
@Service
public class RouteService implements IRouteService{
	
	private IRouteDao iRouteDao; 
	@Autowired
	public RouteService(IRouteDao iRouteDao) {
		// TODO Auto-generated constructor stub
		this.iRouteDao = iRouteDao;
	}
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void save(Tmio1Route entity) {
		// TODO Auto-generated method stub
		iRouteDao.save(entity);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void delete(Tmio1Route entity) {
		// TODO Auto-generated method stub
		iRouteDao.delete(entity);
	}
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void update(Tmio1Route entity) {
		// TODO Auto-generated method stub
		iRouteDao.update(entity);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public Tmio1Route findById(Integer id) {
		// TODO Auto-generated method stub
		return iRouteDao.findById(id);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public List<Tmio1Route> findAll() {
		// TODO Auto-generated method stub
		return iRouteDao.findAll();
	}

	
}
