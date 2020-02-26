package fr.amu.genrest.util;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Bachir, Fazia
 *
 */

public @Data @AllArgsConstructor class RestApiError {
	private int code;
	private HttpStatus status;
	private String message;
}
