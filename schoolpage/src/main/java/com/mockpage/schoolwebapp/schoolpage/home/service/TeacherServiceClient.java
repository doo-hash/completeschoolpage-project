package com.mockpage.schoolwebapp.schoolpage.home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockpage.schoolwebapp.schoolpage.home.controller.TeacherControllerClient;
import com.mockpage.schoolwebapp.schoolpage.home.model.Teacher;
import com.mockpage.schoolwebapp.schoolpage.home.model.Teacherupdate;

@Service
public class TeacherServiceClient {

	@Autowired
	TeacherControllerClient teachercontroller;
	
	public List<Teacher> findAll(){
		List<Teacher> allteacher = teachercontroller.allTeacher();
		return allteacher;
	}
	
	public void addTeacher(Teacher teacher) {
		teachercontroller.teacherSubmit(teacher);
	}
	
	public Teacher getTeacher(String teacherId) {
		Teacher teacher = teachercontroller.getTeacher(teacherId);
		return teacher;
	}
	
	public void updateTeacher(Teacherupdate teacherupdate) {
		teachercontroller.teacherUpdate(teacherupdate);
	}
	
	public void deleteTeacher(String teacherId) {
		teachercontroller.deleteTeacher(teacherId);
	}
	
	public boolean existsByTeacherId(String teacherId) {
		Teacher teacher = teachercontroller.getTeacherByteacherId(teacherId);
		if(teacher == null) {
			return false;
		}
		return true;
	}
	
	public boolean existsByFirstName(String firstName) {
		Teacher teacher = teachercontroller.getTeacherByfirstName(firstName);
		if(teacher == null) {
			return false;
		}
		return true;
	}
	
	public boolean existsByLastName(String lastName) {
		Teacher teacher = teachercontroller.getTeacherBylastName(lastName);
		if(teacher == null) {
			return false;
		}
		return true;
	}
	
	public boolean existsByEmail(String email) {
		Teacher teacher = teachercontroller.getTeacherByemail(email);
		if(teacher == null) {
			return false;
		}
		return true;
	}
}
