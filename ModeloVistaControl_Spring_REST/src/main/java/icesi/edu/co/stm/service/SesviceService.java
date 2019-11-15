package icesi.edu.co.stm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import icesi.edu.co.stm.dao.IServiceDao;
import icesi.edu.co.stm.model.Tmio1Servicio;
import icesi.edu.co.stm.model.Tmio1ServicioPK;

@Service
public class SesviceService implements IServiceService{
	
	private IServiceDao iServiceDao;  
	@Autowired
	public SesviceService(IServiceDao iServiceDao) {
		// TODO Auto-generated constructor stub
		this.iServiceDao = iServiceDao;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void save(Tmio1Servicio entity) {
		// TODO Auto-generated method stub
		iServiceDao.save(entity);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void delete(Tmio1Servicio entity) {
		// TODO Auto-generated method stub
		iServiceDao.delete(entity);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void update(Tmio1Servicio entity) {
		// TODO Auto-generated method stub
		iServiceDao.update(entity);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public Tmio1Servicio findById(Tmio1ServicioPK id) {
		// TODO Auto-generated method stub
		return iServiceDao.findById(id);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public List<Tmio1Servicio> findAll() {
		// TODO Auto-generated method stub
		return iServiceDao.findAll();
	}
	
	
}
