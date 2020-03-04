package fr.amu.genrest.util;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import lombok.Getter;

public class RestApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private @Getter RestApiError apiError;

	public <T> RestApiException(HttpStatus status, Class<T> clazz, Map<String, Object> searchParams) {
		super();

		String message = generateMessage(clazz.getSimpleName(), searchParams);
		apiError = new RestApiError(message, status);
	}

	private String generateMessage(String entity, Map<String, Object> searchParams) {
		return StringUtils.capitalize(entity) + " was not found for parameters " + searchParams;
	}
}
