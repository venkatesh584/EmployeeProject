package com.employee.EmployeeProject.exceptionHandel;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExceptionHandle extends RuntimeException{

	public  ExceptionHandle(String message) {
		super(message);
	}

}
