package com.vbkongari.dramaflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class DramaNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DramaNotFoundException(String message) {
		super(message);
	}
	
	public DramaNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
