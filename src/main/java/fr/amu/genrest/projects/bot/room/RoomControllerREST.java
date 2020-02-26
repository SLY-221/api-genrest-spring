package fr.amu.genrest.projects.bot.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/rooms/")
@RestController
public class RoomControllerREST {
	
	@Autowired
    RoomRepository roomRepository;
	
	@GetMapping("/{id:[0-9]+}")
	public ResponseEntity<Room> getRoomById(@PathVariable Long id) {	
		Room roor = roomRepository.findById(id).get();
	    // TODO : Coding the test of ExceptionErrorMessage if ID isNull.
		return ResponseEntity.ok(roor);
	}
}
