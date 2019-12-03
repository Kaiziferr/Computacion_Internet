package icesi.edu.co.stm.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


/**
 * The persistent class for the tmio1_servicios database table.
 * 
 */
@Entity
@Table(name="tmio1_servicios")
@NamedQuery(name="Tmio1Servicio.findAll", query="SELECT t FROM Tmio1Servicio t")
@Data
public class Tmio1Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@EmbeddedId
	private Tmio1ServicioPK id;

	//bi-directional many-to-one association to Tmio1Bus
	@ManyToOne
	@JoinColumn(name="id_bus", insertable=false, updatable=false)
	private Tmio1Bus tmio1Bus;

	//bi-directional many-to-one association to Tmio1Conductore
	@ManyToOne
	@JoinColumn(name="cedula_conductor", insertable=false, updatable=false)
	private Tmio1BusDriver tmio1Conductore;

	//bi-directional many-to-one association to Tmio1Ruta
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="id_ruta", insertable=false, updatable=false)
	private Tmio1Route tmio1Ruta;



}