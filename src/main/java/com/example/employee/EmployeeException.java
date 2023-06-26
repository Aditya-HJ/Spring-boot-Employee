package com.example.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeException {
	@ExceptionHandler(EmpIdNotFoundException.class)
	public ResponseEntity<Object> idCheck() {
		return new ResponseEntity<>("Employee id not found",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EmpNameException.class)
	public ResponseEntity<Object> nameCheck() {
		return new ResponseEntity<>("Employee name not found",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(SalaryNotFoundException.class)
	public ResponseEntity<Object> salaryCheck() {
		return new ResponseEntity<>("Employee salary not found",HttpStatus.NOT_FOUND);
	}
}