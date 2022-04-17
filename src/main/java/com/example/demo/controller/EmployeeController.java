package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	public void saveEmployee(@RequestBody Employee emp) {
		empdao.addEmployee(emp);
	}
}
