package com.mockpage.schoolwebapp.parentportal.parent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mockpage.schoolwebapp.parentportal.parent.model.Parent;
import com.mockpage.schoolwebapp.parentportal.parent.model.Parentupdate;
import com.mockpage.schoolwebapp.parentportal.parent.service.ParentService;

@Controller
public class ParentControllerClient {

	@Autowired
	ParentService parentservice;
		
	@GetMapping("/parent") 
	public ResponseEntity<List<Parent>> allParent() { 
		List<Parent> allparent = parentservice.findall();
		if(allparent != null) {
			return new ResponseEntity<>(allparent,HttpStatus.OK); 
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/parent/add_parent") 
	public ResponseEntity<Parent> parentSubmit(@RequestBody Parent parent) { 
		
		/*
		 * boolean isparentid = parentservice.existsByparentId(parent.getparentId()); boolean
		 * isfname = parentservice.existsByFirstName(parent.getFirstName()); boolean
		 * islname = parentservice.existsByLastName(parent.getLastName()); boolean isemail
		 * = parentservice.existsByEmail(parent.getEmail()); String result = "";
		 * 
		 * if(isparentid || isfname || islname || isemail) { if(isparentid) { result =
		 * "parentid"; } if(isfname) { result = "firstname"; } if(islname) { result =
		 * "lastname"; } if(isemail) { result = "email"; }
		 * 
		 * if(isparentid && isfname) { result = "parentid and firstname"; } if(isparentid
		 * && islname) { result = "parentid and lastname"; } if(isparentid && isemail) {
		 * result = "parentid and email"; } if(isfname && islname) { result =
		 * "firstname and lastname"; } if(isemail && isfname) { result =
		 * "email and firstname"; } if(isemail && islname) { result =
		 * "email and lastname"; }
		 * 
		 * 
		 * if(isparentid && isfname && islname) { result =
		 * "parentid, firstname and lastname"; } if(isparentid && isfname && isemail) {
		 * result = "parentid, firstname and email"; } if(isparentid && isemail &&
		 * islname) { result = "parentid, lastname and email"; } if(isemail && isfname &&
		 * islname) { result = "firstname, lastname and email"; }
		 * 
		 * if(isparentid && isfname && islname && isemail) { result =
		 * "parentid, firstname, lastname and email"; }
		 * 
		 * return new ResponseEntity<String>(result, HttpStatus.OK); }
		 */		 
		parentservice.save(parent);
		return new ResponseEntity<Parent>(parentservice.findByStudentId(parent.getStudentId()), HttpStatus.OK);
	}

	
	@GetMapping("/parent/{id}") 
	public ResponseEntity<Parent> getParent(@PathVariable String id) { 
		if(parentservice.existsByStudentId(id)) {
			Parent parent = parentservice.findByStudentId(id);
			return new ResponseEntity<Parent>(parent, HttpStatus.OK); 
		}
		return new ResponseEntity<Parent>(HttpStatus.NO_CONTENT); 
	}
	
	@GetMapping("/parent/getbystudentid/{studentid}") 
	public ResponseEntity<Parent> getParentByStudentId(@PathVariable String studentid) { 
		if(parentservice.existsByStudentId(studentid)) {
			Parent parent = parentservice.findByStudentId(studentid);
			return new ResponseEntity<Parent>(parent, HttpStatus.OK); 
		}
		return new ResponseEntity<Parent>(HttpStatus.NO_CONTENT); 
	}
	
	@GetMapping("/parent/getbyfname/{firstName}") 
	public ResponseEntity<Parent> getParentByfirstName(@PathVariable String firstName) { 
		if(parentservice.existsByFirstName(firstName)) {
			Parent parent = parentservice.findByFirstName(firstName);
			return new ResponseEntity<Parent>(parent, HttpStatus.OK); 
		}
		return new ResponseEntity<Parent>(HttpStatus.NO_CONTENT); 
	}
	
	@GetMapping("/parent/getbylname/{lastName}") 
	public ResponseEntity<Parent> getParentBylastName(@PathVariable String lastName) { 
		if(parentservice.existsByLastName(lastName)) {
			Parent parent = parentservice.findByLastName(lastName);
			return new ResponseEntity<Parent>(parent, HttpStatus.OK); 
		}
		return new ResponseEntity<Parent>(HttpStatus.NO_CONTENT); 
	}
	
	@GetMapping("/parent/getbysname/{studentName}") 
	public ResponseEntity<Parent> getParentBystudentName(@PathVariable String studentName) { 
		if(parentservice.existsByStudentName(studentName)) {
			Parent parent = parentservice.findByStudentName(studentName);
			return new ResponseEntity<Parent>(parent, HttpStatus.OK); 
		}
		return new ResponseEntity<Parent>(HttpStatus.NO_CONTENT); 
	}
	
	@GetMapping("/parent/getbyemail/{email}") 
	public ResponseEntity<Parent> getParentByemail(@PathVariable String email) { 
		if(parentservice.existsByEmail(email)) {
			Parent parent = parentservice.findByEmail(email);
			return new ResponseEntity<Parent>(parent, HttpStatus.OK); 
		}
		return new ResponseEntity<Parent>(HttpStatus.NO_CONTENT); 
	}
	
	@PostMapping("/parent/update_parent") 
	public ResponseEntity<Parent> parentUpdate(@RequestBody Parentupdate parentupdate) { 
		
		/*
		 * String firstName = parent.getFirstName(); String lastName =
		 * parent.getLastName(); String result = ""; parent updateparent = null; boolean
		 * isfirstname = false; boolean islastname = false;
		 * 
		 * List<parent> allparent = parentservice.findall(); List<parent> remainingparents =
		 * new ArrayList<>();
		 * 
		 * for (parent parentobj : allparent) { if(parentobj !=
		 * parentservice.findByparentId(parent.getparentId())) {
		 * remainingparents.add(parentobj); } } for (parent parentobj : remainingparents) {
		 * if(firstName.equals(parentobj.getFirstName().toString())) { isfirstname =
		 * true; } if(lastName.equals(parentobj.getLastName().toString())) { islastname =
		 * true; } } if(isfirstname || islastname) { if(isfirstname) { result =
		 * "firstname"; } if(islastname) { result = "lastname"; } if(isfirstname &&
		 * islastname) { result = "firstname and lastname"; } return new
		 * ResponseEntity<String>(result,HttpStatus.OK); }
		 */
		Long id = parentservice.findByStudentId(parentupdate.getStudentId()).getId();
		Parent updateparent = parentservice.update(id,parentupdate);
		return new ResponseEntity<Parent>(updateparent, HttpStatus.OK);					
	}

	@GetMapping("/parent/{studentId}/remove") 
	public ResponseEntity<Parent> deleteParent(@PathVariable String studentId) { 
		Parent parent = parentservice.findByStudentId(studentId);
		parentservice.deleteById(parent.getId());
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
