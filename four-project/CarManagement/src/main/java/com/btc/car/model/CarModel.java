package com.btc.car.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CarModel
{
	@Id
	@Column(name = "registration_number",  length = 4)
	
	private long registrationNumber;
	@NotEmpty
	@Size(min = 2, message = "car name should be more than 2 characters")
	@Column(name = "CarName")
	private String carName;

	
	@NotEmpty
	@Column(name = "Car_brand")
	private String carBrand;

	@Positive
	private long carPrice;

	private String carColour;

	@UpdateTimestamp
	@Column(name = "lastModified")
	private Date lastModified;

	private String image;
	
	public CarModel(long registrationNumber,
			@Size(min = 4, message = "car name should be more than 4 characters") String carName,
			@NotEmpty String carBrand, long carPrice, String carColour,  String image) {
		super();
		this.registrationNumber = registrationNumber;
		this.carName = carName;
		this.carBrand = carBrand;
		this.carPrice = carPrice;
		this.carColour = carColour;
		this.image = image;
	}
}
