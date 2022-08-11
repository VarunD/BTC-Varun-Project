package com.btc.car.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.btc.car.model.CarModel;

public interface CarRepository extends JpaRepository<CarModel, Long>
{
	
	@Query(value="select * from car_model c where c.car_name like %:keyword% or registration_number like %:keyword%", nativeQuery=true)
	List<CarModel> findByKeyword(@Param("keyword") String keyword);
	
	@Query(value="select * from car_model order by last_modified desc", nativeQuery=true)
	public List<CarModel> findAllByOrderBylastModifiedDesc();



	

	
}
