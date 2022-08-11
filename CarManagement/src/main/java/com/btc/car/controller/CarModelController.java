package com.btc.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btc.car.model.CarModel;
import com.btc.car.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarModelController 
{
@Autowired
private CarService service;

@PostMapping
public CarModel addCars(@RequestBody CarModel car)
{
	return service.saveCarDetails(car);
}

@GetMapping
public List<CarModel> getAllCarDetails()
{
	return service.getAllCar();
}

@PutMapping
public CarModel updateCarDetails(@RequestBody CarModel car)
{
	return service.updateCarModel(car);
}

@GetMapping("/{car-id}")
public CarModel getCarById(@PathVariable("car-id") long registrationNumber)
{
	return service.findCar(registrationNumber);
}
@DeleteMapping("/{car-id}")
public boolean deleteCarById(@PathVariable("car-id") long registrationNumber)
{
 return service.deteleCar(registrationNumber);
}

@GetMapping("/keyword/{car-name}")
public List<CarModel> getByCarKeyWord(@PathVariable("car-name") String keyword)
{
	return service.findByKeyword(keyword);
}
}