package com.anir.springmvc.validation.annotation.dto;

import java.util.LinkedHashMap;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.anir.springmvc.validation.annotation.validator.CourseCode;
import com.anir.springmvc.validation.annotation.validator.CourseCodeMulti;

public class Student {

	@NotNull(message="First Name is Required")
	@NotEmpty(message="First Name is Required")
	private String firstName;
	
	@NotNull(message="Last Name is Required")
	@Size(min=2, message="Last Name is Reuired and Must me greater than 2 chars")
	private String lastName;
	
	@NotNull(message="Age is Required")
	@Min(value=16, message="Min Age should not be less than 16")
	@Max(value=32, message="Max Age should not be greater than 32")
	private Integer age;
	
	private String stream;

	/***************	for single set code option validation 		***********************/
	
	//@CourseCode(value="MES")
	
	/***************	for multiple set code option validation		***********************/
	
	@CourseCodeMulti(value={"SC","COM", "MES"}, message="Please Enter a code starts with SC, COM, MES" )
	private String courseCode;
	
	private String country;
	
	private String degree;
	
	private String[] languagepref;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="Only 5 char/digits")
	private String postalCode; 
	
	private LinkedHashMap<String, String> streamOptions;
	private LinkedHashMap<String, String> langOptions;
	
	
	/**
	 * 
	 */
	public Student() {
		//Populate stream Options by initializing LinkedHashMap
		streamOptions = new LinkedHashMap<>();
		
		streamOptions.put("Science" ,"Science");
		streamOptions.put("ARTS" ,"ARTS");
		streamOptions.put("Comm" ,"Commerce");
		streamOptions.put("Bio-Sc" ,"Bio-Sc");
		
		langOptions = new LinkedHashMap<>();
		langOptions.put("English","English");
		langOptions.put("Spanish","Spanish");
		langOptions.put("Hindi","Hindi");
		langOptions.put("Nepali","Nepali");
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public Integer getAge() {
		return age;
	}


	/**
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}


	public String getStream() {
		return stream;
	}


	public String getCountry() {
		return country;
	}


	public String getDegree() {
		return degree;
	}


	public String[] getLanguagepref() {
		return languagepref;
	}


	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}


	public LinkedHashMap<String, String> getStreamOptions() {
		return streamOptions;
	}


	public LinkedHashMap<String, String> getLangOptions() {
		return langOptions;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @param age the age to set
	 */
	public final void setAge(Integer age) {
		this.age = age;
	}


	/**
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}


	/**
	 * @param stream the stream to set
	 */
	public final void setStream(String stream) {
		this.stream = stream;
	}


	/**
	 * @param country the country to set
	 */
	public final void setCountry(String country) {
		this.country = country;
	}


	/**
	 * @param degree the degree to set
	 */
	public final void setDegree(String degree) {
		this.degree = degree;
	}


	/**
	 * @param languagepref the languagepref to set
	 */
	public final void setLanguagepref(String[] languagepref) {
		this.languagepref = languagepref;
	}


	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
}
