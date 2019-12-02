package icesi.edu.co.stm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import icesi.edu.co.stm.dao.ISitioRutaDao;
import icesi.edu.co.stm.model.Tmio1SitiosRuta;
import icesi.edu.co.stm.model.Tmio1SitiosRutaPK;

@Service
public class SitioRutaService implements ISitioRutaService{

	
	private ISitioRutaDao iSitioRutaDao; 
	
	@Autowired
	public SitioRutaService(ISitioRutaDao iSitioRutaDao) {
		this.iSitioRutaDao = iSitioRutaDao;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void save(Tmio1SitiosRuta entity) {
		// TODO Auto-generated method stub
		iSitioRutaDao.save(entity);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void delete(Tmio1SitiosRutaPK id) {
		// TODO Auto-generated method stub
		Tmio1SitiosRuta sitioRutaDelete = iSitioRutaDao.findById(id);
		iSitioRutaDao.delete(sitioRutaDelete);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void update(Tmio1SitiosRuta entity, Tmio1SitiosRutaPK id) {
		// TODO Auto-generated method stub
		Tmio1SitiosRuta sitioRutaUpdate = iSitioRutaDao.findById(id);
		sitioRutaUpdate.setId(entity.getId());
		sitioRutaUpdate.setTmio1Ruta1(entity.getTmio1Ruta1());
		sitioRutaUpdate.setTmio1Ruta2(entity.getTmio1Ruta2());
		sitioRutaUpdate.setTmio1Sitio1(entity.getTmio1Sitio1());
		sitioRutaUpdate.setTmio1Sitio2(entity.getTmio1Sitio2());
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public Tmio1SitiosRuta findById(Tmio1SitiosRutaPK id) {
		// TODO Auto-generated method stub
		return iSitioRutaDao.findById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public List<Tmio1SitiosRuta> findAll() {
		// TODO Auto-generated method stub
		return iSitioRutaDao.findAll();
	}

}
