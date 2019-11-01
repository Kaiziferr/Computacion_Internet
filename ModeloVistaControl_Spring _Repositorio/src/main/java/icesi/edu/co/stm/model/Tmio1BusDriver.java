package icesi.edu.co.stm.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


/**
 * The persistent class for the tmio1_conductores database table.
 * 
 */

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="tmio1_conductores")
@NamedQuery(name="Tmio1Conductore.findAll", query="SELECT t FROM Tmio1BusDriver t")

public class Tmio1BusDriver implements Serializable {
	private static final long serialVersionUID = 1L;

	//@Id
	@Id
	private String cedula;

	@NotBlank
	@NonNull
	private String apellido;
	
	//@Temporal(TemporalType.DATE)
	@Column(name="fecha_contratacion")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaContratacion;
	
	//@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	@NotBlank
	@NonNull
	private String nombre;

	/**
	
	//bi-directional many-to-one association to Tmio1Servicio
	@OneToMany(mappedBy="tmio1Conductore")
	private List<Tmio1Servicio> tmio1Servicios;

	//bi-directional many-to-one association to Tmio1ServiciosSitio
	@OneToMany(mappedBy="tmio1Conductore")
	private List<Tmio1ServiciosSitio> tmio1ServiciosSitios;

	public Tmio1Servicio addTmio1Servicio(Tmio1Servicio tmio1Servicio) {
		getTmio1Servicios().add(tmio1Servicio);
		tmio1Servicio.setTmio1Conductore(this);
		return tmio1Servicio;
	}

	public Tmio1Servicio removeTmio1Servicio(Tmio1Servicio tmio1Servicio) {
		getTmio1Servicios().remove(tmio1Servicio);
		tmio1Servicio.setTmio1Conductore(null);

		return tmio1Servicio;
	}
	
	public Tmio1ServiciosSitio addTmio1ServiciosSitio(Tmio1ServiciosSitio tmio1ServiciosSitio) {
		getTmio1ServiciosSitios().add(tmio1ServiciosSitio);
		tmio1ServiciosSitio.setTmio1Conductore(this);

		return tmio1ServiciosSitio;
	}

	public Tmio1ServiciosSitio removeTmio1ServiciosSitio(Tmio1ServiciosSitio tmio1ServiciosSitio) {
		getTmio1ServiciosSitios().remove(tmio1ServiciosSitio);
		tmio1ServiciosSitio.setTmio1Conductore(null);

		return tmio1ServiciosSitio;
	}
	
*/
}