package com.btc.car.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.btc.car.model.CarModel;

@Service
public class CarManagementService 
{	
	private String apiUrl = "http://localhost:1010/cars";
	@Autowired
	private RestTemplate rt;
	//GET CAR BY ID
	public CarModel getCarDetailsById(long registrationNumber)
	{
		CarModel cargetById = rt.getForObject(apiUrl+"/"+registrationNumber, CarModel.class);
							//specifies the type of the which type of the class 
		return cargetById;
	}
	
	//POST
	public CarModel addCarDetails(CarModel carInfo)
	{
		CarModel savedCar = rt.postForObject(apiUrl, carInfo, CarModel.class);
		return savedCar;
	}
	
	//Delete the car by id
	public void deleteCarById(long registrationNumber)
	{
		rt.delete(apiUrl+"/"+registrationNumber);
	}
	
	//update
	public CarModel updataCarDetails(CarModel carInfo)
	{
		HttpEntity<CarModel> entity = new HttpEntity<CarModel>(carInfo);
		CarModel savedCar = rt.exchange(apiUrl, HttpMethod.PUT, entity, CarModel.class).getBody();
		return savedCar;	
	}
	
	//GET ALL CARS
	public List<CarModel> getAllCarList() {
		CarModel[] carList = rt.getForObject(apiUrl, CarModel[].class);
		return Arrays.asList(carList);
	}
	
	public List<CarModel> getCarByKeyword(String keyword)
	{
		CarModel[] carList = rt.getForObject(apiUrl+"/keyword/"+keyword, CarModel[].class);
		return Arrays.asList(carList);
	}
	}
