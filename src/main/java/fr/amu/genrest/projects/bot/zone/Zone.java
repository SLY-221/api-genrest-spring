package fr.amu.genrest.projects.bot.zone;

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

import fr.amu.genrest.projects.bot.corridor.Corridor;
import fr.amu.genrest.projects.bot.room.Room;
import lombok.Data;

@Entity
@Table(name = "Zone")
public @Data class Zone implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "type", nullable = false)
	@Size(min = 1, max = 200)
	private String type;

	@Column(name = "name", nullable = false)
	@Size(min = 1, max = 200)
	private String name;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Room> rooms = new HashSet<Room>();

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Corridor> corridors = new HashSet<Corridor>();

	public Zone() {
	}
	
	public Zone(String type, String name) {
		this.type = type;
		this.name = name;
	}
}
