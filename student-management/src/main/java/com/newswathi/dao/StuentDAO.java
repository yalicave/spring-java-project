package com.newswathi.dao;

import java.sql.SQLException;
import java.util.List;

import com.newswathi.Student;

public interface StuentDAO {

	List<Student> find();

	void insert(Student student) throws SQLException;

}