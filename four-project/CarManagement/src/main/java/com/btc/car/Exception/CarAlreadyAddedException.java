package com.btc.car.Exception;

public class CarAlreadyAddedException extends RuntimeException{
	  public CarAlreadyAddedException(String message) {
		  super(message);
	  }
}