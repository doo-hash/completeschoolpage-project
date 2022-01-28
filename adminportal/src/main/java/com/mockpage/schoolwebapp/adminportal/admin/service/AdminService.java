package com.mockpage.schoolwebapp.adminportal.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mockpage.schoolwebapp.adminportal.admin.model.Admin;
import com.mockpage.schoolwebapp.adminportal.admin.model.Adminupdate;

@Service
public interface AdminService {

	public Admin findByAdminId(String adminId);
	public Admin findById(Long Id);
	public Admin findByFirstName(String firstName);
	public Admin findByLastName(String lastName);
	public Admin findByEmail(String email);
	
	public boolean existsByAdminId(String adminId);
	public boolean existsByFirstName(String firstName);
	public boolean existsByLastName(String lastName);
	public boolean existsByEmail(String email);
	
	public void deleteById(Long id);
	public Admin save(Admin admin);
	public Admin update(Long id,Adminupdate adminupdate);
	
	public List<Admin> findall();
}
