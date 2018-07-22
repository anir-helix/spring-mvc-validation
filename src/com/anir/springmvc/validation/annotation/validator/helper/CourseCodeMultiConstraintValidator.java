package com.anir.springmvc.validation.annotation.validator.helper;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.anir.springmvc.validation.annotation.validator.CourseCodeMulti;

public class CourseCodeMultiConstraintValidator implements ConstraintValidator<CourseCodeMulti ,String> {

	private String[] prefixes;
	
	@Override
	public void initialize(CourseCodeMulti constraintAnnotation) {
		// ConstraintValidator.super.initialize(constraintAnnotation);
		prefixes = constraintAnnotation.value();
	}
	
	@Override
	public boolean isValid(String inputCode, ConstraintValidatorContext constraintValidatorContext) {
		boolean result = false;
		
		// We check for if user doesn't return any input data for code
		if(inputCode != null ){
			
			// loop thru multiple course prefixes
            // check to see if code matches any of the course prefixes
            //
			for(String prefix : prefixes){
				result= inputCode.startsWith(prefix);
				
				// if we found a match then break out of the loop
				if(result){
					break;
				}
			}
		}else{
			result = true;
		}
		
		return result;
	}

}
