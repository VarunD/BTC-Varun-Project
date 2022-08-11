package com.btc.car.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CarModel 
{
	@Id
	private long registrationNumber;
	private String carName;
	private String carBrand;
	private long carPrice;
	private String carColour;
	public String lastModified;
	
	
}
