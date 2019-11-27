package icesi.edu.co.stm.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import icesi.edu.co.stm.dao.IBusDao;
import icesi.edu.co.stm.model.Tmio1Bus;


@Service
public class BusService implements IBusService{
	
	private IBusDao iBusDao;
	
	@Autowired
	public BusService(IBusDao iBusDao) {
		this.iBusDao = iBusDao;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void save(Tmio1Bus entity) {
		// TODO Auto-generated method stub
		iBusDao.save(entity);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Tmio1Bus bus = findById(id);
		iBusDao.delete(bus);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void update(Tmio1Bus entity,Integer id) {
		// TODO Auto-generated method stub
		Tmio1Bus bus = findById(id);
		bus = entity;
		iBusDao.save(bus);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public Tmio1Bus findById(Integer id) {
		// TODO Auto-generated method stub
		return iBusDao.findById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public List<Tmio1Bus> findAll() {
		// TODO Auto-generated method stub
		return iBusDao.findAll();
	}

	
	
	
}
