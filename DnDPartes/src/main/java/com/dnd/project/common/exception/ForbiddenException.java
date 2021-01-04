package com.dnd.project.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException {

	/**
	* 
	*/
	private static final long serialVersionUID = 8226633705786634947L;

	public ForbiddenException(String message) {
		super(message);
	}
}
