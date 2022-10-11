package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.repository.IPersonRepository;

@Service
public class PersonServiceImpl implements IPersonService{

	@Autowired
	IPersonRepository repository;
	public Person addPerson(Person person) {
		
		return repository.addPerson(person);
	}

	@Override
	public Person searchPerson(String personName) {
		
		return repository.searchPerson(personName);
	}

	@Override
	public List<Person> getAllPersons() {
	
		return repository.getAllPersons();
	}
	

}
