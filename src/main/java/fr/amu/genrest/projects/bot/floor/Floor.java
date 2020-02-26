package fr.amu.genrest.projects.bot.floor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.amu.genrest.projects.bot.corridor.Corridor;
import fr.amu.genrest.projects.bot.zone.Zone;
import lombok.Data;

@Table(name = "Floor")
@Entity
public @Data class Floor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Basic(optional = false)
	@Column(nullable = false)
	private int floorNumber;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.REMOVE, CascadeType.MERGE,
			CascadeType.PERSIST }, orphanRemoval = true)
	private Set<Zone> zones = new HashSet<Zone>();

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.REMOVE, CascadeType.MERGE,
			CascadeType.PERSIST }, orphanRemoval = true)
	private Set<Corridor> corridors = new HashSet<Corridor>();

	public Floor() {
	}

	public Floor(int floorNumber) {
		setFloorNumber(floorNumber);
	}

}
