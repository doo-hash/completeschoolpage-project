package com.mockpage.schoolwebapp.adminportal.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mockpage.schoolwebapp.adminportal.admin.model.Admin;
import com.mockpage.schoolwebapp.adminportal.admin.model.Adminupdate;
import com.mockpage.schoolwebapp.adminportal.admin.service.AdminService;

@Controller
public class AdminControllerClient {

	@Autowired
	AdminService adminservice;
			  
	@GetMapping("/admin") 
	public ResponseEntity<List<Admin>> allAdmin() { 
		List<Admin> alladmin = adminservice.findall();
		if(alladmin != null) {
			return new ResponseEntity<>(alladmin,HttpStatus.OK); 
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/admin/add_admin") 
	public ResponseEntity<Admin> adminSubmit(@RequestBody Admin admin) { 
		
		/*
		 * boolean isadminid = adminservice.existsByAdminId(admin.getAdminId()); boolean
		 * isfname = adminservice.existsByFirstName(admin.getFirstName()); boolean
		 * islname = adminservice.existsByLastName(admin.getLastName()); boolean isemail
		 * = adminservice.existsByEmail(admin.getEmail()); String result = "";
		 * 
		 * if(isadminid || isfname || islname || isemail) { if(isadminid) { result =
		 * "adminid"; } if(isfname) { result = "firstname"; } if(islname) { result =
		 * "lastname"; } if(isemail) { result = "email"; }
		 * 
		 * if(isadminid && isfname) { result = "adminid and firstname"; } if(isadminid
		 * && islname) { result = "adminid and lastname"; } if(isadminid && isemail) {
		 * result = "adminid and email"; } if(isfname && islname) { result =
		 * "firstname and lastname"; } if(isemail && isfname) { result =
		 * "email and firstname"; } if(isemail && islname) { result =
		 * "email and lastname"; }
		 * 
		 * 
		 * if(isadminid && isfname && islname) { result =
		 * "adminid, firstname and lastname"; } if(isadminid && isfname && isemail) {
		 * result = "adminid, firstname and email"; } if(isadminid && isemail &&
		 * islname) { result = "adminid, lastname and email"; } if(isemail && isfname &&
		 * islname) { result = "firstname, lastname and email"; }
		 * 
		 * if(isadminid && isfname && islname && isemail) { result =
		 * "adminid, firstname, lastname and email"; }
		 * 
		 * return new ResponseEntity<String>(result, HttpStatus.OK); }
		 */		 
		adminservice.save(admin);
		return new ResponseEntity<Admin>(adminservice.findByAdminId(admin.getAdminId()), HttpStatus.OK);
	}

	
	@GetMapping("/admin/{id}") 
	public ResponseEntity<Admin> getAdmin(@PathVariable String id) { 
		if(adminservice.existsByAdminId(id)) {
			Admin admin = adminservice.findByAdminId(id);
			return new ResponseEntity<Admin>(admin, HttpStatus.OK); 
		}
		return new ResponseEntity<Admin>(HttpStatus.NO_CONTENT); 
	}
	
	@GetMapping("/admin/getbyadminid/{adminid}") 
	public ResponseEntity<Admin> getAdminByadminId(@PathVariable String adminid) { 
		if(adminservice.existsByAdminId(adminid)) {
			Admin admin = adminservice.findByAdminId(adminid);
			return new ResponseEntity<Admin>(admin, HttpStatus.OK); 
		}
		return new ResponseEntity<Admin>(HttpStatus.NO_CONTENT); 
	}
	
	@GetMapping("/admin/getbyfname/{firstName}") 
	public ResponseEntity<Admin> getAdminByfirstName(@PathVariable String firstName) { 
		if(adminservice.existsByFirstName(firstName)) {
			Admin admin = adminservice.findByFirstName(firstName);
			return new ResponseEntity<Admin>(admin, HttpStatus.OK); 
		}
		return new ResponseEntity<Admin>(HttpStatus.NO_CONTENT); 
	}
	
	@GetMapping("/admin/getbylname/{lastName}") 
	public ResponseEntity<Admin> getAdminBylastName(@PathVariable String lastName) { 
		if(adminservice.existsByLastName(lastName)) {
			Admin admin = adminservice.findByLastName(lastName);
			return new ResponseEntity<Admin>(admin, HttpStatus.OK); 
		}
		return new ResponseEntity<Admin>(HttpStatus.NO_CONTENT); 
	}
	
	@GetMapping("/admin/getbyemail/{email}") 
	public ResponseEntity<Admin> getAdminByemail(@PathVariable String email) { 
		if(adminservice.existsByEmail(email)) {
			Admin admin = adminservice.findByEmail(email);
			return new ResponseEntity<Admin>(admin, HttpStatus.OK); 
		}
		return new ResponseEntity<Admin>(HttpStatus.NO_CONTENT); 
	}
	
	@PostMapping("/admin/update_admin") 
	public ResponseEntity<Admin> adminUpdate(@RequestBody Adminupdate adminupdate) { 
		
		/*
		 * String firstName = admin.getFirstName(); String lastName =
		 * admin.getLastName(); String result = ""; Admin updateadmin = null; boolean
		 * isfirstname = false; boolean islastname = false;
		 * 
		 * List<Admin> alladmin = adminservice.findall(); List<Admin> remainingadmins =
		 * new ArrayList<>();
		 * 
		 * for (Admin adminobj : alladmin) { if(adminobj !=
		 * adminservice.findByAdminId(admin.getAdminId())) {
		 * remainingadmins.add(adminobj); } } for (Admin adminobj : remainingadmins) {
		 * if(firstName.equals(adminobj.getFirstName().toString())) { isfirstname =
		 * true; } if(lastName.equals(adminobj.getLastName().toString())) { islastname =
		 * true; } } if(isfirstname || islastname) { if(isfirstname) { result =
		 * "firstname"; } if(islastname) { result = "lastname"; } if(isfirstname &&
		 * islastname) { result = "firstname and lastname"; } return new
		 * ResponseEntity<String>(result,HttpStatus.OK); }
		 */
		System.out.println(adminupdate); 
		Long id = adminservice.findByAdminId(adminupdate.getAdminId()).getId();
		Admin updateadmin = adminservice.update(id,adminupdate);
		return new ResponseEntity<Admin>(updateadmin, HttpStatus.OK);					
	}

	@GetMapping("/admin/{adminId}/remove") 
	public ResponseEntity<Admin> deleteAdmin(@PathVariable String adminId) { 
		Admin admin = adminservice.findByAdminId(adminId);
		System.out.println(admin);
		adminservice.deleteById(admin.getId());
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
