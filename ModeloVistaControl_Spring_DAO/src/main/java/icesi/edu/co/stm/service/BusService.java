package icesi.edu.co.stm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import icesi.edu.co.stm.model.Tmio1Bus;
import icesi.edu.co.stm.repository.IBusRepository;


@Service
public class BusService implements IBusService{
	

	private IBusRepository IbusRepository;
	
	@Autowired
	public BusService(IBusRepository IbusRepository) {
		this.IbusRepository = IbusRepository;
	} 
	

	@Override
	public void save(Tmio1Bus bus) {
		// TODO Auto-generated method stub
		IbusRepository.save(bus);
	}

	@Override
	public Optional<Tmio1Bus> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Tmio1Bus> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Tmio1Bus bus) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * private IBusRepository busRepository;
	 
	 

	@Autowired
	public BusService(IBusRepository busRepository) {
		this.busRepository = busRepository;
	}
	
	
	@Override
	public void save(Tmio1Bus bus) {
		// TODO Auto-generated method stub
		busRepository.save(bus);
	}

	@Override
	public Optional<Tmio1Bus> findById(Integer id) {
		// TODO Auto-generated method stub
		return busRepository.findById(id);
	}

	@Override
	public Iterable<Tmio1Bus> findAll() {
		// TODO Auto-generated method stub
		return busRepository.findAll();
	}

	@Override
	public void delete(Tmio1Bus bus) {
		// TODO Auto-generated method stub
		busRepository.delete(bus);
	}
*/
}
