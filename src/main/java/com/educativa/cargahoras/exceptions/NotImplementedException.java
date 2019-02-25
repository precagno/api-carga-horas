package com.educativa.cargahoras.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_IMPLEMENTED)
public class NotImplementedException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String resourceName;

	public NotImplementedException(String resourceName){
		super(String.format("El recurso %s todavía no fue implementado",resourceName));
		this.resourceName=resourceName;
	}

	public String getResourceName() {
		return this.resourceName;
	}
}
