package com.btc.car.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.btc.car.Exception.CarAlreadyAddedException;
import com.btc.car.Exception.CarAlreadyDeletedException;
import com.btc.car.Exception.CarNotPresentException;

	@RestControllerAdvice
	public class ErrorException {
		
		@ResponseStatus(code = HttpStatus.CONFLICT)
		@ExceptionHandler(CarAlreadyAddedException.class)
		public String handleCarAlreadyAddedException(Exception ex) {
			return ex.getMessage();
		}
		@ResponseStatus(code = HttpStatus.NOT_EXTENDED)
		@ExceptionHandler(CarNotPresentException.class)
		public String handleMovieNotFoundException(Exception ex) {
			return ex.getMessage();
		}
		@ResponseStatus(code = HttpStatus.ACCEPTED)
		@ExceptionHandler(CarAlreadyDeletedException.class)
		public String CarAlreadyDeletedException(Exception ex) {
			return ex.getMessage();
		}

	}


