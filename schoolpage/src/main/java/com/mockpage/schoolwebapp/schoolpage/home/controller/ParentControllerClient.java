package com.mockpage.schoolwebapp.schoolpage.home.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mockpage.schoolwebapp.schoolpage.home.model.Parent;
import com.mockpage.schoolwebapp.schoolpage.home.model.Parentupdate;

@FeignClient(name= "ParentControllerClient", url= "http://localhost:8094")
public interface ParentControllerClient {
	
	@PostMapping("/parent/add_parent") 
	public Parent parentSubmit(@RequestBody Parent parent);

	@GetMapping("/parent") 
	public List<Parent> allParent();
	
	@GetMapping("/parent/{id}") 
	public Parent getParent(@PathVariable String id);
	
	@GetMapping("/parent/getbystudentid/{studentid}") 
	public Parent getParentBystudentId(@PathVariable String studentid);
	
	@GetMapping("/parent/getbyfname/{firstName}") 
	public Parent getParentByfirstName(@PathVariable String firstName);
	
	@GetMapping("/parent/getbylname/{lastName}") 
	public Parent getParentBylastName(@PathVariable String lastName);
	
	@GetMapping("/parent/getbyemail/{email}") 
	public Parent getParentByemail(@PathVariable String email);
	
	@PostMapping("/parent/update_parent") 
	public Parent parentUpdate(@RequestBody Parentupdate parentupdate);
	
	@GetMapping("/parent/{studentId}/remove") 
	public void deleteParent(@PathVariable String studentId);

	@GetMapping("/parent/getbysname/{studentName}") 
	public Parent getParentBystudentName(@PathVariable String studentName);
}
