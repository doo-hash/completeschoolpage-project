package com.mockpage.schoolwebapp.schoolpage.home.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mockpage.schoolwebapp.schoolpage.home.model.Admin;
import com.mockpage.schoolwebapp.schoolpage.home.model.Parent;
import com.mockpage.schoolwebapp.schoolpage.home.model.Teacher;
import com.mockpage.schoolwebapp.schoolpage.home.service.AdminServiceClient;
import com.mockpage.schoolwebapp.schoolpage.home.service.ParentServiceClient;
import com.mockpage.schoolwebapp.schoolpage.home.service.TeacherServiceClient;

@Controller
@RequestMapping("/home")
public class LoginController{

	@Autowired
	private AdminServiceClient adminservice;
	
	@Autowired
	private ParentServiceClient parentservice;
	
	@Autowired
	private TeacherServiceClient teacherservice;
	
	@GetMapping("/login")
	public String adminLogin() {
		return "login";
	}
	
	@PostMapping("/user/auth_user")
	public String validLogin(Model model,
			@Valid @RequestParam String username, 
			@Valid @RequestParam String password) {
		
		/*
		 * if(adminservice.getAdmin(username) == null ||
		 * parentservice.getParent(username) == null ||
		 * teacherservice.getTeacher(username) == null) {
		 * if(adminservice.getAdmin(username) == null) { throw new
		 * AdminNotFoundException("No Admin found with this id"); }
		 * if(parentservice.getParent(username) == null) { throw new
		 * StudentNotFoundException("No Parent found with this studentid"); }
		 * if(teacherservice.getTeacher(username) == null) { throw new
		 * TeacherNotFoundException("No Teacher found with this id"); }
		 * 
		 * }
		 */
		
		boolean adminuser = adminservice.existsByAdminId(username);
		boolean parentuser = parentservice.existsByStudentId(username);
		boolean teacheruser = teacherservice.existsByTeacherId(username);
		
		
		if(adminuser) {
			Admin admin = adminservice.getAdmin(username);
			if(password.equals(admin.getPassword())) {
				model.addAttribute(admin);
				String id = admin.getAdminId();
				return "redirect:/home/admin/"+id+"/portal";
			}
			else {
				model.addAttribute("errormsg","password is wrong");
				return "login";
			}
		}	
		 else if(parentuser){ 
			Parent parent = parentservice.getParent(username);
			if(password.equals(parent.getPassword())) { 
				model.addAttribute(parent);
				String id = parent.getStudentId(); 
				return "redirect:/home/parent/"+id+"/portal"; } 
			else {
				model.addAttribute("errormsg","password is wrong"); 
				return "login"; } } 
		 else if(teacheruser) { 
			 Teacher teacher = teacherservice.getTeacher(username);
			 if(password.equals(teacher.getPassword())) { 
				 model.addAttribute(teacher);
				 String id = teacher.getTeacherId(); 
				 return "redirect:/home/teacher/"+id+"/portal"; } 
			 else {
				 model.addAttribute("errormsg","password is wrong"); 
				 return "login"; } }		
		 else {
			model.addAttribute("usererr", "This account does not exist.");
			return "login";
		}
	}
}