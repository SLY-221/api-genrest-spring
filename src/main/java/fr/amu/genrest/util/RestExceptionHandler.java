package fr.amu.genrest.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(RestApiException.class)
	public ResponseEntity<RestApiError> handleEntityNotFoundException(RestApiException e) {
		return ResponseEntity.status(e.getApiError().getStatus()).body(e.getApiError());
	}
}
