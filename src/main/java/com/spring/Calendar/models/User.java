package com.spring.Calendar.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	
	// Primary key
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Member Variables
	
	@NotEmpty(message = "First Name required")
	@Size(min = 2, max = 45, message = "First Name must be between 2 and 45 characters")
	private String firstName;
	
	@NotEmpty(message = "Last Name required")
	@Size(min = 2, max = 45, message = "Last Name must be between 2 and 45 characters")
	private String lastName;
	
	@NotEmpty(message = "Email required")
	@Email(message = "Invalid Email")
	private String email;
	
	@NotEmpty(message = "Password required")
	@Size(min = 8, max = 128, message = "Password must be at least 8 characters")
	private String password;
	
	@Transient
	@NotEmpty(message = "Confirm password required")
	@Size(min = 8, max = 128, message = "Confirm password must be at least 8 characters")
	private String confirmPassword;
	
	
	// Data Creation Trackers
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	
	public User(){}

	
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
