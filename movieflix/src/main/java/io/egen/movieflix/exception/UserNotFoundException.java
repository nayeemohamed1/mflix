package io.egen.movieflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message){
		super(message);
	}
	
	public UserNotFoundException(String message,Throwable cause)
	{
		super(message,cause);
	}
}
