package com.fujitsu.L1.CustomValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



	@Documented
	@Constraint(validatedBy = AgeValidator.class)
	@Target( { ElementType.METHOD, ElementType.FIELD })
	@Retention(RetentionPolicy.RUNTIME)
	public @interface AgeConstraint {
	    String message() default "Please  enter a valid date , age must be >=20";
	    Class<?>[] groups() default {};
	    Class<? extends Payload>[] payload() default {};
	}

