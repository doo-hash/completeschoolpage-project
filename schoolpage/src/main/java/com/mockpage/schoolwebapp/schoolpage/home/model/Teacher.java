package com.mockpage.schoolwebapp.schoolpage.home.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Pattern(regexp = "^[a-zA-Z_\s]{2,40}",message="Must contain only letters")
	@NotBlank(message = "Firstname cannot be empty")
	@Size(min=2, message = "Firstname must be more than 2 characters")
	private String firstName;
	@Pattern(regexp = "^[a-zA-Z_\s]{2,40}",message="Must contain only letters")
	@NotBlank(message = "Lastname cannot be empty")
	@Size(min=2,message = "Lastname cannot be less than 2 characters")
	private String lastName;
	@Pattern(regexp = "^[a-zA-Z0-9_-]{2,40}",message="Invalid Characters")
	@NotEmpty(message = "Teacher Id cannot be empty")
	private String teacherId;
	@Pattern(regexp = "^[a-zA-Z_\s]{2,40}",message="Must contain only letters")
	@NotEmpty(message = "Designation cannot be empty")
	private String designation;
	@Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",
			message="Invalid email address")
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
	@NotBlank(message = "Passowrd cannot be empty")
	@Size(min=8,max=16, message="password must be 8 to 16 characters length!")
	private String password;
	@AssertTrue(message="please check this before you proceed")
	private boolean checked;

	
	public Teacher() {}


	public Teacher(
			@Pattern(regexp = "^[a-zA-Z_ ]{2,40}", message = "Must contain only letters") @NotBlank(message = "Firstname cannot be empty") @Size(min = 2, message = "Firstname must be more than 2 characters") String firstName,
			@Pattern(regexp = "^[a-zA-Z_ ]{2,40}", message = "Must contain only letters") @NotBlank(message = "Lastname cannot be empty") @Size(min = 2, message = "Lastname cannot be less than 2 characters") String lastName,
			@Pattern(regexp = "^[a-zA-Z0-9_-]{2,40}", message = "Invalid Characters") @NotEmpty(message = "Teacher Id cannot be empty") String teacherId,
			@Pattern(regexp = "^[a-zA-Z_ ]{2,40}", message = "Must contain only letters") @NotEmpty(message = "Designation cannot be empty") String designation,
			@Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Invalid email address") @NotEmpty(message = "Email is Mandatory") @Email(message = "Invalid email") String email,
			@NotBlank(message = "Education details cannot be empty") @Size(min = 10, message = "Education details cannot be less than 10 characters") String education,
			@NotBlank(message = "Work experience details cannot be empty") @Size(min = 10, message = "work experience details cannot be less than 10 characters") String work_experience,
			@Pattern(regexp = "^[a-zA-Z0-9_-!@#$%&*]{2,40}", message = "Must contain letters, numbers and special chars like @ # % ! & *") @NotBlank(message = "Passowrd cannot be empty") @Size(min = 8, max = 16, message = "password must be 8 to 16 characters length!") String password,
			@AssertTrue(message = "please check this before you proceed") boolean checked) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.teacherId = teacherId;
		this.designation = designation;
		this.email = email;
		this.education = education;
		this.work_experience = work_experience;
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


	public String getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
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
		return "Teacher [firstName=" + firstName + ", lastName=" + lastName + ", teacherId=" + teacherId
				+ ", designation=" + designation + ", email=" + email + ", education=" + education
				+ ", work_experience=" + work_experience + ", password=" + password + ", checked=" + checked + "]";
	}

}
