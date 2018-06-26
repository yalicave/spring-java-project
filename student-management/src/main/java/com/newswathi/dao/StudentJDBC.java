package com.newswathi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.mysql.jdbc.PreparedStatement;
import com.newswathi.School;
import com.newswathi.Student;

//@Component("studentDb")
public class StudentJDBC implements StuentDAO {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/STUDENT";
	Connection conn = null;

	// Database credentials
	static final String USER = "****";
	static final String PASS = "****";

	public StudentJDBC() {
		try {
			init();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void init() throws ClassNotFoundException, SQLException {
		// STEP 2: Register JDBC driver
		Class.forName("com.mysql.jdbc.Driver");

		// STEP 3: Open a connection
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

	}

	public List<Student> find() {
		Statement stmt = null;
		try {

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT Student_Name, Student_Age, Student_Roll_No, School_Name FROM Student";
			ResultSet rs = stmt.executeQuery(sql);
			
			List<Student> result = new ArrayList<Student>();
			// STEP 5: Extract data from result set
			Student student = null;
			while (rs.next()) {
				// Retrieve by column name
				String studName = rs.getString("Student_Name");
				int studAge = rs.getInt("Student_Age");
				int studRollNo = rs.getInt("Student_Roll_No");
				String school = rs.getString("School_Name");

				// Display values
				student = new Student();
				student.setStudName(studName);
				student.setStudAge(studAge);
				student.setStudRollNo(studRollNo);
				student.setSchool(new School(school));
				result.add(student);
			}

			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
			return result;
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
		return null;
	}

	public void insert(Student student) throws SQLException {
		student.setStudName("One");
		student.setStudAge(1);
		student.setStudRollNo(20);
		String sql = "INSERT INTO Student (id,Student_Name,Student_Age,"
				+ "Student_Roll_No,School_Name) VALUES (?,'?',?,?,'?')";
		java.sql.PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, 10);
		preparedStatement.setString(2, student.getStudName());
		preparedStatement.setInt(3, student.getStudAge());
		preparedStatement.setInt(4, student.getStudRollNo());
		preparedStatement.setString(5, student.getStudName());

		preparedStatement.executeUpdate(sql);
		System.out.print("Student Name: " + student.getStudName());
		System.out.print(", Student Age: " + student.getStudAge());
		System.out.print(", Student Roll no: " + student.getStudRollNo());
		System.out.println(", School name: " + student.getSchool());

	}

}
