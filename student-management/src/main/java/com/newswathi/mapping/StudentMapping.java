package com.newswathi.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.newswathi.School;
import com.newswathi.Student;

public class StudentMapping implements RowMapper<Student>{

	public Student mapRow(ResultSet rs, int arg1) throws SQLException {
		// Retrieve by column name
		String studName = rs.getString("Student_Name");
		int studAge = rs.getInt("Student_Age");
		int studRollNo = rs.getInt("Student_Roll_No");
		String school = rs.getString("School_Name");

		// Display values
		Student student = new Student();
		student.setStudName(studName);
		student.setStudAge(studAge);
		student.setStudRollNo(studRollNo);
		student.setSchool(new School(school));
		return student;
	}

}
