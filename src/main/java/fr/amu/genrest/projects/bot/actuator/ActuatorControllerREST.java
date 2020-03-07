package fr.amu.genrest.projects.bot.actuator;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.amu.genrest.util.RestApiException;

@RequestMapping("api/actuators")
@RestController
public class ActuatorControllerREST {

	@Autowired
	ActuatorRepository actuatorRepository;

	/**
	 * Fonction de récupération de la liste des actuators
	 * 
	 * @return une liste d'actuators.
	 */
	@GetMapping()
	protected ResponseEntity<Iterable<Actuator>> getAllActuators() {
		Iterable<Actuator> actuators = (Iterable<Actuator>) actuatorRepository.findAll();
		if (actuators == null) {
			throw new RestApiException(HttpStatus.NOT_FOUND, Actuator.class, Map.of());
		}
		return ResponseEntity.ok(actuators);
	}

	/**
	 * Fonction de recupération par la méthode GET l'identifiant de Actuator.
	 * 
	 * @param id 	: L'identifiant de l'Activateur.
	 * @return Les valeurs de l'identifiant de Actuator indexé.
	 */
	@GetMapping("/{id:[0-9]+}")
	protected ResponseEntity<Actuator> getActuatorById(@PathVariable Long actuatorID) {
		Actuator actuator = actuatorRepository.findById(actuatorID).get();
		if (actuator == null) {
			throw new RestApiException(HttpStatus.NOT_FOUND, Actuator.class, Map.of("actuator-id", actuatorID));
		}
		return ResponseEntity.ok(actuator);

	}

	/**
	 * Fonction de mise à jour d'un activateur.
	 * 
	 * @param id       : L'identifiant de l'activateur.
	 * @param actuator : L'objet du constructeur de l'entité actuator.
	 * 
	 * @return l'activateur mise à jour.
	 */
	@PostMapping("{id:[0-9]+}")
	public ResponseEntity<Actuator> MergeActuatorById(@PathVariable Long actuatorID, Actuator actuator) {
		Actuator actuatorFinded = actuatorRepository.findById(actuatorID).get();
		if (actuatorFinded == null) {
			throw new RestApiException(HttpStatus.NOT_FOUND, Actuator.class, Map.of("actuator-id", actuatorID));
		}
		if (actuator.getName() != null) {
			actuatorFinded.setName(actuator.getName());
		}

		if (actuator.getLatitude() != 0) {
			actuatorFinded.setLatitude(actuator.getLatitude());
		}

		if (actuator.getLongitude() != 0) {
			actuatorFinded.setLongitude(actuator.getLongitude());
		}

		if (actuator.getModel() != null) {
			actuatorFinded.setModel(actuator.getModel());
		}
		
		// TODO : Verifier si le nom est déja existant.
		
		actuatorRepository.save(actuator);
		return ResponseEntity.ok(actuatorFinded);
	}
}
