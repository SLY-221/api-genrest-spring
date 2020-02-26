package fr.amu.genrest.projects.bot.building;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/buildings")
@RestController
public class BuildingControllerREST {

	@Autowired
	BuildingRepository buildingRepository;
	
	@GetMapping("/{id:[0-9]+}")
	public ResponseEntity<Building> getBuildingById(@PathVariable Long id) {	
		Building building = buildingRepository.findById(id).get();
	    // TODO : Coding the test of ExceptionErrorMessage if ID isNull.
		return ResponseEntity.ok(building);
	}
}
