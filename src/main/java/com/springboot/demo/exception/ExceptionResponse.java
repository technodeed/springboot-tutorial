package com.springboot.demo.exception;

import java.util.Date;

public class ExceptionResponse {
	
	private String statusCode;
	private String message;
	private Date date;
	private String description;
	
	public ExceptionResponse(String statusCode, String message, Date date, String description) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.date = date;
		this.description = description;
	}

	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

}
