package fr.amu.genrest.projects;

import java.io.Serializable;
import java.time.LocalDateTime;
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
import javax.validation.constraints.Size;

import fr.amu.genrest.projects.bot.building.Building;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * JavaBean de la classe Project ayant tous les attributs communs que peuvent
 * partagé par tous les projets.
 * 
 * NB : Pour plus de facilté dans la déclarations des attributs du JB, nous
 * avons utilisé Lombok.
 * 
 * @author Youcef
 * @author Mohamed
 * @author Fazia
 * @author Bachir
 * 
 */

@Entity
@Table(name = "Project")
@Data
@AllArgsConstructor
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Basic(optional = false)
	@Column(name = "projectName", nullable = false, length = 200)
	@Size(min = 1, max = 200)
	private String projectName;

	@Basic(optional = false)
	@Column(name = "domaine", nullable = false, length = 200)
	@Size(min = 1, max = 200)
	private String domaine;

	@Basic(optional = false)
	@Column(name = "creation_Date", nullable = false)
	private LocalDateTime creationDate;

	@Basic(optional = true)
	@Column(name = "change_Date", nullable = true)
	private LocalDateTime changeDate;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.REMOVE, CascadeType.MERGE,
			CascadeType.PERSIST }, orphanRemoval = true)
	private Set<Building> buildings = new HashSet<>();

	// TODO: Ne pas oublier les autres projets au cas où, ils seront créer.
	
	
	/**
	 * Fonction de suppression d'un projet.
	 * 
	 * @param building - Le projet associé.
	 */
	public void deleteBuildings(Building building) {
		if (this.buildings.size() == 1 && this.buildings.removeIf(p -> p.getId().equals(building.getId()))) {
			this.buildings.clear();
		}
	}

	/**
	 * Fonction de création d'un projet.
	 * 
	 * @param building - Un projet créé.
	 */
	public void addBuilding(Building building) {
		this.buildings.add(building);
	}
}
