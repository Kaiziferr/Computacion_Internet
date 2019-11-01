package icesi.edu.co.stm.service;

import java.awt.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import icesi.edu.co.stm.model.Tmio1BusDriver;
import icesi.edu.co.stm.repository.IDriverBusRepository;
import lombok.Data;
@Service
@Data
public class DriverBusService implements IDriverBusService{

	private IDriverBusRepository driverBusRepository;
	
	private String ced;
	
	public DriverBusService(IDriverBusRepository driverBusRepository) {
		// TODO Auto-generated constructor stub
		this.driverBusRepository = driverBusRepository;
	}
	
	@Override
	public void save(Tmio1BusDriver busdriver) {
		// TODO Auto-generated method stub
		driverBusRepository.save(busdriver);
	}

	@Override
	public Optional<Tmio1BusDriver> findById(String id) {
		// TODO Auto-generated method stub
		return driverBusRepository.findById(id);
	}

	@Override
	public Iterable<Tmio1BusDriver> findAll(boolean flag) {
		// TODO Auto-generated method stub
		if(flag) { 
			ArrayList<Tmio1BusDriver> a = new ArrayList<>();
			a.add(findById(ced).get());
			return a;
		}
		return driverBusRepository.findAll();
	}

	@Override
	public void delete(Tmio1BusDriver bus) {
		// TODO Auto-generated method stub
		
	}

}
