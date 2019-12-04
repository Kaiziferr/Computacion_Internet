package icesi.edu.co.stm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import icesi.edu.co.stm.dao.ISitioDao;
import icesi.edu.co.stm.model.Tmio1Sitio;

@Service
public class SitioService implements ISitioService{

	private ISitioDao iSitioDao;
	
	@Autowired
	public SitioService(ISitioDao iSitioDao) {
		this.iSitioDao = iSitioDao;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void save(Tmio1Sitio entity) {
		// TODO Auto-generated method stub
		iSitioDao.save(entity);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Tmio1Sitio sitioDelete = iSitioDao.findById(id);
		iSitioDao.delete(sitioDelete);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void update(Tmio1Sitio entity, Long id) {
		// TODO Auto-generated method stub
		Tmio1Sitio sitioUpdate = iSitioDao.findById(id);
		sitioUpdate.setDescripcion(entity.getDescripcion());
		sitioUpdate.setNombre(entity.getNombre());
		sitioUpdate.setTmio1ServiciosSitios(entity.getTmio1ServiciosSitios());
		sitioUpdate.setTmio1SitiosRutas1(entity.getTmio1SitiosRutas1());
		sitioUpdate.setTmio1SitiosRutas2(entity.getTmio1SitiosRutas2());
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public Tmio1Sitio findById(Long id) {
		// TODO Auto-generated method stub
		return iSitioDao.findById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public Iterable<Tmio1Sitio> findAll() {
		// TODO Auto-generated method stub
		return iSitioDao.findAll();
	}

}
