package com.anir.springmvc.validation.annotation.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anir.springmvc.validation.annotation.dto.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Value("#{countryOptions}")
	private Map<String, String> countryOptions;
	
	/*Add a init binder annotation and function to trim a request string
	This will also trim end and start long space for string*/
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, trimmerEditor);
	}
	
	@RequestMapping("/showForm")
	public String showStudNameForm(Model modelStud){
		//Create Student object
		Student theStud = new Student();
		
		modelStud.addAttribute("student", theStud);
		modelStud.addAttribute("theCountryOptions", countryOptions);
		
		return "show-student";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("student") Student theStudent, BindingResult bindingResult){
		
		//Log Data
		System.out.println("The Student: FirstName- " + theStudent.getFirstName() + " LastName-"+ theStudent.getLastName());
		System.out.println("The Student Country: " + theStudent.getCountry());
		
		System.out.println("\n\nThe bindingResult: " + bindingResult + "\n\n");
		
		if(bindingResult.hasErrors()){
			return "show-student";
		}else{
			return "student-confirmation";
		}
	}
}
