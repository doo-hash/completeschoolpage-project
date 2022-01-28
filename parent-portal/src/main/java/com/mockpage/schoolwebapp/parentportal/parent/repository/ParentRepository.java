package com.mockpage.schoolwebapp.parentportal.parent.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mockpage.schoolwebapp.parentportal.parent.model.Parent;

public interface ParentRepository extends CrudRepository<Parent,Long>{

	public Optional<Parent> findById(Long id);
	
	public Optional<Parent> findByFirstName(String firstName);
	public Optional<Parent> findByLastName(String lastName);
	public Optional<Parent> findByStudentName(String studentName);
	public Optional<Parent> findByEmail(String email);
	
	public boolean existsByStudentId(String StudentId);
	public boolean existsByFirstName(String firstName);
	public boolean existsByLastName(String lastName);
	public boolean existsByEmail(String email);
	public boolean existsByStudentName(String studentName);
	
	public Optional<Parent> findByStudentId(String studentId);
}