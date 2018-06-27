package com.newswathi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.newswathi.Student;
import com.newswathi.entity.StudentEntity;

/**
 * 
 * @author swathianand
 * ORM impl of Student DAOO
 */
@Repository("studentHibernateDAOImpl")
public class StudentDAOImpl implements StuentDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Student> find() {
		List<StudentEntity> result = entityManager.createQuery("FROM StudentEntity s",StudentEntity.class).getResultList();
		List<Student> students= new ArrayList<Student>();
		for(StudentEntity se: result) {
			students.add(se.toStudent());
		}
		return students;
	}
	public void insert(Student student){
		System.out.println("Calling insert");
		if(student==null) {
			throw new IllegalArgumentException("Not able to save the null value");
		}
		entityManager.persist(student.toStudentEntity());
		entityManager.flush();
	}
	public List<Student> findByName(String sname) {
		TypedQuery<StudentEntity> query = entityManager.createQuery("FROM StudentEntity s WHERE s.studName like CONCAT('%',:sname,'%')",StudentEntity.class);
		query.setParameter("sname", sname);
		List<StudentEntity> result = query.getResultList();
		List<Student> students= new ArrayList<Student>();
		for(StudentEntity se: result) {
			students.add(se.toStudent());
		}
		return students;
	}

}
