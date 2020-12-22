package com.fujitsu.L1.CustomValidator;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.fujitsu.L1.Repository.EmployeeRepository;

public class AgeValidator  implements 
	  ConstraintValidator<AgeConstraint, LocalDate> {

	    @Override
	    public void initialize(AgeConstraint EmailID) {
	    }

	    @Override
	    public boolean isValid(LocalDate DateofBirth,
	      ConstraintValidatorContext cxt) {
	    //	LocalDate date = LocalDate.of(2005, 1, 1); // Assign date to check
	    	if(DateofBirth!=null) {
	    		LocalDate today = LocalDate.now();
		    	if(DateofBirth.isAfter(today)) {
		    		return true;// let @past annotation handle
		    	}
		    	if (DateofBirth.isBefore(today.minusYears(20))){
		    		return true;
		    	}else {
		    		return false;
		    	}
	    	}else {
	    		return false;
	    	}
	    	
	    	
	    //	return emprepo.EmailValidation(EmailID);
	    }

	}

