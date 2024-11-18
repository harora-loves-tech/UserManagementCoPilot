package com.copilot.user.mgmt.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AuthenticationRequestDTO {
	
	@NotBlank(message = "Username cannot be empty")
	@Email(message = "Username should be an email")
	private String username;
	
	@NotBlank(message = "Password cannot be empty")
	@Size(min = 6, message = "Password should have atleast 6 characters")
	private String password;
	
	public AuthenticationRequestDTO() {
		super();
	}
	
	public AuthenticationRequestDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	// Getters and Setters
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
