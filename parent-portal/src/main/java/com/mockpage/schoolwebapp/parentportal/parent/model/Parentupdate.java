package com.mockpage.schoolwebapp.parentportal.parent.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parentupdate {

	@Id
	private long id;
	private String firstName;
	private String lastName;
	private String studentName;
	private String studentId;
	private String email;

	public Parentupdate() {
	}

	public Parentupdate(long id, String firstName, String lastName, String studentName, String studentId,
			String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentName = studentName;
		this.studentId = studentId;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Parentupdate [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", studentName="
				+ studentName + ", studentId=" + studentId + ", email=" + email + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}
