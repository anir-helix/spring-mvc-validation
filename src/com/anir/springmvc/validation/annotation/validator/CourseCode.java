package com.anir.springmvc.validation.annotation.validator;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.anir.springmvc.validation.annotation.validator.helper.CourseCodeConstraintValidator;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RUNTIME)
public @interface CourseCode {
	
	//Define Default course code
	public String value() default "MES";
	
	//define  default error message
	public String message() default "code must start with MES-";
	
	//define default groups
	public Class<?>[] groups() default {};
	
	//define default payloads
	public Class<? extends Payload> [] payload() default {};

}
