package com.mockpage.schoolwebapp.schoolpage.home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockpage.schoolwebapp.schoolpage.home.controller.AdminControllerClient;
import com.mockpage.schoolwebapp.schoolpage.home.model.Admin;
import com.mockpage.schoolwebapp.schoolpage.home.model.Adminupdate;

@Service
public class AdminServiceClient {

	@Autowired
	AdminControllerClient admincontroller;
	
	public List<Admin> findAll(){
		List<Admin> alladmin = admincontroller.allAdmin();
		return alladmin;
	}
	public void addAdmin(Admin admin) {
		admincontroller.adminSubmit(admin);
	}
	
	public Admin getAdmin(String adminId) {
		Admin admin = admincontroller.getAdmin(adminId);
		return admin;
	}
	
	public void updateAdmin(Adminupdate adminupdate) {
		admincontroller.adminUpdate(adminupdate);
	}
	
	public void deleteAdmin(String adminId) {
		admincontroller.deleteAdmin(adminId);
	}
	
	public boolean existsByAdminId(String adminId) {
		Admin admin = admincontroller.getAdminByadminId(adminId);
		if(admin == null) {
			return false;
		}
		return true;
	}
	
	public boolean existsByFirstName(String firstName) {
		Admin admin = admincontroller.getAdminByfirstName(firstName);
		if(admin == null) {
			return false;
		}
		return true;
	}
	
	public boolean existsByLastName(String lastName) {
		Admin admin = admincontroller.getAdminBylastName(lastName);
		if(admin == null) {
			return false;
		}
		return true;
	}
	
	public boolean existsByEmail(String email) {
		Admin admin = admincontroller.getAdminByemail(email);
		if(admin == null) {
			return false;
		}
		return true;
	}
}
