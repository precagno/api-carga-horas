package com.educativa.cargahoras.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	
	public ResourceNotFoundException(String resourceName,String fieldName,Object fieldValue){
		super(String.format("El recurso %s con %s: %s no fue encontrado.",resourceName,fieldName,fieldValue.toString()));
		this.resourceName=resourceName;
		this.fieldName=fieldName;
		this.fieldValue=fieldValue;
	}

	public String getResourceName() {
		return this.resourceName;
	}
	public String getFieldName() {
		return this.fieldName;
	}
	public Object getFieldValue() {
		return this.fieldValue;
	}
}
