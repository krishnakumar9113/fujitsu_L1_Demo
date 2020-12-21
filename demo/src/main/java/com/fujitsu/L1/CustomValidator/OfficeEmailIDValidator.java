package com.fujitsu.L1.CustomValidator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.Session;

import com.fujitsu.L1.Pojo.Employee;

public class OfficeEmailIDValidator  implements 
	  ConstraintValidator<OfficeEmailIDConstraint, String> {


	    @Override
	    public void initialize(OfficeEmailIDConstraint EmailID) {
	    }

	    @Override
	    public boolean isValid(String EmailID,
	      ConstraintValidatorContext cxt) {
	    	return true;
	    	////return emprepo.EmailValidation(EmailID);
	    }

	}

