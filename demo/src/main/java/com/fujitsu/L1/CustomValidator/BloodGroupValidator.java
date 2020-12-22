package com.fujitsu.L1.CustomValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BloodGroupValidator  implements 
	  ConstraintValidator<BloodGroupConstraint, String> {


	    @Override
	    public void initialize(BloodGroupConstraint BG) {
	    }

	    @Override
	    public boolean isValid(String BG,
	      ConstraintValidatorContext cxt) {
	    	if(BG!=null) {
	    		if(BG.equals("A+")||BG.equals("A-")||BG.equals("O+")||BG.equals("etc")) {
		    		return true;
		    	}else {
		    		return false;
		    	}
	    	}else {
	    		return false;
	    	}
	    
	    }

	}

