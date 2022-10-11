package com.btc.car.model;

import java.sql.Date;
//import org.hibernate.annotations.UpdateTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarModel {

	private long registrationNumber;
	private String carName;
	private String carBrand;
	private String carPrice;
	private String carColour;
	private String image;

	
	public void m1() {
		System.out.println("finalcompleted the gitlab tests");
	}

	public void m3() {
	}
}
