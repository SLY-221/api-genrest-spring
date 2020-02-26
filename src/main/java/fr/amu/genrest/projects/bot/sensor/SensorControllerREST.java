package fr.amu.genrest.projects.bot.sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/sensors")
@RestController
public class SensorControllerREST {
	
	@Autowired
    SensorRepository sensorRepository;
	
	@GetMapping("/{id:[0-9]+}")
	public ResponseEntity<Sensor> getFloorById(@PathVariable Long id) {	
		Sensor sensor = sensorRepository.findById(id).get();
	    // TODO : Coding the test of ExceptionErrorMessage if ID isNull.
		return ResponseEntity.ok(sensor);
	}
}
