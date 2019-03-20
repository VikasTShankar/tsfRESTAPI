package com.crudapi.emprest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudapi.emprest.model.Emp;
import com.crudapi.emprest.repository.EmpRepository;
@Service
public class EmpService {
	
	@Autowired
	private EmpRepository personRepository;
	
	//Create operation
	public Emp create(String firstName,String lastName, int age) {
		return personRepository.save(new Emp(firstName, lastName, age));
	}
		
	//Retrieve operation
	public List<Emp> getAll(){
		return personRepository.findAll();
	}
	public Emp getByFirstName(String firstName) {
		return personRepository.findByFirstName(firstName);
	}
	//Update operation
	public Emp update(String firstName,String lastName, int age) {
		Emp p=personRepository.findByFirstName(firstName);
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
		Emp p=personRepository.findByFirstName(firstName);
		personRepository.delete(p);
	}
	}
