package com.example.employee.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorDetails handleResourceNotFoundException(ResourceNotFoundException ex) {
		return new ErrorDetails(
				LocalDateTime.now(),
				ex.getMessage(),
				HttpStatus.NOT_FOUND.value());
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorDetails handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
		return new ErrorDetails (
				LocalDateTime.now(),
				ex.getMessage(),
				HttpStatus.NOT_FOUND.value());
	}
	
	@ExceptionHandler(ResultNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	
	public ErrorDetails handleResultNotFoundException(ResultNotFoundException ex) {
		
		return new ErrorDetails(
				LocalDateTime.now(),
				ex.getMessage(),
				HttpStatus.NOT_FOUND.value());
	}
	
	//Generic error
	 
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handle(Exception ex){
		return ResponseEntity.status(500).body("Error occured");
	}
	
	

}
