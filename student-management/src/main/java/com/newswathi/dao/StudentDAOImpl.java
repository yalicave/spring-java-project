package com.newswathi.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	
	@Autowired
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
