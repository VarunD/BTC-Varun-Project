package com.btc.car.Exception;

public class CarAlreadyDeletedException extends RuntimeException{
	public CarAlreadyDeletedException(String message) {
		super(message);
	}

}