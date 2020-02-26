package fr.amu.genrest.projects.bot.sensor;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "Sensor")
public @Data class Sensor implements Serializable {

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

	@Column(name = "quantityKind", nullable = false)
	@Size(min = 1, max = 200)
	private String quantityKind;

	@Column(name = "unitData", nullable = false)
	@Size(min = 1, max = 200)
	private String unitData;

	public Sensor() {
		super();
	}

	/**
	 * 
	 * @param name
	 * @param latitude
	 * @param longitude
	 * @param model
	 * @param unitData
	 * @param quantityKind
	 */
	public Sensor(String name, double latitude, double longitude, String model, String unitData, String quantityKind) {
		super();
		setName(name);
		setLatitude(latitude);
		setLongitude(longitude);
		setModel(model);
		setUnitData(unitData);
		setQuantityKind(quantityKind);
	}
}
