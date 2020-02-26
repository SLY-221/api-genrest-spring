package fr.amu.genrest.projects.bot.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("api/actuators")
@RestController
public class ActuatorControllerREST {
	
	@Autowired
	ActuatorRepository actuatorRepository; 
	
	/**
	 * @description
	 * 		Fonction de récupération de la liste des actuators 
	 * @return une liste d'actuators.
	 */
	@GetMapping("")
	public ResponseEntity<Iterable<Actuator>> getAllActuators() {
		Iterable<Actuator> actuators = (Iterable<Actuator>) actuatorRepository.findAll();
		// TODO : ErrorException to do ...
		return ResponseEntity.ok(actuators);
	}
	
	/**
	 * @param id
	 * @description
	 * 		Fonction de recupération par la méthode GET l'identifiant de Actuator.
	 * @return Les valeurs de l'identifiant de Actuator indexé.
	 */
	@GetMapping("/{id:[0-9]+}")
	private ResponseEntity<Actuator> getActuatorById(@PathVariable Long id) {
		Actuator actuator = actuatorRepository.findById(id).get();
		// TODO : ErrorException to do ...
		return ResponseEntity.ok(actuator);
		
	}
	
	/**
	 * @param id
	 * @param actuator
	 * @description 
	 * 		Fonction de mise à jour 
	 * @return les valeurs mises à jour 
	 */
	@PostMapping("{id:[0-9]+}")
	public ResponseEntity<Actuator> MergeActuatorById(@PathVariable Long id, Actuator actuator) {
		Actuator actuatorFinded = actuatorRepository.findById(id).get();
		actuatorRepository.updateById(actuator);
		return ResponseEntity.ok(actuatorFinded);
	}
}
