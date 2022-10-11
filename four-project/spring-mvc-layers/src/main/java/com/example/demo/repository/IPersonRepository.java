package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Person;

public interface IPersonRepository 
{
 public Person addPerson(Person person);
 public Person searchPerson(String personName);
 public List<Person> getAllPersons();
}
