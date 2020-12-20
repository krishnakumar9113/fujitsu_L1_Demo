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
	private ResponseEntity  getAllEmployees()   
	{  
		List<Employee> emps=emprepo.getAllEmployees();
		if(emps.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createmessage(" Sorry, employee record could not be found!!"));
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(emps);
		}
 
	}  
	
	@GetMapping("/employeefilter")
	private ResponseEntity  getemp_name_gender(@PathParam("empname") String empname,@PathParam("gender") String gender)   
	{  
		List<Employee> emps=emprepo.getEmpByNameGender(empname,gender);
		if(emps.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createmessage(" Sorry, employee record could not be found!!"));
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(emps);
		}
	//return emprepo.getEmpByNameGender(empname,gender); 
	}  
	
	@GetMapping("/employee/{empid}")  
	private ResponseEntity getEmployee(@PathVariable("empid") int empid)   
	{  
		
		Employee emp=emprepo.getempById(empid);
		if(emp==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createmessage(" Sorry, employee record could not be found!!"));
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(emp);
		}

	}  
	
	@DeleteMapping("/employee/{empid}")  
	private ResponseEntity deleteEmployee(@PathVariable("empid") long empid)   
	{  
		if(emprepo.delete(empid).equals("Success")) {
			return ResponseEntity.status(HttpStatus.OK).body(createmessage("Employee record has been deleted successfully"));
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(createmessage("Error has encounterd, failed to delete record."));
		}
		
	}  
	
	@PostMapping("/employee")  
	private ResponseEntity saveEmployee(@Valid @RequestBody Employee emp, BindingResult bindingResult) 
  
	{  try {
		
	
		if (bindingResult.hasErrors()){
			
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(bindingResult.getFieldErrors());
		}else {
			Employee createdemp=emprepo.saveOrUpdate(emp);  
			return ResponseEntity.status(HttpStatus.CREATED).body(createmessage("Employee record has been saved successfully"));
			
		}
	
	}catch(Exception e) {
		return ResponseEntity.badRequest().body(createmessage("Server error has encountered, failed to save the record"));
	}
	}  
	
	
	//creating put mapping that updates the book detail   
	@PutMapping("/employee")  
	private ResponseEntity updateEmployee(@Valid @RequestBody Employee emp, BindingResult bindingResult)   
	{  
			if (bindingResult.hasErrors()){
			
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(bindingResult.getFieldErrors());
		}else {
			Employee createdemp=emprepo.saveOrUpdate(emp);  
			return ResponseEntity.status(HttpStatus.OK).body("Employee record has been updated successfully.");
			//return createdemp;  
		}
		
	}
	
	public String createmessage(String msg) {
		return "{\"msg\":\""+msg+"\"}";
	}
	
}
