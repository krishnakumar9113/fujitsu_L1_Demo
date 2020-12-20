package com.fujitsu.L1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.fujitsu.L1.Pojo.EmployeeHistory;
import com.fujitsu.L1.Repository.EmployeeHistoryRepository;
import com.fujitsu.L1.Repository.EmployeeRepository;

@RestController
@CrossOrigin
//@RequestMapping("/api")
public class EmployeeHistoryController {

	@Autowired 
	private EmployeeHistoryRepository emphistrepo;
	
	
	@GetMapping("/employeehistory/{empid}")
	private List<EmployeeHistory> getAllEmployeeHistory(@PathVariable("empid") long empid) 
	{  
	return emphistrepo.getEmpHistoryForEmp(empid);  
	}  
	
	/*
	 * @DeleteMapping("/employeehistory/{empid}") private String
	 * deleteEmployeeHistory(@PathVariable("empid") long empid) { return
	 * emphistrepo.delete(empid); }
	 */ 
	
	@PostMapping("/employeehistory/{empid}")  
	private long saveEmployee(@RequestBody EmployeeHistory emphist,@PathVariable("empid") long empid)   
	{  
		EmployeeHistory createdemp=emphistrepo.saveOrUpdate(emphist,empid);  
	return createdemp.getId();  
	}  
}
