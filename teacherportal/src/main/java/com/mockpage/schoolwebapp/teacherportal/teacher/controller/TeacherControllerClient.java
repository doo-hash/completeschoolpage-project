package com.mockpage.schoolwebapp.teacherportal.teacher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mockpage.schoolwebapp.teacherportal.teacher.model.Teacher;
import com.mockpage.schoolwebapp.teacherportal.teacher.model.Teacherupdate;
import com.mockpage.schoolwebapp.teacherportal.teacher.service.TeacherService;

@Controller
public class TeacherControllerClient {
	
	@Autowired
	private TeacherService teacherservice;
	
	@GetMapping("/teacher") 
	public ResponseEntity<List<Teacher>> allTeacher() { 
		List<Teacher> allTeacher = teacherservice.findall();
		if(allTeacher != null) {
			return new ResponseEntity<>(allTeacher,HttpStatus.OK); 
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/teacher/add_teacher") 
	public ResponseEntity<Teacher> teacherSubmit(@RequestBody Teacher teacher) { 
		
		/*
		 * boolean isTeacherid = Teacherservice.existsByTeacherId(Teacher.getTeacherId()); boolean
		 * isfname = Teacherservice.existsByFirstName(Teacher.getFirstName()); boolean
		 * islname = Teacherservice.existsByLastName(Teacher.getLastName()); boolean isemail
		 * = Teacherservice.existsByEmail(Teacher.getEmail()); String result = "";
		 * 
		 * if(isTeacherid || isfname || islname || isemail) { if(isTeacherid) { result =
		 * "Teacherid"; } if(isfname) { result = "firstname"; } if(islname) { result =
		 * "lastname"; } if(isemail) { result = "email"; }
		 * 
		 * if(isTeacherid && isfname) { result = "Teacherid and firstname"; } if(isTeacherid
		 * && islname) { result = "Teacherid and lastname"; } if(isTeacherid && isemail) {
		 * result = "Teacherid and email"; } if(isfname && islname) { result =
		 * "firstname and lastname"; } if(isemail && isfname) { result =
		 * "email and firstname"; } if(isemail && islname) { result =
		 * "email and lastname"; }
		 * 
		 * 
		 * if(isTeacherid && isfname && islname) { result =
		 * "Teacherid, firstname and lastname"; } if(isTeacherid && isfname && isemail) {
		 * result = "Teacherid, firstname and email"; } if(isTeacherid && isemail &&
		 * islname) { result = "Teacherid, lastname and email"; } if(isemail && isfname &&
		 * islname) { result = "firstname, lastname and email"; }
		 * 
		 * if(isTeacherid && isfname && islname && isemail) { result =
		 * "Teacherid, firstname, lastname and email"; }
		 * 
		 * return new ResponseEntity<String>(result, HttpStatus.OK); }
		 */		 
		teacherservice.save(teacher);
		return new ResponseEntity<Teacher>(teacherservice.findByTeacherId(teacher.getTeacherId()), HttpStatus.OK);
	}

	
	@GetMapping("/teacher/{id}") 
	public ResponseEntity<Teacher> getTeacher(@PathVariable String id) { 
		if(teacherservice.existsByTeacherId(id)) {
			Teacher teacher = teacherservice.findByTeacherId(id);
			return new ResponseEntity<Teacher>(teacher, HttpStatus.OK); 
		}
		return new ResponseEntity<Teacher>(HttpStatus.NO_CONTENT); 
	}
	
	@GetMapping("/teacher/getbyteacherid/{teacherid}") 
	public ResponseEntity<Teacher> getTeacherByTeacherId(@PathVariable String teacherid) { 
		if(teacherservice.existsByTeacherId(teacherid)) {
			Teacher teacher = teacherservice.findByTeacherId(teacherid);
			return new ResponseEntity<Teacher>(teacher, HttpStatus.OK); 
		}
		return new ResponseEntity<Teacher>(HttpStatus.NO_CONTENT); 
	}
	
	@GetMapping("/teacher/getbyfname/{firstName}") 
	public ResponseEntity<Teacher> getTeacherByfirstName(@PathVariable String firstName) { 
		if(teacherservice.existsByFirstName(firstName)) {
			Teacher teacher = teacherservice.findByFirstName(firstName);
			return new ResponseEntity<Teacher>(teacher, HttpStatus.OK); 
		}
		return new ResponseEntity<Teacher>(HttpStatus.NO_CONTENT); 
	}
	
	@GetMapping("/teacher/getbylname/{lastName}") 
	public ResponseEntity<Teacher> getTeacherBylastName(@PathVariable String lastName) { 
		if(teacherservice.existsByLastName(lastName)) {
			Teacher teacher = teacherservice.findByLastName(lastName);
			return new ResponseEntity<Teacher>(teacher, HttpStatus.OK); 
		}
		return new ResponseEntity<Teacher>(HttpStatus.NO_CONTENT); 
	}
	
	@GetMapping("/teacher/getbyemail/{email}") 
	public ResponseEntity<Teacher> getTeacherByemail(@PathVariable String email) { 
		if(teacherservice.existsByEmail(email)) {
			Teacher teacher = teacherservice.findByEmail(email);
			return new ResponseEntity<Teacher>(teacher, HttpStatus.OK); 
		}
		return new ResponseEntity<Teacher>(HttpStatus.NO_CONTENT); 
	}
	
	@PostMapping("/teacher/update_teacher") 
	public ResponseEntity<Teacher> teacherUpdate(@RequestBody Teacherupdate teacherupdate) { 
		
		/*
		 * String firstName = Teacher.getFirstName(); String lastName =
		 * Teacher.getLastName(); String result = ""; Teacher updateTeacher = null; boolean
		 * isfirstname = false; boolean islastname = false;
		 * 
		 * List<Teacher> allTeacher = Teacherservice.findall(); List<Teacher> remainingTeachers =
		 * new ArrayList<>();
		 * 
		 * for (Teacher Teacherobj : allTeacher) { if(Teacherobj !=
		 * Teacherservice.findByTeacherId(Teacher.getTeacherId())) {
		 * remainingTeachers.add(Teacherobj); } } for (Teacher Teacherobj : remainingTeachers) {
		 * if(firstName.equals(Teacherobj.getFirstName().toString())) { isfirstname =
		 * true; } if(lastName.equals(Teacherobj.getLastName().toString())) { islastname =
		 * true; } } if(isfirstname || islastname) { if(isfirstname) { result =
		 * "firstname"; } if(islastname) { result = "lastname"; } if(isfirstname &&
		 * islastname) { result = "firstname and lastname"; } return new
		 * ResponseEntity<String>(result,HttpStatus.OK); }
		 */
		Long id = teacherservice.findByTeacherId(teacherupdate.getTeacherId()).getId();
		Teacher updateTeacher = teacherservice.update(id,teacherupdate);
		return new ResponseEntity<Teacher>(updateTeacher, HttpStatus.OK);					
	}

	@GetMapping("/teacher/{teacherId}/remove") 
	public ResponseEntity<Teacher> deleteTeacher(@PathVariable String teacherId) { 
		Teacher teacher = teacherservice.findByTeacherId(teacherId);
		teacherservice.deleteById(teacher.getId());
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
