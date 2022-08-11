package com.btc.car.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  
@AllArgsConstructor
@NoArgsConstructor

public class CarModel 
{
	private long registrationNumber;
	private String carName;
	private String carBrand;
	private String carPrice;
	private String carColour;
	private String lastModified;
	
}
