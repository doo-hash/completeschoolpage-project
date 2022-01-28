package com.mockpage.schoolwebapp.adminportal.admin.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class  Adminupdate{
	
	
	@Id
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

	public Adminupdate() {
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


	@Override
	public String toString() {
		return "Adminupdate [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", adminId=" + adminId
				+ ", designation=" + designation + ", email=" + email + ", education=" + education
				+ ", work_experience=" + work_experience + "]";
	}


	public Adminupdate(long id, String firstName, String lastName, String adminId, String designation, String email,
			String education, String work_experience) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adminId = adminId;
		this.designation = designation;
		this.email = email;
		this.education = education;
		this.work_experience = work_experience;
	}

	
}
