package icesi.edu.co.stm.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import icesi.edu.co.stm.model.Tmio1ServiciosSitio;
import icesi.edu.co.stm.model.Tmio1ServiciosSitioPK;

@RestController
public class ServiceSitioControllerRest implements IServiceSitioController{

	@PostMapping("")
	@Override
	public void save(Tmio1ServiciosSitio entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Tmio1ServiciosSitio entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Tmio1ServiciosSitio entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tmio1ServiciosSitio findById(Tmio1ServiciosSitioPK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tmio1ServiciosSitio> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
