package com.newswathi;

import java.sql.SQLException;
import java.util.List;

public interface StuentDAO {

	List<Student> find();

	void insert(Student student) throws SQLException;

}