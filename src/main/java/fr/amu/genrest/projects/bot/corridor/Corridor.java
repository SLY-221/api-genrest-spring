package fr.amu.genrest.projects.bot.corridor;

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

/**
 * 
 * @author Tsila, Fazia, Bachir
 *
 */

@Entity
@Table(name = "Corridor")
public @Data class Corridor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column(name = "name", nullable = false)
	@Size(min = 2, max = 200)
	private String name;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE }, orphanRemoval = true)
	private Set<Sensor> sensors = new HashSet<Sensor>();

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE }, orphanRemoval = true)
	private Set<Actuator> actuators = new HashSet<Actuator>();

	public Corridor() {super();}

	public Corridor(@Size(min = 2, max = 200) String name) {
		super();
		setName(name);
	}
	
	
}
