package com.crudapi.emprest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crudapi.emprest.model.Emp;
import com.crudapi.emprest.service.EmpService;
@RestController
public class EmpController {

	@Autowired
	private EmpService empService;
	
	@PostMapping("employee/create")
	public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
		Emp p= empService.create(firstName, lastName, age);
		return p.toString();
	}
	
	@GetMapping("employee/get")
	public Emp getPerson(@RequestParam String firstName) {
		return empService.getByFirstName(firstName);
	}
	@GetMapping("employee/getAll")
	public List<Emp> getAll(){
		return empService.getAll();
	}
	@PutMapping("employee/update")
	public String update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
		Emp p = empService.update(firstName, lastName, age);
		return p.toString();
	}
	@DeleteMapping("employee/delete")
	public String delete(@RequestParam String firstName) {
		empService.delete(firstName);
		return "Deleted "+firstName;
	}
	@DeleteMapping ("employee/deleteAll")
	public String deleteAll() {
		empService.deleteAll();
		return "Deleted all records";
	}
	
}
