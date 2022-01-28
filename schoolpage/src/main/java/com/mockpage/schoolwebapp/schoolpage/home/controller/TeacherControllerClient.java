package com.mockpage.schoolwebapp.schoolpage.home.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mockpage.schoolwebapp.schoolpage.home.model.Teacher;
import com.mockpage.schoolwebapp.schoolpage.home.model.Teacherupdate;

@FeignClient(name= "TeacherControllerClient", url= "http://localhost:8086")
public interface TeacherControllerClient {
	
	@PostMapping("/teacher/add_teacher") 
	public Teacher teacherSubmit(@RequestBody Teacher teacher);

	@GetMapping("/teacher") 
	public List<Teacher> allTeacher();
	
	@GetMapping("/teacher/{id}") 
	public Teacher getTeacher(@PathVariable String id);
	
	@GetMapping("/teacher/getbyteacherid/{teacherid}") 
	public Teacher getTeacherByteacherId(@PathVariable String teacherid);
	
	@GetMapping("/teacher/getbyfname/{firstName}") 
	public Teacher getTeacherByfirstName(@PathVariable String firstName);
	
	@GetMapping("/teacher/getbylname/{lastName}") 
	public Teacher getTeacherBylastName(@PathVariable String lastName);
	
	@GetMapping("/teacher/getbyemail/{email}") 
	public Teacher getTeacherByemail(@PathVariable String email);
	
	@PostMapping("/teacher/update_teacher") 
	public Teacher teacherUpdate(@RequestBody Teacherupdate teacherupdate);
	
	@GetMapping("/teacher/{teacherId}/remove") 
	public void deleteTeacher(@PathVariable String teacherId);
}
