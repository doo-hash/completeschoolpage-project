package com.mockpage.schoolwebapp.schoolpage.home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockpage.schoolwebapp.schoolpage.home.controller.ParentControllerClient;
import com.mockpage.schoolwebapp.schoolpage.home.model.Parent;
import com.mockpage.schoolwebapp.schoolpage.home.model.Parentupdate;

@Service
public class ParentServiceClient {

	@Autowired
	ParentControllerClient parentcontroller;
	
	public List<Parent> findAll(){
		List<Parent> allparent = parentcontroller.allParent();
		return allparent;
	}
	public void addParent(Parent parent) {
		parentcontroller.parentSubmit(parent);
	}
	
	public Parent getParent(String studentId) {
		Parent parent = parentcontroller.getParent(studentId);
		return parent;
	}
	
	public void updateParent(Parentupdate parentupdate) {
		parentcontroller.parentUpdate(parentupdate);
	}
	
	public void deleteParent(String studentId) {
		parentcontroller.deleteParent(studentId);
	}
	
	public boolean existsByStudentId(String studentId) {
		Parent parent = parentcontroller.getParentBystudentId(studentId);
		if(parent == null) {
			return false;
		}
		return true;
	}
	
	public boolean existsByFirstName(String firstName) {
		Parent parent = parentcontroller.getParentByfirstName(firstName);
		if(parent == null) {
			return false;
		}
		return true;
	}
	
	public boolean existsByLastName(String lastName) {
		Parent parent = parentcontroller.getParentBylastName(lastName);
		if(parent == null) {
			return false;
		}
		return true;
	}
	
	public boolean existsByStudentName(String studentName) {
		Parent parent = parentcontroller.getParentBystudentName(studentName);
		if(parent == null) {
			return false;
		}
		return true;
	}
	
	public boolean existsByEmail(String email) {
		Parent parent = parentcontroller.getParentByemail(email);
		if(parent == null) {
			return false;
		}
		return true;
	}
}
