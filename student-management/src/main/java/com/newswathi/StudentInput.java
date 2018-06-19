package com.newswathi;

import java.util.Scanner;

public class StudentInput {
	public void studInput(Student studentInfo) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter student name: ");
		String sName = sc.next();
		studentInfo.setStudName(sName);
		System.out.println("Enter student age: ");
		int sAge = sc.nextInt();
		studentInfo.setStudAge(sAge);

		System.out.println("Enter student rollno: ");
		int sRollNo = sc.nextInt();
		studentInfo.setStudRollNo(sRollNo);

		sc.close();
	}


}
