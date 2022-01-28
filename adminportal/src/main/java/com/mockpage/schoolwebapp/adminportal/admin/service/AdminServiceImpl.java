package com.mockpage.schoolwebapp.adminportal.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mockpage.schoolwebapp.adminportal.admin.model.Admin;
import com.mockpage.schoolwebapp.adminportal.admin.model.Adminupdate;
import com.mockpage.schoolwebapp.adminportal.admin.repository.AdminRepository;

@Component
public class AdminServiceImpl implements AdminService{

	private final AdminRepository adminRepo;

	public AdminServiceImpl(AdminRepository adminRepo) {
		this.adminRepo = adminRepo;
	}


	@Override
	public Admin save(Admin admin) {
		adminRepo.save(admin);
		System.out.println(admin);
		return admin;
	}

	@Override
	public Admin findById(Long id) {
		Admin admin = adminRepo.findById(id).get();
		return admin;
	}

	@Override
	public Admin findByAdminId(String adminId) {
		Admin admin = adminRepo.findByAdminId(adminId).get();
		return admin;
	}

	@Override
	public boolean existsByAdminId(String adminId) {
		boolean isAdmin = adminRepo.existsByAdminId(adminId);
		return isAdmin;
	}
	
	@Override
	public boolean existsByFirstName(String firstName) {
		boolean isAdmin = adminRepo.existsByFirstName(firstName);
		return isAdmin;
	}
			
	@Override
	public boolean existsByLastName(String lastName) {
		boolean isAdmin = adminRepo.existsByLastName(lastName);
		return isAdmin;
	}
	
	@Override
	public boolean existsByEmail(String email) {
		boolean isAdmin = adminRepo.existsByEmail(email);
		return isAdmin;
	}
	@Override
	public List<Admin> findall() {
		List<Admin> alladmin = new ArrayList<>();
		adminRepo.findAll().forEach(alladmin :: add);
		return alladmin;
	}
	@Override
	public Admin update(Long id,Adminupdate newadmin) {
		Admin oldadmin = adminRepo.findById(id).get();
		
		oldadmin.setFirstName(newadmin.getFirstName());
		oldadmin.setLastName(newadmin.getLastName());
		oldadmin.setEmail(newadmin.getEmail());
		oldadmin.setDesignation(newadmin.getDesignation());
		oldadmin.setEducation(newadmin.getEducation());
		oldadmin.setAdminId(newadmin.getAdminId());
		oldadmin.setWork_experience(newadmin.getWork_experience());

		adminRepo.save(oldadmin);
		return oldadmin;
	}
	
	@Override
	public void deleteById(Long id) {
		adminRepo.deleteById(id);
	}


	@Override
	public Admin findByFirstName(String firstName) {
		Admin admin = adminRepo.findByFirstName(firstName).get();
		return admin;
	}


	@Override
	public Admin findByLastName(String lastName) {
		Admin admin = adminRepo.findByLastName(lastName).get();
		return admin;
	}


	@Override
	public Admin findByEmail(String email) {
		Admin admin = adminRepo.findByEmail(email).get();
		return admin;
	}

}
