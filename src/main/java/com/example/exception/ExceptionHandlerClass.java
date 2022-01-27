package com.example.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlerClass {
	@ExceptionHandler(ResponseNotFound.class)
	public ResponseEntity<?> handleResponseNotFoundException(ResponseNotFound exception,WebRequest wr){
		
		ErrorResponse er= new ErrorResponse(new Date(), exception.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity(er,HttpStatus.NOT_FOUND);
		
	}

}
