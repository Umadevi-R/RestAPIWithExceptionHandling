package com.example.demo.model;

import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {
	
	static List<Employee> empList = new ArrayList<>();
	
	static {
		empList.add(new Employee(1,"Uma","uma@gmail.com"));
		empList.add(new Employee(2,"Poojaa","poojaa@gmail.com"));
		empList.add(new Employee(3,"Manas","manas@gmail.com"));
	}
	
	public List<Employee> getEmployeeList(){
		return empList;
	}

	public Employee getEmployeeById(int id) {
		return empList.stream()
				.filter(emp -> emp.getId()==id)
				.findAny()
				.orElse(null);
		
	}

	public Employee addEmployee(Employee emp) {
		emp.setId(empList.size()+1);
		empList.add(emp);
		return emp;
	}
	
}
