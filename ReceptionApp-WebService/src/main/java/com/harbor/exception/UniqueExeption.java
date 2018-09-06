package com.harbor.exception;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@ControllerAdvice
public class UniqueExeption extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {ConstraintViolationException.class, SQLException.class, Exception.class})
	public ResponseEntity<Object> handleConstrationViolation(ConstraintViolationException ce, WebRequest wr) {
		String error = null;
		List<String> errors = new ArrayList<>();
		for (ConstraintViolation<?> cv : ce.getConstraintViolations()) {
			error = errors.add(cv.getRootBeanClass().getName()) + "  " + cv.getPropertyPath() + ":" + cv.getMessage();

		}
		ApiError apierror = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ce.getLocalizedMessage(), error);

		return new ResponseEntity<Object>(apierror, new HttpHeaders(), apierror.getStatus());
	}
}