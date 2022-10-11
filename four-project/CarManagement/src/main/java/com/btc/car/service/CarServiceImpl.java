package com.btc.car.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btc.car.Exception.CarAlreadyAddedException;
import com.btc.car.Exception.CarAlreadyDeletedException;
import com.btc.car.Exception.CarNotPresentException;
import com.btc.car.model.CarModel;
import com.btc.car.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {
	@Autowired
	private CarRepository carRepo;

//	public CarServiceImpl(CarRepository carRepo) {
//		super();
//		this.carRepo = carRepo;
//	}

	@Override
	public CarModel saveCarDetails(CarModel car) 
	{
		if(carRepo.existsById(car.getRegistrationNumber()))
		{
			throw new CarAlreadyAddedException("car with registration number "+ car.getRegistrationNumber() + "  is already exists" );
		}
		return carRepo.save(car);
	}

	@Override
	public CarModel findCar(long registrationNumber) {
		
		if(!carRepo.existsById(registrationNumber)) {
			throw new CarNotPresentException("car with the number "+registrationNumber+" Not Found");
		}
		
		Optional<CarModel> carModel = carRepo.findById(registrationNumber);
		return carModel.get();// The get method is used to get the data or to fetch the data...
	}

	@Override
	public CarModel updateCarModel(CarModel car) {
		return carRepo.save(car);
	}

	@Override
	public boolean deteleCar(long registrationNumber) 
	{
		if(!carRepo.existsById(registrationNumber)) {
			throw new CarAlreadyDeletedException("car with "+registrationNumber +" number is not existed");
		}
		carRepo.deleteById(registrationNumber);
		return !carRepo.existsById(registrationNumber);
	}

	@Override
	public List<CarModel> getAllCar() {
		// return carRepo.findAll();
		return carRepo.findAllByOrderBylastModifiedDesc();
	}

	@Override
	public List<CarModel> findByKeyword(String keyword) {
		return carRepo.findByKeyword(keyword);
	}

}

//}
