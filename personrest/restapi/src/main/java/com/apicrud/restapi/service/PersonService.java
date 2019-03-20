package com.apicrud.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicrud.restapi.model.Person;
import com.apicrud.restapi.repository.PersonRepository;


@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	//Create operation
	public Person create(String firstName,String lastName, int age) {
		return personRepository.save(new Person(firstName, lastName, age));
	}
		
	//Retrieve operation
	public List<Person> getAll(){
		return personRepository.findAll();
	}
	public Person getByFirstName(String firstName) {
		return personRepository.findByFirstName(firstName);
	}
	//Update operation
	public Person update(String firstName,String lastName, int age) {
		Person p=personRepository.findByFirstName(firstName);
		p.setAge(age);
		p.setFirstName(firstName);
		p.setLastName(lastName);
		return personRepository.save(p);
	}
	//Delete operation
	public void deleteAll() {
		personRepository.deleteAll();
	}
	public void delete(String firstName) {
		Person p=personRepository.findByFirstName(firstName);
		personRepository.delete(p);
	}
	}