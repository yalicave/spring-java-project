package com.newswathi.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.newswathi.Student;
import com.newswathi.entity.StudentEntity;

/**
 * 
 * @author swathianand
 * ORM impl of Student DAO
 */
@Repository("studentHibernateDAOImpl")
public class StudentDAOImpl implements StuentDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Student> find() {
		List<StudentEntity> result = entityManager.createQuery("SELECT s FROM StudentEntity s",StudentEntity.class).getResultList();
		List<Student> students= new ArrayList<Student>();
		for(StudentEntity se: result) {
			students.add(se.toStudent());
		}
		return students;
	}
	
	public void insert(Student student) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
