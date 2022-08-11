package com.btc.car.service;

import java.util.List;

import com.btc.car.model.CarModel;

public interface CarService
{
public CarModel saveCarDetails(CarModel car);
 
public CarModel findCar(long registrationNumber);

public CarModel updateCarModel(CarModel car);

public boolean deteleCar(long registrationNumber);

public List<CarModel> getAllCar();

public List<CarModel> findByKeyword(String keyword);
}
