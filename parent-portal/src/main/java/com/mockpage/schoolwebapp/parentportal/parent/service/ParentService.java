package com.mockpage.schoolwebapp.parentportal.parent.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mockpage.schoolwebapp.parentportal.parent.model.Parent;
import com.mockpage.schoolwebapp.parentportal.parent.model.Parentupdate;


@Service
public interface ParentService {

	public Parent findByStudentId(String studentId);
	public Parent findById(Long Id);
	public Parent findByFirstName(String firstName);
	public Parent findByLastName(String lastName);
	public Parent findByEmail(String email);
	public Parent findByStudentName(String studentName);
	
	public boolean existsByStudentId(String studentId);
	public boolean existsByFirstName(String firstName);
	public boolean existsByLastName(String lastName);
	public boolean existsByEmail(String email);
	public boolean existsByStudentName(String studentName);
	
	public void deleteById(Long id);
	public Parent save(Parent parent);
	public Parent update(Long id,Parentupdate parentupdate);
	
	public List<Parent> findall();
}
