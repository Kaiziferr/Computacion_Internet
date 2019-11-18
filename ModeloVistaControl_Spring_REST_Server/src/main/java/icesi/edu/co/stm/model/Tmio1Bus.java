package icesi.edu.co.stm.model;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import icesi.edu.co.stm.validation.Step1;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="tmio1_buses")
@NamedQuery(name="Tmio1Bus.findAll", query="SELECT t FROM Tmio1Bus t")
@Data
public class Tmio1Bus implements Serializable {
	private static final long serialVersionUID = 1L;	
	
	@Id
	@SequenceGenerator(name="TMIO1_BUSES_ID_GENERATOR", sequenceName="TMIO1_BUSES_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TMIO1_BUSES_ID_GENERATOR")
	private Integer id;
	
	@NotNull(groups = {Step1.class})
	private BigDecimal capacidad;
	
	@NotBlank(groups = {Step1.class})
	private String marca;
	
	@NotNull(groups = {Step1.class})
	private BigDecimal modelo;
	
	@NotBlank(groups = {Step1.class})
	private String placa;

	@NotBlank(groups = {Step1.class})
	private String tipo;

	///bi-directional many-to-one association to Tmio1Servicio
	@OneToMany(mappedBy="tmio1Bus")
	private List<Tmio1Servicio> tmio1Servicios;

	//bi-directional many-to-one association to Tmio1ServiciosSitio
	@OneToMany(mappedBy="tmio1Bus")
	private List<Tmio1ServiciosSitio> tmio1ServiciosSitios;


	public Tmio1Servicio addTmio1Servicio(Tmio1Servicio tmio1Servicio) {
		getTmio1Servicios().add(tmio1Servicio);
		tmio1Servicio.setTmio1Bus(this);
		return tmio1Servicio;
	}

	public Tmio1Servicio removeTmio1Servicio(Tmio1Servicio tmio1Servicio) {
		getTmio1Servicios().remove(tmio1Servicio);
		tmio1Servicio.setTmio1Bus(null);

		return tmio1Servicio;
	}


	public Tmio1ServiciosSitio addTmio1ServiciosSitio(Tmio1ServiciosSitio tmio1ServiciosSitio) {
		getTmio1ServiciosSitios().add(tmio1ServiciosSitio);
		tmio1ServiciosSitio.setTmio1Bus(this);

		return tmio1ServiciosSitio;
	}

	public Tmio1ServiciosSitio removeTmio1ServiciosSitio(Tmio1ServiciosSitio tmio1ServiciosSitio) {
		getTmio1ServiciosSitios().remove(tmio1ServiciosSitio);
		tmio1ServiciosSitio.setTmio1Bus(null);

		return tmio1ServiciosSitio;

	}
 
	
}