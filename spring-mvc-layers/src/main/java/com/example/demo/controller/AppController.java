package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Person;
import com.example.demo.service.IPersonService;

@Controller
public class AppController {
	
	@Autowired
	IPersonService service;
	
	@GetMapping("/")
	public String getHomePage()
	{
		return "index.jsp";
	}
	@PostMapping("/add-person") // here we are using model attribute so no 
	//need of model and setAttributes also not assigning to anything
	public String addPerson(@ModelAttribute("per") Person person)
	{
		//modelAttribute takes all the fields
		service.addPerson(person);
		return "show.jsp";
	}
	
//	@GetMapping("/search-person")
//	public String searchByName(@RequestParam("pname") String personName ,Model m)
//	{
//		Person person=service.searchPerson(personName);
//		m.addAttribute("person",person);
//		
//		return "show.jsp";
//	}

	@GetMapping("/search-person")
//	@ResponseBody
	public String getPersonDetails(@RequestParam("pname") String personName, Model m) {
		Person person = service.searchPerson(personName);
		m.addAttribute("person", person);
		//return person;
		return "show.jsp";
	}
	
	
	@PostMapping("/get-persons") // here we are using model attribute so no need of model and setAttributes also not assigning to anything
	@ResponseBody
	public List<Person> getAllPersons()
	{
	List<Person> persons =	service.getAllPersons();
	//System.out.println("getAll persons "+persons);
	//m.addAttribute("person",persons);
	// here no need of jsp file we use json for this
		return persons;
	}
}
