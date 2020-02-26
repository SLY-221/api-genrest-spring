package fr.amu.genrest.projects.bot.building;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import fr.amu.genrest.projects.bot.floor.Floor;
import lombok.Data;

/**
 * 
 * @author Fazia, Bachir, ...
 * @see Building
 */

@Table(name = "building")
@Entity
public @Data class Building implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Embedded
	private Address address;
	
	@Basic(optional = false) 
	@Column(nullable = false,length=200) 
	@Size(min = 1, max = 200) 
	private String type; 

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.REMOVE, CascadeType.MERGE,CascadeType.PERSIST }, orphanRemoval=true)
	private Set<Floor> floors = new HashSet<>();

	public Building() {super();}

	public Building(String type,Address address) {
		super();
		setType(type);
		setAddress(address);
	}
	
}
