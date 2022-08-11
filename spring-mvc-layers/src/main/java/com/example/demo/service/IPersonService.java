package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Person;

public interface IPersonService {
	 public Person addPerson(Person person);
	 public Person searchPerson(String personName);
	
	public List<Person> getAllPersons();
	
}
