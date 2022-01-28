package com.mockpage.schoolwebapp.parentportal.parent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mockpage.schoolwebapp.parentportal.parent.model.Parent;
import com.mockpage.schoolwebapp.parentportal.parent.model.Parentupdate;
import com.mockpage.schoolwebapp.parentportal.parent.repository.ParentRepository;

@Component
public class ParentServiceImpl implements ParentService{

	private final ParentRepository parentRepo;

	public ParentServiceImpl(ParentRepository parentRepo) {
		this.parentRepo = parentRepo;
	}
	
	@Override
	public Parent save(Parent parent) {
		parentRepo.save(parent);
		return parent;
	}

	@Override
	public Parent findById(Long id) {
		Parent parent = parentRepo.findById(id).get();
		return parent;
	}

	@Override
	public Parent findByStudentId(String studentId) {
		Parent parent = parentRepo.findByStudentId(studentId).get();
		return parent;
	}

	@Override
	public boolean existsByStudentId(String studentId) {
		boolean isparent = parentRepo.existsByStudentId(studentId);
		return isparent;
	}
	
	@Override
	public boolean existsByFirstName(String firstName) {
		boolean isparent = parentRepo.existsByFirstName(firstName);
		return isparent;
	}
			
	@Override
	public boolean existsByLastName(String lastName) {
		boolean isparent = parentRepo.existsByLastName(lastName);
		return isparent;
	}
	
	@Override
	public boolean existsByStudentName(String studentName) {
		boolean isparent = parentRepo.existsByStudentName(studentName);
		return isparent;
	}
	
	@Override
	public boolean existsByEmail(String email) {
		boolean isparent = parentRepo.existsByEmail(email);
		return isparent;
	}
	@Override
	public List<Parent> findall() {
		List<Parent> allparent = new ArrayList<>();
		parentRepo.findAll().forEach(allparent :: add);
		return allparent;
	}
	@Override
	public Parent update(Long id,Parentupdate newparent) {
		Parent oldparent = parentRepo.findById(id).get();
		
		oldparent.setFirstName(newparent.getFirstName());
		oldparent.setLastName(newparent.getLastName());
		oldparent.setEmail(newparent.getEmail());
		oldparent.setStudentId(newparent.getStudentId());
		oldparent.setStudentName(newparent.getStudentName());
		
		parentRepo.save(oldparent);
		return oldparent;
	}
	
	@Override
	public void deleteById(Long id) {
		parentRepo.deleteById(id);
	}


	@Override
	public Parent findByFirstName(String firstName) {
		Parent parent = parentRepo.findByFirstName(firstName).get();
		return parent;
	}


	@Override
	public Parent findByLastName(String lastName) {
		Parent parent = parentRepo.findByLastName(lastName).get();
		return parent;
	}

	@Override
	public Parent findByStudentName(String studentName) {
		Parent parent = parentRepo.findByStudentName(studentName).get();
		return parent;
	}
	
	@Override
	public Parent findByEmail(String email) {
		Parent parent = parentRepo.findByEmail(email).get();
		return parent;
	}

}
