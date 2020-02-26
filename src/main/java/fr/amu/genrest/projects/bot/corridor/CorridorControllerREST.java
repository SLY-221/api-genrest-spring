package fr.amu.genrest.projects.bot.corridor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("api/corridors")
@RestController
public class CorridorControllerREST {
	
	@Autowired
	CorridorRepository corridorRepository;

	@GetMapping("/{id:[0-9]+}")
	public ResponseEntity<Corridor> getCorridorById(@PathVariable Long id) {
		Corridor corridor = corridorRepository.findById(id).get();
		// TODO : coding the test of ExceptionErrorMessage if ID isNull.
		return ResponseEntity.ok(corridor);
	}
}
