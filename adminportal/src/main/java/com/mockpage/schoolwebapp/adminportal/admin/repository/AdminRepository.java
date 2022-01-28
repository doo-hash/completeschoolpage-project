package com.mockpage.schoolwebapp.adminportal.admin.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mockpage.schoolwebapp.adminportal.admin.model.Admin;

public interface AdminRepository extends CrudRepository<Admin,Long>{

	public Optional<Admin> findById(Long id);
	public Optional<Admin> findByFirstName(String firstName);
	public Optional<Admin> findByLastName(String lastName);
	public Optional<Admin> findByEmail(String email);
	
	public boolean existsByAdminId(String adminId);
	public boolean existsByFirstName(String firstName);
	public boolean existsByLastName(String lastName);
	public boolean existsByEmail(String email);
	
	public Optional<Admin> findByAdminId(String adminId);
}