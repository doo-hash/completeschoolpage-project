package com.mockpage.schoolwebapp.teacherportal.teacher.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mockpage.schoolwebapp.teacherportal.teacher.model.Teacher;
import com.mockpage.schoolwebapp.teacherportal.teacher.model.Teacherupdate;
import com.mockpage.schoolwebapp.teacherportal.teacher.repository.TeacherRepository;

@Component
public class TeacherServiceImpl implements TeacherService {
	
	private final TeacherRepository teacherRepo;

	public TeacherServiceImpl(TeacherRepository teacherRepo) {
		this.teacherRepo = teacherRepo;
	}
	@Override
	public Teacher save(Teacher teacher) {
		teacherRepo.save(teacher);
		return teacher;
	}

	@Override
	public Teacher findById(Long id) {
		Teacher teacher = teacherRepo.findById(id).get();
		return teacher;
	}

	@Override
	public Teacher findByTeacherId(String teacherId) {
		Teacher teacher = teacherRepo.findByTeacherId(teacherId).get();
		return teacher;
	}

	@Override
	public boolean existsByTeacherId(String teacherId) {
		boolean isteacher = teacherRepo.existsByTeacherId(teacherId);
		return isteacher;
	}
	
	@Override
	public boolean existsByFirstName(String firstName) {
		boolean isteacher = teacherRepo.existsByFirstName(firstName);
		return isteacher;
	}
			
	@Override
	public boolean existsByLastName(String lastName) {
		boolean isteacher = teacherRepo.existsByLastName(lastName);
		return isteacher;
	}
	
	@Override
	public boolean existsByEmail(String email) {
		boolean isteacher = teacherRepo.existsByEmail(email);
		return isteacher;
	}
	
	@Override
	public List<Teacher> findall() {
		List<Teacher> allteacher = new ArrayList<>();
		teacherRepo.findAll().forEach(allteacher :: add);
		return allteacher;
	}
	
	@Override
	public Teacher update(Long id,Teacherupdate newteacher) {
		Teacher oldteacher = teacherRepo.findById(id).get();
		
		oldteacher.setFirstName(newteacher.getFirstName());
		oldteacher.setLastName(newteacher.getLastName());
		oldteacher.setEmail(newteacher.getEmail());
		oldteacher.setDesignation(newteacher.getDesignation());
		oldteacher.setEducation(newteacher.getEducation());
		oldteacher.setTeacherId(newteacher.getTeacherId());
		oldteacher.setWork_experience(newteacher.getWork_experience());

		teacherRepo.save(oldteacher);
		return oldteacher;
	}
	
	@Override
	public void deleteById(Long id) {
		teacherRepo.deleteById(id);
	}


	@Override
	public Teacher findByFirstName(String firstName) {
		Teacher teacher = teacherRepo.findByFirstName(firstName).get();
		return teacher;
	}


	@Override
	public Teacher findByLastName(String lastName) {
		Teacher teacher = teacherRepo.findByLastName(lastName).get();
		return teacher;
	}


	@Override
	public Teacher findByEmail(String email) {
		Teacher teacher = teacherRepo.findByEmail(email).get();
		return teacher;
	}
}
