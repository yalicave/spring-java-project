package com.newswathi;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;

public class StudentApplication {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		Student studentInfo = (Student) ctx.getBean("studInfo");

		StudentInput sinput = new StudentInput();
		sinput.studInput(studentInfo);

		Map<String, String> map = new HashMap<String, String>();
		map.put("studName", studentInfo.getStudName());
		map.put("studAge", studentInfo.getStudAge()+"");
		map.put("studRollNo", studentInfo.getStudRollNo()+"");
		
		MapBindingResult errors = new MapBindingResult(map, Student.class.getName());
		studentInfo.validate(studentInfo, errors);
		System.out.println(errors.getAllErrors().size());
		for (ObjectError error : errors.getAllErrors()) {
			String name = ctx.getMessage(error.getCode(), new Object[] { 28, "anand swathi" }, Locale.US);
			System.out.println(name);
		}
		String name = ctx.getMessage("enter-your-name", new Object[] { 28, "anand swathi" }, Locale.US);

		System.out.println("enter-your-name (English) : " + name);

		String namechinese = ctx.getMessage("enter-your-name", new Object[] { 28, "anand swathi" },
				Locale.SIMPLIFIED_CHINESE);

		System.out.println("enter-your-name (Chinese) : " + namechinese);
		
		ctx.close();
	}

}
