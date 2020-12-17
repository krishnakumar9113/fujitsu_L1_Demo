package com.fujitsu.L1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fujitsu.L1.Pojo.Employee;
import com.fujitsu.L1.Repository.EmployeeRepository;

@RestController
//@RequestMapping("/api")
public class EmployeeController {

	@Autowired 
	private EmployeeRepository emprepo;
	
	
	@GetMapping("/employee")
	private List<Employee> getAllEmployees()   
	{  
	return emprepo.getAllEmployees();  
	}  
	
	@GetMapping("/employee/{empid}")  
	private Employee getEmployee(@PathVariable("empid") int empid)   
	{  
	return emprepo.getempById(empid);  
	}  
	
	@DeleteMapping("/employee/{empid}")  
	private String deleteEmployee(@PathVariable("empid") long empid)   
	{  
		return emprepo.delete(empid);  
	}  
	
	@PostMapping("/employee")  
	private long saveEmployee(@RequestBody Employee emp)   
	{  
	Employee createdemp=emprepo.saveOrUpdate(emp);  
	return createdemp.getEmp_id();  
	}  
	
	//creating put mapping that updates the book detail   
	@PutMapping("/employee")  
	private Employee updateEmployee(@RequestBody Employee emp)   
	{  
		Employee createdemp=emprepo.saveOrUpdate(emp);   
	return createdemp;  
	}  
	
}
