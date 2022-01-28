package com.mockpage.schoolwebapp.teacherportal.teacher.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mockpage.schoolwebapp.teacherportal.teacher.model.Teacher;
import com.mockpage.schoolwebapp.teacherportal.teacher.model.Teacherupdate;

@Service
public interface TeacherService {
	
	public Teacher findByTeacherId(String teacherId);
	public Teacher findById(Long Id);
	public Teacher findByFirstName(String firstName);
	public Teacher findByLastName(String lastName);
	public Teacher findByEmail(String email);
	
	public boolean existsByTeacherId(String teacherId);
	public boolean existsByFirstName(String firstName);
	public boolean existsByLastName(String lastName);
	public boolean existsByEmail(String email);
	
	public void deleteById(Long id);
	public Teacher save(Teacher teacher);
	public Teacher update(Long id,Teacherupdate teacherupdate);
	
	public List<Teacher> findall();
}
