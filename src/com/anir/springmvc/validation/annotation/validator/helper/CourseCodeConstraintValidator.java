package com.anir.springmvc.validation.annotation.validator.helper;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.anir.springmvc.validation.annotation.validator.CourseCode;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode ,String> {

	private String prefix;
	
	@Override
	public void initialize(CourseCode constraintAnnotation) {
		// ConstraintValidator.super.initialize(constraintAnnotation);
		prefix = constraintAnnotation.value();
	}
	
	@Override
	public boolean isValid(String inputCode, ConstraintValidatorContext constraintValidatorContext) {
		boolean result;
		
		// We check for if user doesn't return any input data for code
		if(inputCode != null ){
			result= inputCode.startsWith(prefix);
		}else{
			return true;
		}
		
		return result;
	}

}
