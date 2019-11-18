package icesi.edu.co.stm.repository;

import org.springframework.data.repository.CrudRepository;

import icesi.edu.co.stm.model.Tmio1Servicio;
import icesi.edu.co.stm.model.Tmio1ServicioPK;

public interface IServiceRepository extends CrudRepository<Tmio1Servicio, Tmio1ServicioPK>{

}
