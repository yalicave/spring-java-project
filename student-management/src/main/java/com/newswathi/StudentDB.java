package com.newswathi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.mysql.jdbc.PreparedStatement;

public class StudentDB {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/STUDENT";
	Connection conn = null;

	// Database credentials
	static final String USER = "****";
	static final String PASS = "****";

	public StudentDB() {
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

	public Student find() {
		Statement stmt = null;
		try {

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT Student_Name, Student_Age, Student_Roll_No, School_Name FROM Student";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			Student student = null;
			while (rs.next()) {
			 

			}

			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
			return student;
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
		String sql = "INSERT INTO Student VALUES (" + new Random().nextInt(1000) + ",'" + student.getStudName() + "','"
				+ student.getStudAge() + "','" + student.getStudRollNo() + "','" + student.getSchool() + "')";
		java.sql.PreparedStatement preparedStatement = conn.prepareStatement(sql);

		preparedStatement.executeUpdate(sql);
		System.out.print("Student Name: " + student.getStudName());
		System.out.print(", Student Age: " + student.getStudAge());
		System.out.print(", Student Roll no: " + student.getStudRollNo());
		System.out.println(", School name: " + student.getSchool());

	}

}
