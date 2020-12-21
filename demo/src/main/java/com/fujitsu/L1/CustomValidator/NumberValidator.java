package com.fujitsu.L1.CustomValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumberValidator  implements 
	  ConstraintValidator<NumberConstraint, String> {

	
	    @Override
	    public void initialize(NumberConstraint EmailID) {
	    }

	    @Override
	    public boolean isValid(String Value,
	      ConstraintValidatorContext cxt) {
	    	
	    	if(Value.matches("/([1-9][0-9]*)|0/")) {
	    		return true;
	    	}else {
	    		return false;
	    	}
	    }

	}

