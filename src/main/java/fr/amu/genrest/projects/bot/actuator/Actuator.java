package fr.amu.genrest.projects.bot.actuator;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * La classe Actuator : un JB 
 * @author Tsila
 * @author Bachir
 * @author Fazia
 *
 */

@Entity
@Table(name = "Actuator")
public @Data @AllArgsConstructor class Actuator implements Serializable {
	
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
	
	public Actuator(String name, double latitude, double longitude, String model) {
		super();
		setName(name);
		setLatitude(latitude);
		setLongitude(longitude);
		setModel(model);
	}

	public Actuator() {super();}
}
