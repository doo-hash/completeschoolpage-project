package com.mockpage.schoolwebapp.schoolpage.home.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mockpage.schoolwebapp.schoolpage.home.model.Admin;
import com.mockpage.schoolwebapp.schoolpage.home.model.Adminupdate;

@FeignClient(name= "AdminControllerClient", url= "http://localhost:8090")
public interface AdminControllerClient {
	
	@PostMapping("/admin/add_admin") 
	public Admin adminSubmit(@RequestBody Admin admin);

	@GetMapping("/admin") 
	public List<Admin> allAdmin();
	
	@GetMapping("/admin/{id}") 
	public Admin getAdmin(@PathVariable String id);
	
	@GetMapping("/admin/getbyadminid/{adminid}") 
	public Admin getAdminByadminId(@PathVariable String adminid);
	
	@GetMapping("/admin/getbyfname/{firstName}") 
	public Admin getAdminByfirstName(@PathVariable String firstName);
	
	@GetMapping("/admin/getbylname/{lastName}") 
	public Admin getAdminBylastName(@PathVariable String lastName);
	
	@GetMapping("/admin/getbyemail/{email}") 
	public Admin getAdminByemail(@PathVariable String email);
	
	@PostMapping("/admin/update_admin") 
	public Admin adminUpdate(@RequestBody Adminupdate adminupdate);
	
	@GetMapping("/admin/{adminId}/remove") 
	public void deleteAdmin(@PathVariable String adminId);
}
