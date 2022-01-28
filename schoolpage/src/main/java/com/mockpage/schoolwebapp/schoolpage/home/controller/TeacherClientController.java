package com.mockpage.schoolwebapp.schoolpage.home.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mockpage.schoolwebapp.schoolpage.home.model.Teacher;
import com.mockpage.schoolwebapp.schoolpage.home.model.Teacherupdate;
import com.mockpage.schoolwebapp.schoolpage.home.service.TeacherServiceClient;
import com.mockpage.schoolwebapp.schoolpage.home.validator.CaptchaValidator;


@Controller
@RequestMapping("/home")
public class TeacherClientController {

	@Autowired
	private TeacherServiceClient teacherservice;
		
	@Autowired
	private CaptchaValidator captchavalidator;
	
	@GetMapping("/teacher")
	public String teacherform(Model model) {
		model.addAttribute("teacher", new Teacher());
		return "teacher_form";
	}
	
	@PostMapping("/teacher/add_teacher")
	public String teacherSubmit(			
			@RequestParam("g-recaptcha-response") String captcha,
			@Valid @ModelAttribute("teacher") Teacher teacher,
			BindingResult result, 
			Model model){

		if(result.hasErrors()) {
			if(!captchavalidator.isValidate(captcha)) {
				model.addAttribute("captchaerr", "Please validate before submit!");
			}
			return "teacher_form";
		}
		boolean isteacherid = teacherservice.existsByTeacherId(teacher.getTeacherId());
		boolean isfname = teacherservice.existsByFirstName(teacher.getFirstName());
		boolean islname = teacherservice.existsByLastName(teacher.getLastName());
		boolean isemail = teacherservice.existsByEmail(teacher.getEmail());
		
		if(captchavalidator.isValidate(captcha)) {			
			if(isteacherid || isfname || islname || isemail) {

				if(isteacherid) {
					model.addAttribute("teacheridmsg","already exists!!");
				}
				if(isfname) {
					model.addAttribute("fnamemsg","already exists!!");
				}
				if(islname) {
					model.addAttribute("lnamemsg","already exists!!");
				}
				if(isemail) {
					model.addAttribute("emailmsg","already exists!!");
				}
				
				if(isteacherid && isfname) {
					model.addAttribute("teacheridmsg","already exists!!");
					model.addAttribute("fnamemsg","already exists!!");
				}
				if(isteacherid && islname) {
					model.addAttribute("teacheridmsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
				}
				if(isteacherid && isemail) {
					model.addAttribute("teacheridmsg","already exists!!");
					model.addAttribute("emailmsg","already exists!!");
				}
				if(isfname && islname) {
					model.addAttribute("fnamemsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
				}
				if(isemail && isfname) {
					model.addAttribute("emailmsg","already exists!!");
					model.addAttribute("fnamemsg","already exists!!");
				}
				if(isemail && islname) {
					model.addAttribute("emailmsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
				}
				
				if(isteacherid && isfname && islname) {
					model.addAttribute("teacheridmsg","already exists!!");
					model.addAttribute("fnamemsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
				}
				if(isteacherid && isfname && isemail) {
					model.addAttribute("teacheridmsg","already exists!!");
					model.addAttribute("fnamemsg","already exists!!");
					model.addAttribute("emailmsg","already exists!!");
				}
				if(isteacherid && isemail && islname) {
					model.addAttribute("teacheridmsg","already exists!!");
					model.addAttribute("emailmsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
				}
				if(isemail && isfname && islname) {
					model.addAttribute("emailmsg","already exists!!");
					model.addAttribute("fnamemsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
				}
				
				if(isteacherid && isfname && islname && isemail) {
					model.addAttribute("teacheridmsg","already exists!!");
					model.addAttribute("fnamemsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
					model.addAttribute("emailmsg","already exists!!");
				}
			}
			else {
				teacherservice.addTeacher(teacher);
				model.addAttribute("teacher",new Teacher());
				model.addAttribute("message", "You have successfully registered!!");
			}
		}
		else {
			model.addAttribute("captchaerr","Please validate before you submit!!");
		}
		return "teacher_form";
	}


	
	@GetMapping("/teacher/{id}/portal")
	public String teacherPortal(@PathVariable String id, Model model) {
		Teacher teacher = teacherservice.getTeacher(id);
		model.addAttribute("teacher",teacher);
		return "teacher_portal";
	}

	
	@GetMapping("/teacher/{teacherId}/edit")
	public String editTeacher(@PathVariable String teacherId,
			Model model) {
		Teacher teacher = teacherservice.getTeacher(teacherId);
		Teacherupdate presentteacher = new Teacherupdate();
		presentteacher.setId(teacher.getId());
		presentteacher.setTeacherId(teacherId);
		presentteacher.setDesignation(teacher.getDesignation());
		presentteacher.setFirstName(teacher.getFirstName());
		presentteacher.setLastName(teacher.getLastName());
		presentteacher.setEmail(teacher.getEmail());
		presentteacher.setEducation(teacher.getEducation());
		presentteacher.setWork_experience(teacher.getWork_experience());
		model.addAttribute("presentteacher",presentteacher);
		return "teacheredit";
	}
	
	@PostMapping("/teacher/{teacherid}/update")
	public String teacherUpdate(@PathVariable String teacherid,
			@Valid @ModelAttribute("presentteacher") Teacherupdate teacherupdate,
			BindingResult result, 
			Model model) {
		if(result.hasErrors()) {
			return "teacheredit";
		}
		String firstName = teacherupdate.getFirstName(); 
		String lastName = teacherupdate.getLastName(); 
		
		boolean isfirstname = false; 
		boolean islastname = false;
				
		Teacher existingteacher = teacherservice.getTeacher(teacherid);
		List<Teacher> allteacher = teacherservice.findAll(); 
		List<Teacher> remainingteachers = new ArrayList<>();
		
		for (Teacher teacherobj : allteacher) { 
			if(!existingteacher.toString().equals(teacherobj.toString())) {
				remainingteachers.add(teacherobj);
			} 
		} 
		
		for(Teacher teacherobj : remainingteachers) {
			if(firstName.equals(teacherobj.getFirstName().toString())) { 
				isfirstname = true; 
			} 
			if(lastName.equals(teacherobj.getLastName().toString())) { 
				islastname = true; 
			} 
		} 
		
		if(isfirstname || islastname) { 
			if(isfirstname) { 
				model.addAttribute("fnamemsg", "First Name already exists!!"); 
			} 
			if(islastname) { 
				model.addAttribute("lnamemsg", "Last Name already exists!!");
			} 
			if(isfirstname && islastname) { 
				model.addAttribute("fnamemsg", "First Name already exists!!");
				model.addAttribute("lnamemsg", "Last Name already exists!!");
			}
		}
		else {
			teacherservice.updateTeacher(teacherupdate);	
			model.addAttribute("teacher", teacherupdate); 
			model.addAttribute("message","Your account has been updated!!");
		}
		return "teacheredit";
	}
	

	@GetMapping("/teacher/{teacherId}/notifications")
	public String teacherNotifications(@PathVariable String teacherId, Model model) {
		Teacher user = teacherservice.getTeacher(teacherId);
		model.addAttribute("title","Teacher Portal");
		model.addAttribute("userrole", "teacher");
		model.addAttribute("userid",teacherId);
		model.addAttribute("username", user.getFirstName());
		return "notifications";
	}

	@GetMapping("/teacher/{teacherId}/settings")
	public String teacherSettings(@PathVariable String teacherId,Model model) {
		model.addAttribute("title","Teacher Portal");
		model.addAttribute("userrole", "teacher");
		model.addAttribute("userid",teacherId);
		return "settings";
	}

	
	@GetMapping("/teacher/{teacherId}/remove")
	public String deleteTeacher(@PathVariable String teacherId,
			Model model) {
		teacherservice.deleteTeacher(teacherId);
		model.addAttribute("message","This account has been deleted!! Sign up to know more!!");
		model.addAttribute("teacher",new Teacher());
		return "teacher_form";
	}
	
	
	@GetMapping("/teacher/{teacherid}/teacher_logout")
	public String teacherLogout() {
		return "redirect:/home/login";
	}
}
