package fr.amu.genrest.util;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Bachir
 * @author Fazia
 * 
 *
 */

public @Data @AllArgsConstructor class RestApiError {
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
//	private LocalDateTime timestamp;
	private String message;
	private HttpStatus status;
	
}
