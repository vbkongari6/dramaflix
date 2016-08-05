package com.vbkongari.dramaflix.exception;

public class DramaNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DramaNotFoundException(String message) {
		super(message);
	}
	
	public DramaNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
