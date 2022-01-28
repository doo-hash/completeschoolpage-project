package com.mockpage.schoolwebapp.parentportal.parent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Parent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private String studentName;
	private String studentId;
	private String email;
	private String password;
	private boolean checked;

	public Parent() {
	}

	@Override
	public String toString() {
		return "Parent [firstName=" + firstName + ", lastName=" + lastName + ", studentName=" + studentName
				+ ", studentId=" + studentId + ", email=" + email + ", password=" + password + ", checked=" + checked
				+ "]";
	}

	public Parent(String firstName, String lastName, String studentName, String studentId, String email,
			String password, boolean checked) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentName = studentName;
		this.studentId = studentId;
		this.email = email;
		this.password = password;
		this.checked = checked;
	}

	public long getId() {
		return id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	
}
