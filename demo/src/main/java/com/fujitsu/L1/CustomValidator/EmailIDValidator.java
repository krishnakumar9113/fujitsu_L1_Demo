package com.fujitsu.L1.CustomValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.L1.Repository.EmployeeRepository;

public class EmailIDValidator  implements 
	  ConstraintValidator<EmailIDConstraint, String> {

	
	private EmployeeRepository emprepo;
	
	
	    @Override
	    public void initialize(EmailIDConstraint EmailID) {
	    }

	    @Override
	    public boolean isValid(String EmailID,
	      ConstraintValidatorContext cxt) {
	    	return true;
	    //	return emprepo.EmailValidation(EmailID);
	    }

	}

