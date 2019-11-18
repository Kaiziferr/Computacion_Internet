package icesi.edu.co.stm.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Tmio1User {
	
	/**
	 * Id que identifica el usuario
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	/**
	 * apellidos del usuario
	 */
	@NotBlank
	@NonNull
	private String lastname;
	
	/**
	 * Password de la cuenta del usuario
	 */
	@NotBlank
	@NonNull
	private String password;
	
	/**
	 * Nombre del usuario
	 */
	@NotBlank
	@NonNull
	private String name;
	
	
	@NotBlank
	@NonNull
	private String username;
	
	/**
	 * Typo de rol
	 */
	private UserType type;


	
}
