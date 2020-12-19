package com.fujitsu.L1.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
//@RequestMapping("/api")
public class EmployeeController {

	@Autowired 
	private EmployeeRepository emprepo;
	
	
	@GetMapping("/employees")
	private List<Employee> getAllEmployees()   
	{  
	   return emprepo.getAllEmployees();  
	}  
	
	@GetMapping("/employeefilter")
	private List<Employee> getemp_name_gender(@PathParam("empname") String empname,@PathParam("gender") String gender)   
	{  
	return emprepo.getEmpByNameGender(empname,gender); 
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
	private ResponseEntity saveEmployee(@Valid @RequestBody Employee emp, BindingResult bindingResult) 
  
	{  try {
		
	
		if (bindingResult.hasErrors()){
			
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(bindingResult.getFieldErrors());
		}else {
			Employee createdemp=emprepo.saveOrUpdate(emp);  
			return ResponseEntity.ok().body("Employee record has been saved successfully.");
			
		}
	
	}catch(Exception e) {
		return ResponseEntity.badRequest().body("Server error has encountered, failed to save the record");
	}
	}  
	
	//creating put mapping that updates the book detail   
	@PutMapping("/employee")  
	private Employee updateEmployee(@RequestBody Employee emp)   
	{  
		Employee createdemp=emprepo.saveOrUpdate(emp);   
	return createdemp;  
	}  
	
}
