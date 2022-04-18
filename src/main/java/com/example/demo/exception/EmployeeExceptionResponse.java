package com.example.demo.exception;

import java.util.Date;

public class EmployeeExceptionResponse {
	private String errorMessage,description;
	private Date datetime;
	public EmployeeExceptionResponse(String errorMessage, String description, Date datetime) {
		super();
		this.errorMessage = errorMessage;
		this.description = description;
		this.datetime = datetime;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
}
