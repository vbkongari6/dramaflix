package com.vbkongari.dramaflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class DramaAlreadyExistsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DramaAlreadyExistsException(String message) {
		super(message);
	}
	
	public DramaAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
