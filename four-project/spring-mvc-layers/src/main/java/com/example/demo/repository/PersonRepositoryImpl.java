package com.example.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository
public class PersonRepositoryImpl implements IPersonRepository,InitializingBean{

	Map<String,Person> personList;
	public void afterPropertiesSet() throws Exception 
	{
		personList=new HashMap<>();	
	}
	
	@Override
	public Person addPerson(Person person) {
		personList.put(person.getPersonName(), person);
		//System.out.println("add persons "+personList);
		return person;
	}

	@Override
	public Person searchPerson(String personName) {
		return	personList.get(personName);
		 
	}

	@Override
	public List<Person> getAllPersons() {
		List<Person> persons=new ArrayList<>(personList.values());
		//passing only values not keys
//		persons.add(personList.get(personList.keySet()));
	//	System.out.println("persons are: "+persons);
		return persons;
	}

}
