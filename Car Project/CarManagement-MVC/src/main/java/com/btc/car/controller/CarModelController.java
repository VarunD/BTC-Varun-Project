package com.btc.car.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.btc.car.model.CarModel;
import com.btc.car.service.CarManagementService;

@Controller
public class CarModelController {
	
	@Autowired
	private CarManagementService service;


	@PostMapping("/add-cars")
	public String insertCars(@ModelAttribute("add") CarModel car, 
			RedirectAttributes redirectAttributes , 
			@RequestPart("imageFile") MultipartFile image1) throws IOException 
	{
		File file = new File("F:/btc-gitlab/four-project/CarManagement-MVC/src/main/webapp/image/"+car.getRegistrationNumber()+image1.getOriginalFilename());
		file.createNewFile(); 
		
		car.setImage(car.getRegistrationNumber()+image1.getOriginalFilename());
		try(FileOutputStream fileOutput = new FileOutputStream(file)) 
		{	
			fileOutput.write(image1.getBytes());
		}
		
		service.addCarDetails(car);
		System.out.println("");
		redirectAttributes.addFlashAttribute("addMessage", " Car details of number "+car.getRegistrationNumber() + " Added successfully.");
		return "redirect:/getAll";
	}
	


	// TO GET ALL CARS
	@GetMapping("/getAll") // no jsp is calling we need to call this first in the browser itself..
	public String getAll(Model m,  String keyword) {
		List<CarModel> getAllCar = service.getAllCarList();

		if((keyword == "") || (keyword == null)) {
			m.addAttribute("getAllCars", getAllCar);
			// return "noValue.jsp";
		} 
		else {
			m.addAttribute("getAllCars", service.getCarByKeyword(keyword));
		}
		return "GetAllCar.jsp";
	}

	
	@GetMapping("/insert-cars")
	public String abc() {
		return "AddCars.jsp";
	}

	//load the updated form...(responsible to view the update form...)
	@GetMapping("/updateCar/{registrationNumber}") // loadEdit
	public String updateCarForm(@PathVariable("registrationNumber") long registrationNumber, Model m) {
		CarModel car = service.getCarDetailsById(registrationNumber);
		m.addAttribute("cars", car);
		return "/UpdateCar.jsp";
	}

	
	
	@PostMapping("/updateCar/updatingCar") // bcz updatingCar is a part of the updateCar
	public String updateCar(@ModelAttribute("updateCar") CarModel car, RedirectAttributes redirectAttributes, 
			@RequestParam("previousImage") String previousImage,
			@RequestPart("imageFile") MultipartFile image1) throws IOException
		{
		File file1 = new File("F:/btc-gitlab/four-project/CarManagement-MVC/src/main/webapp/image/"+previousImage);
		file1.delete(); 
		
		File file = new File("F:/btc-gitlab/four-project/CarManagement-MVC/src/main/webapp/image/"+car.getRegistrationNumber()+image1.getOriginalFilename());
		file.createNewFile(); 
		car.setImage(car.getRegistrationNumber()+image1.getOriginalFilename());
		try (FileOutputStream fileOutput = new FileOutputStream(file)) 
		{
			fileOutput.write(image1.getBytes());
		}
		service.updateCarDetails(car);
		redirectAttributes.addFlashAttribute("updatemessage", "Car details of registration number "+car.getRegistrationNumber()+" updated");
		return "redirect:/getAll";
		}

	

	@GetMapping("/deleteCar")
	public String deleteCar( @RequestParam("registrationNumber") Long registrationNumber, 
			@RequestParam("image") String image1,
			RedirectAttributes redirectAttributes) 
	{
		File file1 = new File("F:/btc-gitlab/four-project/CarManagement-MVC/src/main/webapp/image/"+image1);
		file1.delete(); 
		service.deleteCarById(registrationNumber); // to store flash attributes 
		redirectAttributes.addFlashAttribute("deleteMessage", "The car details of number  "+ registrationNumber +" deleted");
		return "redirect:/getAll";
	}

}
