package icesi.edu.co.stm.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import icesi.edu.co.stm.model.Tmio1Bus;
import icesi.edu.co.stm.model.Tmio1BusDriver;
import icesi.edu.co.stm.model.Tmio1Route;
import icesi.edu.co.stm.model.Tmio1Servicio;
import icesi.edu.co.stm.model.Tmio1ServicioPK;
import icesi.edu.co.stm.repository.IServiceRepository;

@Service
public class SesviceService implements IServiceService{

	@Override
	public void save(Tmio1Servicio service) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Tmio1Servicio> findById(Tmio1ServicioPK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Tmio1Servicio> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Tmio1Servicio service) {
		// TODO Auto-generated method stub
		
	}
	/*
	private IServiceRepository serviceRepository;
	
	@Autowired
	public SesviceService(IServiceRepository serviceRepository) {
		// TODO Auto-generated constructor stub
		this.serviceRepository = serviceRepository;
	}

	@Override
	public void save(Tmio1Servicio service) {
		// TODO Auto-generated method stub
		serviceRepository.save(service);
		
	}
	
	
	@Override
	public Optional<Tmio1Servicio> findById(Tmio1ServicioPK id) {
		// TODO Auto-generated method stub
		return serviceRepository.findById(id);
	}

	@Override
	public Iterable<Tmio1Servicio> findAll() {
		// TODO Auto-generated method stub
		return serviceRepository.findAll();
	}

	@Override
	public void delete(Tmio1Servicio service) {
		// TODO Auto-generated method stub
		
	}
	
	*/
}
