package com.newswathi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("studInfo")
public class Student implements Validator{
	
	private String studName;
	private int studAge;
	private int studRollNo;
	
	@Autowired
	private School school;
	
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public int getStudAge() {
		return studAge;
	}
	public void setStudAge(int studAge) {
		this.studAge = studAge;
	}
	public int getStudRollNo() {
		return studRollNo;
	}
	public void setStudRollNo(int studRollNo) {
		this.studRollNo = studRollNo;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	@Override
	public String toString() {
		return "Student [studName=" + studName + ", studAge=" + studAge + ", studRollNo=" + studRollNo + ", school="
				+ school + "]";
	}
	public boolean supports(Class<?> clazz) {
		return Student.class.equals(clazz);
	}
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmpty(errors, "studName", "student.name.invalid");
		Student student = (Student)target;
		if(student.getStudAge()>5)
		{
			System.out.println("Valid age for admission"+" "+student.getStudName());
		}
		else
		{
			errors.reject("student.age.invalid");
		}
		
	}

}
