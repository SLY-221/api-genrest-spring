package fr.amu.genrest.projects.bot.zone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/Zones")
@RestController
public class ZoneControllerREST {
	
	@Autowired
    ZoneRepository zoneRepository;
	
	@GetMapping("/{id:[0-9]+}")
	public ResponseEntity<Zone> getFloorById(@PathVariable Long id) {	
		Zone zone = zoneRepository.findById(id).get();
	    // TODO : Coding the test of ExceptionErrorMessage if ID isNull.
		return ResponseEntity.ok(zone);
	}
}
