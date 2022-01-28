package com.mockpage.schoolwebapp.teacherportal.teacher.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mockpage.schoolwebapp.teacherportal.teacher.model.Teacher;


public interface TeacherRepository extends CrudRepository<Teacher,Long>{

	public Optional<Teacher> findById(Long id);
	
	public Optional<Teacher> findByFirstName(String firstName);
	public Optional<Teacher> findByLastName(String lastName);
	public Optional<Teacher> findByEmail(String email);
	
	public boolean existsByTeacherId(String teacherId);
	public boolean existsByFirstName(String firstName);
	public boolean existsByLastName(String lastName);
	public boolean existsByEmail(String email);
	
	public Optional<Teacher> findByTeacherId(String teacherId);
}