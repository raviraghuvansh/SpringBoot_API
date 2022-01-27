package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResponseNotFound extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String feildName;
	private int feildValue;
	public ResponseNotFound(String resourceName, String feildName, int feildValue) {
		super(String.format("%s not found with %s : '%s'", resourceName,feildName,feildValue));
		this.resourceName = resourceName;
		this.feildName = feildName;
		this.feildValue = feildValue;
	}
	
	public String getResourceName() {
		return resourceName;
	}
	public String getFeildName() {
		return feildName;
	}
	public int getFeildValue() {
		return feildValue;
	}
	
	

}
