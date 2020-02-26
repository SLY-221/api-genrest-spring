package fr.amu.genrest.projects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/projects")
@RestController
public class ProjectControllerREST {
	
	@Autowired
	ProjectRepository projectRepository;
	
	
	/**
	 * @description
	 * 		Fonction de récupération de la liste des projects.
	 * @return une liste des projects.
	 */
	@GetMapping("")
	public ResponseEntity<Iterable<Project>> getProjects() {
		Iterable<Project> projects = (Iterable<Project>) projectRepository.findAll();
		return ResponseEntity.ok(projects);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id:[0-9]+}")
	public ResponseEntity<Project> getProjectById(@PathVariable Long id) {	
		Project project = projectRepository.findById(id).get();
		return ResponseEntity.accepted().body(project);
	}
	
	@PostMapping("{id:[0-9]+}")
	public ResponseEntity<Project> mergeProjectById(@PathVariable Long id, Project project) {
		Project projectFinded = projectRepository.findById(id).get();
		projectRepository.save(project);
		return ResponseEntity.accepted().body(projectFinded);	
	}
}
