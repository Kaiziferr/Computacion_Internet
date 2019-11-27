package icesi.edu.co.stm.controller;

import org.springframework.stereotype.Controller;

import icesi.edu.co.stm.delegate.IServicioSitioDelegate;
import icesi.edu.co.stm.model.Tmio1ServiciosSitio;
import icesi.edu.co.stm.model.Tmio1ServiciosSitioPK;

@Controller
public class ServiceSitioController implements IServicioSitioController{

	private IServicioSitioDelegate iServicioSitioDelegate;
	@Override
	public Iterable<Tmio1ServiciosSitio> getALL() {
		// TODO Auto-generated method stub
		return iServicioSitioDelegate.findAll();
	}

	@Override
	public Tmio1ServiciosSitio get(Tmio1ServiciosSitioPK id) {
		// TODO Auto-generated method stub
		return iServicioSitioDelegate.findById(id);
	}

	@Override
	public void add(Tmio1ServiciosSitio entity) {
		// TODO Auto-generated method stub
		iServicioSitioDelegate.save(entity);
	}

	@Override
	public void update(Tmio1ServiciosSitio entity) {
		// TODO Auto-generated method stub
		iServicioSitioDelegate.update(entity);
	}

	@Override
	public void delete(Tmio1ServiciosSitio entity) {
		// TODO Auto-generated method stub
		iServicioSitioDelegate.delete(entity);
	}

}
