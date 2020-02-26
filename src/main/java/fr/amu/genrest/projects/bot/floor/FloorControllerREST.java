package fr.amu.genrest.projects.bot.floor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/floors")
@RestController
public class FloorControllerREST {
	
	@Autowired
    FloorRepository floorRepository;
	
	@GetMapping("/{id:[0-9]+}")
	public ResponseEntity<Floor> getFloorById(@PathVariable Long id) {	
		Floor floor = floorRepository.findById(id).get();
	    // TODO : Coding the test of ExceptionErrorMessage if ID isNull.
		return ResponseEntity.ok(floor);
	}
}
