package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.exception.EmployeeNotFound;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeDao;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeDao empdao;
	
	@GetMapping(path="/employees")
	public List<Employee> getAllEmployees(){
		return empdao.getEmployeeList();
	}
	
	@GetMapping(path="/employee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		Employee emp = empdao.getEmployeeById(id);
		if(emp == null) {
			throw new EmployeeNotFound("Employee not found");
		}
		return emp;
	}
	
	@PostMapping(path="/employee/user")
	public ResponseEntity<Object> saveEmployee(@RequestBody Employee emp) {
		Employee newEmployee = empdao.addEmployee(emp);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{id}")
				.buildAndExpand(newEmployee.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
}
