package fr.amu.genrest.util;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.apache.commons.lang3.StringUtils;

import lombok.Getter;

public class RestApiException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private @Getter RestApiError apiError;
	
	public <T> RestApiException(HttpStatus status, Class<T> clazz, Map<String, String> searchParams) {
		super("");
		
		String message = generateMessage(clazz.getSimpleName(), searchParams);
		int code = status.value();
		apiError = new RestApiError(code, status, message);
	}
	
	private String generateMessage(String entity, Map<String, String> searchParams) {
		return StringUtils.capitalize(entity) +" was not found for parameters "+ searchParams;
	}
}
