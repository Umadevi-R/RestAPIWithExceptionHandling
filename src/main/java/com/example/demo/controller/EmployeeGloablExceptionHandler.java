package com.example.demo.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.exception.EmployeeExceptionResponse;
import com.example.demo.exception.EmployeeNotFound;

@RestController
@ControllerAdvice
public class EmployeeGloablExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req){
		EmployeeExceptionResponse resp = new EmployeeExceptionResponse(ex.getMessage(),
				req.getDescription(false),new Date());
		return new ResponseEntity<Object>(resp,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(EmployeeNotFound.class)
	public ResponseEntity<Object> handleEmployeeNotFoundException(Exception ex, WebRequest req){
		EmployeeExceptionResponse resp = new EmployeeExceptionResponse(ex.getMessage(),
				req.getDescription(false),new Date());
		return new ResponseEntity<Object>(resp,HttpStatus.NOT_FOUND);
	}

}
