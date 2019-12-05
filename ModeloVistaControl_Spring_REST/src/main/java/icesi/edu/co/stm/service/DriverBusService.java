package icesi.edu.co.stm.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import icesi.edu.co.stm.dao.IBusDriverDao;
import icesi.edu.co.stm.model.Tmio1BusDriver;

@Service
public class DriverBusService implements IDriverBusService{

	private IBusDriverDao iBusDriverDao;
	@Autowired
	public DriverBusService(IBusDriverDao iBusDriverDao) {
		// TODO Auto-generated constructor stub
		this.iBusDriverDao = iBusDriverDao;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void save(Tmio1BusDriver entity) {
		// TODO Auto-generated method stub
		iBusDriverDao.save(entity);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		Tmio1BusDriver busDriverDelete = iBusDriverDao.findById(id);
		iBusDriverDao.delete(busDriverDelete);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void update(Tmio1BusDriver entity,String id) {
		// TODO Auto-generated method stub
		Tmio1BusDriver busDriverUpdate = iBusDriverDao.findById(id);
		busDriverUpdate.setApellido(entity.getApellido());
		busDriverUpdate.setFechaContratacion(entity.getFechaContratacion());
		busDriverUpdate.setFechaNacimiento(entity.getFechaNacimiento());
		busDriverUpdate.setNombre(entity.getNombre());
		busDriverUpdate.setTmio1Servicios(entity.getTmio1Servicios());
		busDriverUpdate.setTmio1ServiciosSitios(entity.getTmio1ServiciosSitios());
		busDriverUpdate.setCedula(entity.getCedula());
	
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public Tmio1BusDriver findById(String id) {
		// TODO Auto-generated method stub
		return iBusDriverDao.findById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public Iterable<Tmio1BusDriver> findAll() {
		// TODO Auto-generated method stub
		return iBusDriverDao.findAll();
	}


	
}
