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

import com.mockpage.schoolwebapp.schoolpage.home.model.Parent;
import com.mockpage.schoolwebapp.schoolpage.home.model.Parentupdate;
import com.mockpage.schoolwebapp.schoolpage.home.service.ParentServiceClient;
import com.mockpage.schoolwebapp.schoolpage.home.validator.CaptchaValidator;


@Controller
@RequestMapping("/home")
public class ParentClientController {

	@Autowired
	private ParentServiceClient parentservice;
	
	@Autowired
	private CaptchaValidator captchavalidator;
	
	@GetMapping("/parent")
	public String parentform(Model model) {
		model.addAttribute("parent", new Parent());
		return "parent_form";
	}
	
	@PostMapping("/parent/add_parent")
	public String parentSubmit(
			@RequestParam("g-recaptcha-response") String captcha,
			@ModelAttribute("parent") Parent parent,
			BindingResult result, 
			Model model){
		
		if(result.hasErrors()) {
			if(!captchavalidator.isValidate(captcha)) {
				model.addAttribute("captchaerr", "Please validate before submit!");
			}
				return "parent_form";
		}
		boolean isstudentid = parentservice.existsByStudentId(parent.getStudentId());
		boolean isfname = parentservice.existsByFirstName(parent.getFirstName());
		boolean islname = parentservice.existsByLastName(parent.getLastName());
		boolean issname = parentservice.existsByStudentName(parent.getStudentName());
		boolean isemail = parentservice.existsByEmail(parent.getEmail());			
		if(captchavalidator.isValidate(captcha)) {
			if(isstudentid || isfname || islname || issname || isemail) {
				if(isstudentid) {
					model.addAttribute("studentidmsg","already exists!!");
				}
				if(isfname) {
					model.addAttribute("fnamemsg","already exists!!");
				}
				if(islname) {
					model.addAttribute("lnamemsg","already exists!!");
				}
				if(issname) {
					model.addAttribute("snamemsg","already exists!!");
				}
				if(isemail) {
					model.addAttribute("emailmsg","already exists!!");
				}
				
				if(isstudentid && isfname) {
					model.addAttribute("studentidmsg","already exists!!");
					model.addAttribute("fnamemsg","already exists!!");
				}
				if(isstudentid && islname) {
					model.addAttribute("studentidmsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
				}
				if(isstudentid && issname) {
					model.addAttribute("studentidmsg","already exists!!");
					model.addAttribute("snamemsg","already exists!!");
				}
				if(isstudentid && isemail) {
					model.addAttribute("studentidmsg","already exists!!");
					model.addAttribute("emailmsg","already exists!!");
				}
				if(isfname && islname) {
					model.addAttribute("fnamemsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
				}
				if(isfname && issname) {
					model.addAttribute("fnamemsg","already exists!!");
					model.addAttribute("snamemsg","already exists!!");
				}
				if(isemail && isfname) {
					model.addAttribute("emailmsg","already exists!!");
					model.addAttribute("fnamemsg","already exists!!");
				}
				if(islname && issname) {
					model.addAttribute("lnamemsg","already exists!!");
					model.addAttribute("snamemsg","already exists!!");
				}
				if(isemail && islname) {
					model.addAttribute("emailmsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
				}
				if(isemail && issname) {
					model.addAttribute("emailmsg","already exists!!");
					model.addAttribute("snamemsg","already exists!!");
				}
				
				if(isstudentid && isfname && islname) {
					model.addAttribute("studentidmsg","already exists!!");
					model.addAttribute("fnamemsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
				}
				if(isstudentid && isfname && issname) {
					model.addAttribute("studentidmsg","already exists!!");
					model.addAttribute("fnamemsg","already exists!!");
					model.addAttribute("snamemsg","already exists!!");
				}
				if(isstudentid && issname && islname) {
					model.addAttribute("studentidmsg","already exists!!");
					model.addAttribute("snamemsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
				}
				if(isstudentid && isfname && isemail) {
					model.addAttribute("studentidmsg","already exists!!");
					model.addAttribute("fnamemsg","already exists!!");
					model.addAttribute("emailmsg","already exists!!");
				}
				if(isstudentid && issname && isemail) {
					model.addAttribute("studentidmsg","already exists!!");
					model.addAttribute("snamemsg","already exists!!");
					model.addAttribute("emailmsg","already exists!!");
				}
				if(isstudentid && isemail && islname) {
					model.addAttribute("studentidmsg","already exists!!");
					model.addAttribute("emailmsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
				}
				if(isemail && isfname && islname) {
					model.addAttribute("emailmsg","already exists!!");
					model.addAttribute("fnamemsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
				}
				if(isemail && isfname && issname) {
					model.addAttribute("emailmsg","already exists!!");
					model.addAttribute("fnamemsg","already exists!!");
					model.addAttribute("snamemsg","already exists!!");
				}
				if(isemail && issname && islname) {
					model.addAttribute("emailmsg","already exists!!");
					model.addAttribute("snamemsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
				}
				if(isstudentid && isfname && islname && isemail) {
					model.addAttribute("studentidmsg","already exists!!");
					model.addAttribute("fnamemsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
					model.addAttribute("emailmsg","already exists!!");
				}
				if(isstudentid && isfname && issname && isemail) {
					model.addAttribute("studentidmsg","already exists!!");
					model.addAttribute("fnamemsg","already exists!!");
					model.addAttribute("snamemsg","already exists!!");
					model.addAttribute("emailmsg","already exists!!");
				}
				if(isstudentid && issname && islname && isemail) {
					model.addAttribute("studentidmsg","already exists!!");
					model.addAttribute("snamemsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
					model.addAttribute("emailmsg","already exists!!");
				}
				if(isstudentid && isfname && islname && issname) {
					model.addAttribute("studentidmsg","already exists!!");
					model.addAttribute("fnamemsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
					model.addAttribute("snamemsg","already exists!!");
				}
				if(isstudentid && isfname && islname && issname && isemail) {
					model.addAttribute("studentidmsg","already exists!!");
					model.addAttribute("fnamemsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
					model.addAttribute("snamemsg","already exists!!");
					model.addAttribute("emailmsg","already exists!!");
				}
			}
			else {
				parentservice.addParent(parent);
				model.addAttribute("parent",new Parent());
				model.addAttribute("message", "You have successfully registered!!");
			}
		}
		else {
			model.addAttribute("captchaerr","Please validate before you submit!!");
		}
		return "parent_form";
	}
	
	
	
	@GetMapping("/parent/{id}/portal")
	public String parentPortal(@PathVariable String id, Model model) {
		Parent parent = parentservice.getParent(id);
		model.addAttribute("parent",parent);
		return "parent_portal";
	}
	
	
	@GetMapping("/parent/{studentId}/edit")
	public String editParent(@PathVariable String studentId,
			Model model) {
		Parent parent = parentservice.getParent(studentId);
		Parentupdate presentparent = new Parentupdate();
		presentparent.setId(parent.getId());
		presentparent.setStudentId(studentId);
		presentparent.setFirstName(parent.getFirstName());
		presentparent.setLastName(parent.getLastName());
		presentparent.setEmail(parent.getEmail());
		presentparent.setStudentName(parent.getStudentName());
		model.addAttribute("presentparent",presentparent);
		return "parentedit";
	}
	
	@PostMapping("/parent/{studentid}/update")
	public String parentUpdate(@PathVariable String studentid,
			@Valid @ModelAttribute("presentparent") Parentupdate parentupdate,
			BindingResult result, 
			Model model) {
		if(result.hasErrors()) {
			return "parentedit";
		}
		String firstName = parentupdate.getFirstName(); 
		String lastName = parentupdate.getLastName(); 		
		boolean isfirstname = false; 
		boolean islastname = false;
		Parent existingparent = parentservice.getParent(studentid);
		List<Parent> allparent = parentservice.findAll(); 
		List<Parent> remainingparents = new ArrayList<>();
		
		for (Parent parentobj : allparent) { 
			if(!existingparent.toString().equals(parentobj.toString())) {
				remainingparents.add(parentobj);
			} 
		} 
		for(Parent parentobj : remainingparents) {
			if(firstName.equals(parentobj.getFirstName().toString())) { 
				isfirstname = true; 
			} 
			if(lastName.equals(parentobj.getLastName().toString())) { 
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
			parentservice.updateParent(parentupdate);	
			model.addAttribute("parent", parentupdate); 
			model.addAttribute("message","Your account has been updated!!");
		}
		return "parentedit";
	}

	@GetMapping("/parent/{studentId}/notifications")
	public String parentNotifications(@PathVariable String studentId, Model model) {
		Parent user = parentservice.getParent(studentId);
		model.addAttribute("title","Parent Portal");
		model.addAttribute("userrole", "parent");
		model.addAttribute("userid", studentId);
		model.addAttribute("username", user.getFirstName());
		return "notifications";
	}

	@GetMapping("/parent/{studentId}/settings")
	public String parentSettings(@PathVariable String studentId,Model model) {
		model.addAttribute("title","Parent Portal");		
		model.addAttribute("userrole", "parent");
		model.addAttribute("userid", studentId);
		return "settings";
	}
	
	@GetMapping("/parent/{studentId}/remove")
	public String deleteParent(@PathVariable String studentId,
			Model model) {
		parentservice.deleteParent(studentId);
		model.addAttribute("message","This account has been deleted!! Sign up to know more!!");
		model.addAttribute("parent",new Parent());
		return "parent_form";
	}

	
	@GetMapping("/parent/{studentid}/parent_logout")
	public String parentLogout() {
		return "redirect:/home/login";
	}
}
