package com.mockpage.schoolwebapp.schoolpage.home.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AdminNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AdminNotFoundException() {
		super();
	}
	
	public AdminNotFoundException(String message) {
		super(message);
	}

}
