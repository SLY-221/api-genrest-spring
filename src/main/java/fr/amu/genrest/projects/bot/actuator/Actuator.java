package fr.amu.genrest.projects.bot.actuator;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * JavaBean de la classe {@link Actuator} ayant tous les attributs communs que
 * peuvent partagé par tous les fonctionnalités du même domaine.
 * 
 * @author Tsila
 * @author Bachir
 * @author Fazia
 *
 *         ** NB : Pour plus de facilté dans la déclarations des attributs du
 *         JB, nous avons utilisé Lombok. **
 */

@Entity
@Table(name = "Actuator")
public @Data class Actuator implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", nullable = false)
	@Size(min = 1, max = 200)
	private String name;

	@Column(name = "latitude", nullable = false)
	private double latitude;

	@Column(name = "longitude", nullable = false)
	private double longitude;

	@Column(name = "model", nullable = false)
	@Size(min = 1, max = 200)
	private String model;

	public Actuator(Long id, String name, double latitude, double longitude, String model) {
		super();
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.model = model;
	}
	
	
}
