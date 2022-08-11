package com.btc.car.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.btc.car.model.CarModel;
import com.btc.car.service.CarManagementService;

@Controller
public class CarModelController 
{
	@Autowired
	private CarManagementService service;
	
	//after enetering the submit button this add-cars url will work
	
	@PostMapping("/add-cars")
	public String insertCars(@ModelAttribute("add") CarModel car, RedirectAttributes redirectAttributes)
	{
		//CarModel carAdded = service.addCarDetails(car);
		service.addCarDetails(car);
		redirectAttributes.addFlashAttribute("addMessage"," Car details Added successfully.");
		return "redirect:/getAll";//here its not redirecting to the jsp file instead its redirecting to a getAll method
	} 
	
	//TO GET ALL CARS
		@GetMapping("/getAll")//no jsp is calling we need to call this first in the  browser itself..
		public String getAll(Model m, String keyword)
		{
		    List<CarModel>	getAllCar = service.getAllCarList();
		    
		    if((keyword=="")||(keyword==null))
		    {
		    	m.addAttribute("getAllCars", getAllCar);
		    	//return "noValue.jsp";
		    }
		    else
		    {
		    	m.addAttribute("getAllCars", service.getCarByKeyword(keyword));
		    }
		    return "GetAllCar.jsp";
		}
	
		
		//this abc is just to take the page for the addcars form or to display that...
		//insert-cars will add the just the forms....
		@GetMapping("/insert-cars")
		public String abc()
		{
			return "AddCars.jsp";
		}
	
	
		
		//load the updated form...(responsible to view the update form...)
		@GetMapping("/updateCar/{registrationNumber}")//loadEdit
		public String updateCarForm(@PathVariable("registrationNumber") long registrationNumber,
									Model m)
		{
			CarModel car = service.getCarDetailsById(registrationNumber);
			m.addAttribute("cars", car);
			return "/UpdateCar.jsp";
		}
		
		@PostMapping("/updateCar/updatingCar")//bcz updatingCar is a part of the updateCar
		public String updateCar(@ModelAttribute("updateCar") CarModel car, RedirectAttributes redirectAttributes)
		{
			service.updataCarDetails(car);
			redirectAttributes.addFlashAttribute("updatemessage", "Car details are updated");
			return "redirect:/getAll";
		}
		
		
	@GetMapping("/search-car")
	public String getCarById(@RequestParam("carId") long registrationNumber,
							Model m)
	{
		CarModel getCar = service.getCarDetailsById(registrationNumber);
		m.addAttribute("getCar", getCar);
		return "search.jsp";
	}
	
	@GetMapping("/deleteCar/{registrationNumber}")
	public String deleteCar(@PathVariable("registrationNumber") Long id, RedirectAttributes redirectAttributes)
	{
		service.deleteCarById(id);
		redirectAttributes.addFlashAttribute("deleteMessage", "The car details are deleted");
		return "redirect:/getAll";
	}
	
	
	
//	@GetMapping("/delete-car")
//	public String deleteCar(@RequestParam("carId") long registrationNumber,
//							Model m)
//	{
//		 service.deleteCarById(registrationNumber);
//		// String message="The car id with registration"+registrationNumber+ "is deleted";
//		 m.addAttribute("message", registrationNumber);
//		 return "delete.jsp";
//	}
	
	//To update the form....
//	@PostMapping("/update-cars/{id}")	
//	public String updateCars(@PathVariable("id") long registrationNumber,
//							@ModelAttribute CarModel car) {
//		CarModel cars= service.updataCarDetails(car);
//		return "UpdateCar.jsp";
//	}
	
}







