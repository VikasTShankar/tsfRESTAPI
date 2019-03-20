package com.apicrud.restapi.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apicrud.restapi.model.Person;
import com.apicrud.restapi.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@PostMapping("person/create")
	public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
		Person p= personService.create(firstName, lastName, age);
		return p.toString();
	}
	
	@GetMapping("person/get")
	public Person getPerson(@RequestParam String firstName) {
		return personService.getByFirstName(firstName);
	}
	@GetMapping("person/getAll")
	public List<Person> getAll(){
		return personService.getAll();
	}
	@PutMapping("person/update")
	public String update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
		Person p = personService.update(firstName, lastName, age);
		return p.toString();
	}
	@DeleteMapping("person/delete")
	public String delete(@RequestParam String firstName) {
		personService.delete(firstName);
		return "Deleted "+firstName;
	}
	@DeleteMapping ("person/deleteAll")
	public String deleteAll() {
		personService.deleteAll();
		return "Deleted all records";
	}
	
}
