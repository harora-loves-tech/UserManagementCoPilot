package com.copilot.user.mgmt.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {

	//Not blank annotation for all fields
	//userName should be an email
	//password should be atleast 8 characters long
	@NotBlank(message = "User Name cannot be blank")
	@Email(message = "User Name should be an email")
	private String userName;
	@NotBlank(message = "Password should be atleast 8 characters long")
	@Size(min = 8, message = "Password should be atleast 8 characters long")
	private String password;
	//firstName and lastName
	@NotBlank(message = "First Name cannot be blank")
	private String firstName;
	@NotBlank(message = "Last Name cannot be blank")
	private String lastName;

	//constructor and getter setter
	public UserDTO(String userName, String password, String firstName, String lastName) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public UserDTO() {
		super();
	}
	
	//getter setter
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	//getter setter
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	//getter setter
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	//getter setter
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "UserDTO [userName=" + userName + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}
}
