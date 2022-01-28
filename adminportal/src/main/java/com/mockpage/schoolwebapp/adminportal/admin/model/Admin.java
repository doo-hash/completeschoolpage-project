package com.mockpage.schoolwebapp.adminportal.admin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class  Admin{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private String adminId;
	private String designation;
	private String email;
	@Lob
	private String education;
	@Lob
	private String work_experience;
	private String password;
	private boolean checked;

	public Admin() {
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

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getWork_experience() {
		return work_experience;
	}

	public void setWork_experience(String work_experience) {
		this.work_experience = work_experience;
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

	@Override
	public String toString() {
		return "Admin [firstName=" + firstName + ", lastName=" + lastName + ", adminId=" + adminId + ", designation="
				+ designation + ", email=" + email + ", education=" + education + ", work_experience=" + work_experience
				+ ", password=" + password + ", checked=" + checked + "]";
	}

	public Admin(String firstName, String lastName, String adminId, String designation, String email, String education,
			String work_experience, String password, boolean checked) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.adminId = adminId;
		this.designation = designation;
		this.email = email;
		this.education = education;
		this.work_experience = work_experience;
		this.password = password;
		this.checked = checked;
	}


}
