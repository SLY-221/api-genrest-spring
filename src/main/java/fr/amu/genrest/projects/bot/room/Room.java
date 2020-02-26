package fr.amu.genrest.projects.bot.room;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import fr.amu.genrest.projects.bot.actuator.Actuator;
import fr.amu.genrest.projects.bot.sensor.Sensor;
import lombok.Data;

@Entity
@Table(name = "Room")
public @Data class Room implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", nullable = false)
	@Size(min = 1, max = 200)
	private String name;

	@Column(name = "type", nullable = false)
	@Size(min = 1, max = 200)
	private String type;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, orphanRemoval = true)
	private Set<Sensor> sensors = new HashSet<Sensor>();

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, orphanRemoval = true)
	private Set<Actuator> actuators = new HashSet<Actuator>();

	public Room() {
		super();
	}

	public Room(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

}
