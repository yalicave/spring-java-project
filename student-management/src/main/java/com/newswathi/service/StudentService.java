package com.newswathi.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.newswathi.Student;
import com.newswathi.dao.StudentDAOImpl;

@Service
@Transactional(value=TxType.REQUIRED)
@EnableTransactionManagement
public class StudentService {
	@Autowired
	private StudentDAOImpl studentDAOImpl;
	public List<Student> find() {
		return studentDAOImpl.find();
	}
	public void insert(Student student) {
		studentDAOImpl.insert(student);
	}
	public List<Student> findByName(String sname) {
		return studentDAOImpl.findByName(sname);
	
	}
}
