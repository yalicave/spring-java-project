package com.newswathi;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import com.newswathi.mapping.StudentMapping;

@Component("studentJDBCTemplate")
public class StudentJDBCTemplate implements StuentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.newswathi.StuentDAO#find()
	 */
	public List<Student> find() {

		// STEP 4: Execute a query
		System.out.println("Creating statement...");
		String sql = "SELECT Student_Name, Student_Age, Student_Roll_No, School_Name FROM Student";
		StudentMapping studentMapper = new StudentMapping();
		return jdbcTemplate.query(sql, studentMapper);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.newswathi.StuentDAO#insert(com.newswathi.Student)
	 */
	public void insert(Student student) {
		String insertsql = "INSERT INTO Student (id,Student_Name,Student_Age,"
				+ "Student_Roll_No,School_Name) VALUES (?,?,?,?,?)";
		int id = new Random().nextInt(1000);
		int nstudent = jdbcTemplate.update(insertsql,id, student.getStudName(),student.getStudAge(),student.getStudRollNo(),student.getSchool().getName());
		System.out.println(nstudent);

	}
}