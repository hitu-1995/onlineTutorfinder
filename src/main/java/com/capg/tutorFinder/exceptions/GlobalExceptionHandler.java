package com.capg.tutorFinder.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(AdminAlreadyPresentException.class)
	public ResponseEntity<String> duplicateAdmin() {
		
		return new ResponseEntity<String>("Admin Already Created ",HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(TutorAlreadyPresentException.class)
	public ResponseEntity<String> duplicateTutor() {
	
		return new ResponseEntity<String>("Tutor Already Created ",HttpStatus.ALREADY_REPORTED);
	}
	@ExceptionHandler(ParentAlreadyPresentException.class)
	public ResponseEntity<String> duplicateParent() {
	
		return new ResponseEntity<String>("Parent Already Created ",HttpStatus.ALREADY_REPORTED);
	}
	   @Override
	    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
	    		HttpHeaders headers, HttpStatus status, WebRequest request) {
	    
	    	return new ResponseEntity<Object>("Method Not Supported ",HttpStatus.METHOD_NOT_ALLOWED);
	    }
}
