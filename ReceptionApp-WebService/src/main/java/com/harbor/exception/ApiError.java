package com.harbor.exception;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.http.HttpStatus;

public class ApiError {

	private HttpStatus status;
    private String msg;
	private List<Object> errors;
	
	
	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Object> getErrors() {
		return errors;
	}

	public void setErrors(List<Object> errors) {
		this.errors = errors;
	}


	
	public ApiError(HttpStatus status, String msg, List<Object> errors) {
		super();
		this.status = status;
		this.msg = msg;
		this.errors = errors;
	}
	
	public ApiError(HttpStatus status, String msg, String error) {
		super();
		this.status = status;
		this.msg = msg;
		errors=Arrays.asList(error);
		
	}
}
