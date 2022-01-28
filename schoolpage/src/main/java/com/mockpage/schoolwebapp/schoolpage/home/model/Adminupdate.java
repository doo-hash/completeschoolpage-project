package com.mockpage.schoolwebapp.schoolpage.home.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class  Adminupdate{

	@Id
	private Long id;
	@Pattern(regexp = "^[a-zA-Z_\s]{2,40}",message="Must contain only letters")
	@NotBlank(message = "Firstname cannot be empty")
	@Size(min=2, message = "Firstname must be more than 2 characters")
	private String firstName;
	@Pattern(regexp = "^[a-zA-Z_\s]{2,40}",message="Must contain only letters")
	@NotBlank(message = "Lastname cannot be empty")
	@Size(min=2,message = "Lastname cannot be less than 2 characters")
	private String lastName;
	@NotEmpty(message = "Admin Id cannot be empty")
	private String adminId;
	@NotEmpty(message = "Designation cannot be empty")
	private String designation;
	@NotEmpty(message = "Email is Mandatory")
	@Email(message = "Invalid email")
	private String email;
	@Lob
	@NotBlank(message = "Education details cannot be empty")
	@Size(min=10,message = "Education details cannot be less than 10 characters")
	private String education;
	@Lob
	@NotBlank(message = "Work experience details cannot be empty")
	@Size(min=10,message = "work experience details cannot be less than 10 characters")
	private String work_experience;

	public Adminupdate() {
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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


	public Adminupdate(Long id,
			@Pattern(regexp = "^[a-zA-Z_ ]{2,40}", message = "Must contain only letters") @NotBlank(message = "Firstname cannot be empty") @Size(min = 2, message = "Firstname must be more than 2 characters") String firstName,
			@Pattern(regexp = "^[a-zA-Z_ ]{2,40}", message = "Must contain only letters") @NotBlank(message = "Lastname cannot be empty") @Size(min = 2, message = "Lastname cannot be less than 2 characters") String lastName,
			@NotEmpty(message = "Admin Id cannot be empty") String adminId,
			@NotEmpty(message = "Designation cannot be empty") String designation,
			@NotEmpty(message = "Email is Mandatory") @Email(message = "Invalid email") String email,
			@NotBlank(message = "Education details cannot be empty") @Size(min = 50, message = "Education details cannot be less than 50 characters") String education,
			@NotBlank(message = "Work experience details cannot be empty") @Size(min = 50, message = "work experience details cannot be less than 50 characters") String work_experience) {
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
