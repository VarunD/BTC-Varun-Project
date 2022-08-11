package com.btc.car.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btc.car.model.CarModel;
import com.btc.car.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService
{
	@Autowired
	private CarRepository carRepo;
	
//	public CarServiceImpl(CarRepository carRepo) {
//		super();
//		this.carRepo = carRepo;
//	}

	@Override
	public CarModel saveCarDetails(CarModel car) {
		return carRepo.save(car);
	}

	@Override
	public CarModel findCar(long registrationNumber) {
		Optional<CarModel> carModel= carRepo.findById(registrationNumber);
		return carModel.get();//The get method is used to get the date or to fetch the data...
	}

	@Override
	public CarModel updateCarModel(CarModel car) {
		return carRepo.save(car);
	}

	@Override
	public boolean deteleCar(long registrationNumber) {
		carRepo.deleteById(registrationNumber);
		 return !carRepo.existsById(registrationNumber);
	}

	@Override
	public List<CarModel> getAllCar() {
		//return carRepo.findAll();
		return carRepo.findAllByOrderBylastModifiedDesc();
	}
	
	@Override
	public List<CarModel> findByKeyword(String keyword) {
		return carRepo.findByKeyword(keyword);
	}

	
}
	
	
	
	
	
	
	
	
	

//}
