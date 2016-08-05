package com.vbkongari.dramaflix.exception;

public class DramaAlreadyExistsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DramaAlreadyExistsException(String message) {
		super(message);
	}
	
	public DramaAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
