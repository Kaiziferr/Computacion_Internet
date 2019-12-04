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
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Tmio1Route route = iRouteDao.findById(id);
		iRouteDao.delete(route);
	}
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void update(Tmio1Route entity, Integer id) {
		// TODO Auto-generated method stub
		Tmio1Route route = iRouteDao.findById(id);
		route.setActiva(entity.getActiva());
		route.setDescripcion(entity.getDescripcion());
		route.setDiaFin(entity.getDiaFin());
		route.setDiaInicio(entity.getDiaInicio());
		route.setHoraFin(entity.getHoraFin());
		route.setHoraInicio(entity.getHoraInicio());
		route.setNumero(entity.getNumero());
		route.setTmio1Servicios(entity.getTmio1Servicios());
		route.setTmio1ServiciosSitios(entity.getTmio1ServiciosSitios());
		route.setTmio1SitiosRutas1(entity.getTmio1SitiosRutas1());
		route.setTmio1SitiosRutas2(entity.getTmio1SitiosRutas2());
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public Tmio1Route findById(Integer id) {
		// TODO Auto-generated method stub
		return iRouteDao.findById(id);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public Iterable<Tmio1Route> findAll() {
		// TODO Auto-generated method stub
		return iRouteDao.findAll();
	}

	
}
