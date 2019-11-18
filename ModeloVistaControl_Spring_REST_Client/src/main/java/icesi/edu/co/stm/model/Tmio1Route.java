package icesi.edu.co.stm.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tmio1_rutas database table.
 * 
 */
@Entity
@Table(name="tmio1_rutas")
@NamedQuery(name="Tmio1Ruta.findAll", query="SELECT t FROM Tmio1Route t")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Tmio1Route implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TMIO1_RUTAS_ID_GENERATOR", sequenceName="TMIO1_RUTAS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TMIO1_RUTAS_ID_GENERATOR")
	private Integer id;

	@NotBlank
	@NonNull
	private String activa;

	@NotBlank
	@NonNull
	private String descripcion;

	
	@NonNull
	//@Column(name="dia_fin")
	private BigDecimal diaFin;

	@NonNull
	//@Column(name="dia_inicio")
	private BigDecimal diaInicio;

	@NonNull
	//@Column(name="hora_fin")
	private BigDecimal horaFin;

	
	@NonNull
	//@Column(name="hora_inicio")
	private BigDecimal horaInicio;

	@NotBlank
	@NonNull
	private String numero;

	/**
	 * 
	 
	//bi-directional many-to-one association to Tmio1Servicio
	@OneToMany(mappedBy="tmio1Ruta")
	private List<Tmio1Servicio> tmio1Servicios;

	//bi-directional many-to-one association to Tmio1ServiciosSitio
	@OneToMany(mappedBy="tmio1Ruta")
	private List<Tmio1ServiciosSitio> tmio1ServiciosSitios;

	//bi-directional many-to-one association to Tmio1SitiosRuta
	@OneToMany(mappedBy="tmio1Ruta1")
	private List<Tmio1SitiosRuta> tmio1SitiosRutas1;

	//bi-directional many-to-one association to Tmio1SitiosRuta
	@OneToMany(mappedBy="tmio1Ruta2")
	private List<Tmio1SitiosRuta> tmio1SitiosRutas2;

	public Tmio1Servicio addTmio1Servicio(Tmio1Servicio tmio1Servicio) {
		getTmio1Servicios().add(tmio1Servicio);
		tmio1Servicio.setTmio1Ruta(this);

		return tmio1Servicio;
	}

	public Tmio1Servicio removeTmio1Servicio(Tmio1Servicio tmio1Servicio) {
		getTmio1Servicios().remove(tmio1Servicio);
		tmio1Servicio.setTmio1Ruta(null);

		return tmio1Servicio;
	}

	
	public Tmio1ServiciosSitio addTmio1ServiciosSitio(Tmio1ServiciosSitio tmio1ServiciosSitio) {
		getTmio1ServiciosSitios().add(tmio1ServiciosSitio);
		tmio1ServiciosSitio.setTmio1Ruta(this);

		return tmio1ServiciosSitio;
	}

	public Tmio1ServiciosSitio removeTmio1ServiciosSitio(Tmio1ServiciosSitio tmio1ServiciosSitio) {
		getTmio1ServiciosSitios().remove(tmio1ServiciosSitio);
		tmio1ServiciosSitio.setTmio1Ruta(null);

		return tmio1ServiciosSitio;
	}


	public Tmio1SitiosRuta addTmio1SitiosRutas1(Tmio1SitiosRuta tmio1SitiosRutas1) {
		getTmio1SitiosRutas1().add(tmio1SitiosRutas1);
		tmio1SitiosRutas1.setTmio1Ruta1(this);

		return tmio1SitiosRutas1;
	}

	public Tmio1SitiosRuta removeTmio1SitiosRutas1(Tmio1SitiosRuta tmio1SitiosRutas1) {
		getTmio1SitiosRutas1().remove(tmio1SitiosRutas1);
		tmio1SitiosRutas1.setTmio1Ruta1(null);

		return tmio1SitiosRutas1;
	}

	public Tmio1SitiosRuta addTmio1SitiosRutas2(Tmio1SitiosRuta tmio1SitiosRutas2) {
		getTmio1SitiosRutas2().add(tmio1SitiosRutas2);
		tmio1SitiosRutas2.setTmio1Ruta2(this);

		return tmio1SitiosRutas2;
	}

	public Tmio1SitiosRuta removeTmio1SitiosRutas2(Tmio1SitiosRuta tmio1SitiosRutas2) {
		getTmio1SitiosRutas2().remove(tmio1SitiosRutas2);
		tmio1SitiosRutas2.setTmio1Ruta2(null);

		return tmio1SitiosRutas2;
	}
*/
}