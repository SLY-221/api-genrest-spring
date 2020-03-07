package fr.amu.genrest.projects.bot.building;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/buildings")
@RestController
public class BuildingControllerREST {

	@Autowired
	BuildingRepository buildingRepository;

	/**
	 * Fonction de récupération de la liste des buildings.
	 * 
	 * @return une liste des buildings.
	 */
	@GetMapping("")
	public ResponseEntity<Iterable<Building>> getBuildings() {
		Iterable<Building> buildings = (Iterable<Building>) buildingRepository.findAll();
		return ResponseEntity.ok(buildings);
	}

	/**
	 * Fonction de recupération par la méthode GET l'identifiant de Actuator.
	 * 
	 * @param buildingID : L'identifiant du batiment.
	 * @return Les valeurs du batiment indexé.
	 */
	@GetMapping("/{id:[0-9]+}")
	public ResponseEntity<Building> getBuildingById(@PathVariable Long id) {
		Building building = buildingRepository.findById(id).get();
		// TODO : Coding the test of ExceptionErrorMessage if ID isNull.
		return ResponseEntity.ok(building);
	}

	@PostMapping("/{id:[0-9]+}")
	public ResponseEntity<Building> mergeBuildingById(@PathVariable Long id, Building building) {
		Building buildingFinded = buildingRepository.findById(id).get();
		buildingRepository.save(building);
		return ResponseEntity.accepted().body(buildingFinded);
	}
}
