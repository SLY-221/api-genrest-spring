package fr.amu.genrest.projects;

import java.util.Optional;

import javax.json.Json;
import javax.json.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.amu.genrest.projects.bot.building.Building;

@RequestMapping("api/projects")
@RestController
public class ProjectControllerREST {

	@Autowired
	ProjectRepository projectRepository;

	/**
	 * Fonction de création d'un projet.
	 * 
	 * @param projectID : L'identifiant du projet.
	 * @param building  : Le projet associé.
	 * @return Un nouveau projet.
	 */
	@SuppressWarnings("static-access")
	@PutMapping("{projectID:[0-9]+}/buildings")
	public ResponseEntity<?> createProject(@PathVariable Long projectID, Building building) {
		Project project = projectRepository.findById(projectID).get();

		if (project == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		if (building.getType() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		if (building.getAddress() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		if (building.getAddress().getNumber() == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		if (building.getAddress().getStreet() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		if (building.getAddress().getCity() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		if (building.getAddress().getCountry() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		project.addBuilding(building);
		projectRepository.save(project);
		project = projectRepository.findById(project.getId()).get();

		Optional<Building> newBuilding = project.getBuildings().stream()
				.max((b1, b2) -> Long.compare(b1.getId(), b2.getId()));
		JsonObject jresponse = Json.createObjectBuilder().add("id", newBuilding.get().getId()).build();
		return ResponseEntity.ok(jresponse).status(HttpStatus.CREATED).build();
	}

	/**
	 * Fonction de récupération de la liste des projects.
	 * 
	 * @return une liste des projects.
	 */
	@GetMapping("")
	public ResponseEntity<Iterable<Project>> getProjects() {
		Iterable<Project> projects = projectRepository.findAll();
		return ResponseEntity.accepted().body(projects);
	}

	/**
	 * Fonction de récupération d'un projet via son identifiant.
	 * 
	 * @param id : L'identifiant d'un projet.
	 * @return Le projet indexé par l'identifiant.
	 */
	@GetMapping("/{id:[0-9]+}")
	public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
		Project project = projectRepository.findById(id).get();
		return ResponseEntity.ok(project);
	}

	/**
	 * Fonction de mise à jour de l'entité Project.
	 * 
	 * @param id      : L'identifiant d'un projet.
	 * @param project : L'objet du projet.
	 * @return Le projet mise à jour.
	 */
	@PostMapping("{id:[0-9]+}")
	public ResponseEntity<Project> mergeProjectById(@PathVariable Long id, Project project) {
		Project projectFinded = projectRepository.findById(id).get();
		if (projectFinded == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		if (project.getProjectName() != null) {
			projectFinded.setProjectName(project.getProjectName());
		}
		if (project.getDomaine() != null) {
			projectFinded.setDomaine(project.getDomaine());
		}
		if (project.getCreationDate() != null) {
			projectFinded.setCreationDate(project.getCreationDate());
		}
		if (project.getChangeDate() != null) {
			projectFinded.setChangeDate(project.getChangeDate());
		}
		projectRepository.save(project);
		return ResponseEntity.accepted().body(projectFinded);
	}

	/**
	 * Fonction de supression d'un projet.
	 * 
	 * @param projectID  : L'identifiant du projet.
	 * @param buildingID : L'identifiant du domaine associé.
	 * @return La table de projet mise à jour.
	 */
	@DeleteMapping("{projectID:[0-9]+}/buildings/{building:[0-9]+}")
	public ResponseEntity<Optional<Building>> removeBuilding(@PathVariable Long projectID, Long buildingID) {
		Project project = projectRepository.findById(projectID).get();

		if (project == null) {
			// TODO A revoir
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		Optional<Building> building = project.getBuildings().stream().filter(c -> c.getId().equals(buildingID))
				.findFirst();

		if (!building.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		project.deleteBuildings(building.get());
		projectRepository.save(project);

		return ResponseEntity.ok().build();

	}
}
