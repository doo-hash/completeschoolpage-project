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

import com.mockpage.schoolwebapp.schoolpage.home.model.Admin;
import com.mockpage.schoolwebapp.schoolpage.home.model.Adminupdate;
import com.mockpage.schoolwebapp.schoolpage.home.service.AdminServiceClient;
import com.mockpage.schoolwebapp.schoolpage.home.validator.CaptchaValidator;

@Controller
@RequestMapping("/home")
public class AdminClientController {
	
	@Autowired
	private AdminServiceClient adminservice;
	
	@Autowired
	private CaptchaValidator captchavalidator;
	
	@GetMapping("/admin")
	public String adminform(Model model) {
		model.addAttribute("admin", new Admin());
		return "admin_form";
	}
	
	@PostMapping("/admin/add_admin")
	public String adminCheck(			
			@RequestParam("g-recaptcha-response") String captcha,
			@Valid @ModelAttribute("admin") Admin admin,
			BindingResult result, 
			Model model) {
		
		if(result.hasErrors()) {
			if(!captchavalidator.isValidate(captcha)) {
				model.addAttribute("captchaerr", "Please validate before submit!");
			}
			return "admin_form";		
		}
		if(admin.getAdminId() == null || 
				admin.getFirstName() == null || 
				admin.getLastName() == null ||
				admin.getEmail() == null
				) {
			throw new NullPointerException("No Value Present");
		}

		boolean isadminid = adminservice.existsByAdminId(admin.getAdminId());
		boolean isfname = adminservice.existsByFirstName(admin.getFirstName());
		boolean islname = adminservice.existsByLastName(admin.getLastName());
		boolean isemail = adminservice.existsByEmail(admin.getEmail());
		
		if(captchavalidator.isValidate(captcha)) {
			if(isadminid || isfname || islname || isemail) {
				if(isadminid) {
					model.addAttribute("adminidmsg","already exists!!");
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
				if(isadminid && isfname) {
					model.addAttribute("adminidmsg","already exists!!");
					model.addAttribute("fnamemsg","already exists!!");
				}
				if(isadminid && islname) {
					model.addAttribute("adminidmsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
				}
				if(isadminid && isemail) {
					model.addAttribute("adminidmsg","already exists!!");
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
				if(isadminid && isfname && islname) {
					model.addAttribute("adminidmsg","already exists!!");
					model.addAttribute("fnamemsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
				}
				if(isadminid && isfname && isemail) {
					model.addAttribute("adminidmsg","already exists!!");
					model.addAttribute("fnamemsg","already exists!!");
					model.addAttribute("emailmsg","already exists!!");
				}
				if(isadminid && isemail && islname) {
					model.addAttribute("adminidmsg","already exists!!");
					model.addAttribute("emailmsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
				}
				if(isemail && isfname && islname) {
					model.addAttribute("emailmsg","already exists!!");
					model.addAttribute("fnamemsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
				}	
				if(isadminid && isfname && islname && isemail) {
					model.addAttribute("adminidmsg","already exists!!");
					model.addAttribute("fnamemsg","already exists!!");
					model.addAttribute("lnamemsg","already exists!!");
					model.addAttribute("emailmsg","already exists!!");
				}
			}
			else {
				
				adminservice.addAdmin(admin);
				model.addAttribute("admin",new Admin());
				model.addAttribute("message", "You have successfully registered!!");
			}
		}
		else {
			model.addAttribute("captchaerr","Please validate before you submit!!");
		}
		
		return "admin_form";
	}
	

	@GetMapping("/admin/{adminid}/admin_logout")
	public String adminLogout() {
		return "redirect:/home/login";
	}
	
	@PostMapping("/admin/{adminid}/update")
	public String adminUpdate(@PathVariable String adminid,
			@Valid @ModelAttribute("presentadmin") Adminupdate adminupdate,
			BindingResult result, 
			Model model) {
		if(result.hasErrors()) {
			return "adminedit";
		}
		String firstName = adminupdate.getFirstName(); 
		String lastName = adminupdate.getLastName(); 
		
		boolean isfirstname = false; 
		boolean islastname = false;
				
		Admin existingadmin = adminservice.getAdmin(adminid);
		List<Admin> alladmin = adminservice.findAll(); 
		List<Admin> remainingadmins = new ArrayList<>();
		
		for (Admin adminobj : alladmin) { 
			if(!existingadmin.toString().equals(adminobj.toString())) {
				remainingadmins.add(adminobj);
			} 
		} 
		
		for(Admin adminobj : remainingadmins) {
			if(firstName.equals(adminobj.getFirstName().toString())) { 
				isfirstname = true; 
			} 
			if(lastName.equals(adminobj.getLastName().toString())) { 
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
			adminservice.updateAdmin(adminupdate);	
			model.addAttribute("admin", adminupdate); 
			model.addAttribute("message","Your account has been updated!!");
		}
		return "adminedit";
	}

	@GetMapping("/admin/{id}/portal")
	public String adminPortal(@PathVariable String id, Model model) {
		Admin admin = adminservice.getAdmin(id);
		model.addAttribute("admin",admin);
		return "admin_portal";
	}	

	@GetMapping("/admin/{adminId}/notifications")
	public String adminNotifications(@PathVariable String adminId, Model model) {
		Admin user = adminservice.getAdmin(adminId);
		model.addAttribute("title","Admin Portal");
		model.addAttribute("userrole", "admin");
		model.addAttribute("userid", adminId);
		model.addAttribute("username", user.getFirstName());
		return "notifications";
	}

	@GetMapping("/admin/{adminId}/settings")
	public String adminSettings(@PathVariable String adminId,Model model) {
		model.addAttribute("title","Admin Portal");
		model.addAttribute("userrole", "admin");
		model.addAttribute("userid", adminId);
		return "settings";
	}

	@GetMapping("/admin/{adminId}/edit")
	public String editadmin(@PathVariable String adminId,
			Model model) {
		Admin admin = adminservice.getAdmin(adminId);
		Adminupdate presentadmin = new Adminupdate();
		presentadmin.setId(admin.getId());
		presentadmin.setAdminId(adminId);
		presentadmin.setDesignation(admin.getDesignation());
		presentadmin.setFirstName(admin.getFirstName());
		presentadmin.setLastName(admin.getLastName());
		presentadmin.setEmail(admin.getEmail());
		presentadmin.setEducation(admin.getEducation());
		presentadmin.setWork_experience(admin.getWork_experience());
		model.addAttribute("presentadmin",presentadmin);
		return "adminedit";
	}
	
	@GetMapping("/admin/{adminId}/remove")
	public String deleteadmin(@PathVariable String adminId,
			Model model) {
		adminservice.deleteAdmin(adminId);
		model.addAttribute("message","This account has been deleted!! Sign up to know more!!");
		model.addAttribute("admin",new Admin());
		return "admin_form";
	}
}
