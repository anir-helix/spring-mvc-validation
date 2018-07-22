<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Details</title>
<style >
	.error {color: red}
</style>
</head>
<body>
	
	<form:form action="processForm" modelAttribute="student">
	
		<i>Fill up the following details, Asterisk(*) means required</i>
		
		<br><br>
		First Name (*): <form:input path="firstName"/>
		<form:errors path="firstName" cssClass="error"/>
		
		<br><br>
		
		Last Name (*): <form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error"/>
		
		<br><br>
		
		Age (*): <form:input path="age"/>
		<form:errors path="age" cssClass="error"></form:errors>
		
		<br><br>
		
		Stream : <form:select path="stream">
		
		
		<!-- for parse data from java code -->
		<form:options items="${student.streamOptions}"/>
		
		</form:select>
		
		<br><br>
		
		Course Code: <form:input path="courseCode"/>
		<form:errors path="courseCode" cssClass="error"></form:errors>
		
		<br><br>
		
		Country: 
		<form:select path="country"> 
		<%-- 
		 For Hard coded values
		<form:option value="India" label="India"/>
		<form:option value="Bangladesh" label="Bangladesh"/>
		<form:option value="Bhutan" label="Bhutan"/>
		<form:option value="Nepal" label="Nepal"/> 
		
		--%>
		
		 <form:options items="${theCountryOptions}" />
		</form:select>
		
		<br><br>
		
		Postal Code : <form:input path="postalCode"/>
		<form:errors path="postalCode" cssClass="error"></form:errors>
		
		<br><br>
		Select Degree:
		<br>
		Grad. Pass <form:radiobutton path="degree" value="Grad. Pass"/>
		B.Sc. <form:radiobutton path="degree" value="B.Sc."/>
		M.Sc. <form:radiobutton path="degree" value="M.Sc."/>
		PHd. <form:radiobutton path="degree" value="PHd."/>
		
		
		<br><br>
		Language Pref:
		<br>
		<form:checkboxes path="languagepref" items="${student.langOptions}"/>
		
		<br><br>
		<input type="submit" value="submit"/>
	
	</form:form>
	
</body>
</html>