package com.fujitsu.L1.CustomValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GenderValidator  implements 
	  ConstraintValidator<GenderConstraint, String> {

	
	    @Override
	    public void initialize(GenderConstraint Gender) {
	    }

	    @Override
	    public boolean isValid(String Value,
	      ConstraintValidatorContext cxt) {
	    	
	    	if(Value!=null) {
	    		if(Value.equals("M")||Value.equals("F")||Value.equals("ND")) {
		    		return true;
		    	}else {
		    		return false;
		    	}
	    	}else {
	    		return false;
	    	}
	    	
	    }

	}

