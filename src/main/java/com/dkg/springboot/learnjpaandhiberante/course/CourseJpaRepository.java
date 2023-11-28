package com.dkg.springboot.learnjpaandhiberante.course;

import org.springframework.stereotype.Repository;

import com.dkg.springboot.learnjpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {
	
	@PersistenceContext  //instead of using @Autowired we use this for more specific
	private EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.merge(course); //to insert data to table
	}
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
	public void deleteById(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course); //first find and then remove
	}
}
