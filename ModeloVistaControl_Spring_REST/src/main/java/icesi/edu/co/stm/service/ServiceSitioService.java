package icesi.edu.co.stm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import icesi.edu.co.stm.dao.IServiciosSitioDao;
import icesi.edu.co.stm.model.Tmio1ServiciosSitio;
import icesi.edu.co.stm.model.Tmio1ServiciosSitioPK;

@Service
public class ServiceSitioService implements IServiceSitioService{

	private IServiciosSitioDao iServiciosSitioDao;
	
	@Autowired
	public ServiceSitioService(IServiciosSitioDao iServiciosSitioDao) {
		 this.iServiciosSitioDao = iServiciosSitioDao;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void save(Tmio1ServiciosSitio entity) {
		// TODO Auto-generated method stub
		iServiciosSitioDao.save(entity);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void delete(Tmio1ServiciosSitioPK id) {
		// TODO Auto-generated method stub
		Tmio1ServiciosSitio delete = iServiciosSitioDao.findById(id);
		iServiciosSitioDao.delete(delete);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void update(Tmio1ServiciosSitio entity, Tmio1ServiciosSitioPK id) {
		// TODO Auto-generated method stub
		Tmio1ServiciosSitio sUpdate = iServiciosSitioDao.findById(id);
		sUpdate.setHoraReal(entity.getHoraReal());
		sUpdate.setId(entity.getId());
		sUpdate.setRealizado(entity.getRealizado());
		sUpdate.setTmio1Bus(entity.getTmio1Bus());
		sUpdate.setTmio1Conductore(entity.getTmio1Conductore());
		sUpdate.setTmio1Ruta(entity.getTmio1Ruta());
		sUpdate.setTmio1Sitio(entity.getTmio1Sitio());
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public Tmio1ServiciosSitio findById(Tmio1ServiciosSitioPK id) {
		// TODO Auto-generated method stub
		return iServiciosSitioDao.findById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public Iterable<Tmio1ServiciosSitio> findAll() {
		// TODO Auto-generated method stub
		return iServiciosSitioDao.findAll();
	}

}
