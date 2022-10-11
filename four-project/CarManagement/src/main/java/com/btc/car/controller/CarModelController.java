package com.btc.car.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.btc.car.model.CarModel;
import com.btc.car.service.CarService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/cars")
public class CarModelController 
{
	
	@Autowired
	private CarService service;

	
@ApiResponse( code = 201, message = "car details added successfully")	
@PostMapping("/Car")	
public CarModel addCars(@Valid @RequestBody CarModel car)
{
	return service.saveCarDetails(car);
}

	
@ApiOperation(value = "Add new car", notes = "added new car", response = CarModel.class)
@ApiResponse( code = 201, message = "car details added successfully")
	@PostMapping("/cars")
	public CarModel addCars(@Valid 
			@RequestParam("registrationNumber") long registrationNumber, 
			@RequestParam("carName") String carName,
			@RequestParam("carBrand") String carBrand,
			@RequestParam("carPrice") long carPrice,
			@RequestParam("carColour") String carColour,
			@RequestPart("image") MultipartFile image) throws Exception 
		{
		File file = new File("F:/btc-gitlab/four-project/CarManagement-MVC/src/main/webapp/image/"+registrationNumber+image.getOriginalFilename());
		file.createNewFile(); 
	try (FileOutputStream fileOutput = new FileOutputStream(file)) 
	{
		fileOutput.write(image.getBytes());
	}
	CarModel carModel = new CarModel(registrationNumber, carName, carBrand, carPrice, carColour, file.getName());
			return service.saveCarDetails(carModel);
	}
	

@ApiResponses(value = { @ApiResponse( code = 201, message = "car details displayed sussecfully"),
@ApiResponse( code = 400, message = "Bad Request")})
@ApiOperation(value = "get all car", notes = "All cars are displayed", response = CarModel.class)
@GetMapping

	public List<CarModel> getAllCarDetails() {
		return service.getAllCar();
	}
	
	
	@ApiResponse( code = 201, message = "Updated car details added successfully")
	@ApiOperation(value = "Update the car detail", notes = "car detail updated ", response = CarModel.class)
	@PutMapping
	public CarModel updateCarDetails(@Valid @RequestBody CarModel car)
	{
		return service.updateCarModel(car);
	}
	
	//GET CAR BY ID
	@ApiResponse( code = 201, message = "got the car details sucessfully based on registartion number")
	@GetMapping("/{car-id}")
	@ApiOperation(value = "find car by id", notes = "get the car by id ", response = CarModel.class)
	public CarModel getCarById(@PathVariable("car-id") long registrationNumber) {
		return service.findCar(registrationNumber);
	}

	@ApiResponse( code = 201, message = "Car Details deleted")
	@DeleteMapping("/{car-id}")
	public boolean deleteCarById(@PathVariable("car-id") long registrationNumber) 
	{
		return service.deteleCar(registrationNumber);
	}
	
	
	@ApiOperation(value = "To Search the car based on name or registered number", notes = "searched car  ", response = CarModel.class)
	@GetMapping("/keyword/{car-name}")
	public List<CarModel> getByCarKeyWord(@PathVariable("car-name") String keyword) {
		return service.findByKeyword(keyword);
	}



}
