// File: src/main/java/com/copilot/user/mgmt/controller/UserManagementController.java
package com.copilot.user.mgmt.controller;

import com.copilot.user.mgmt.dto.UserDTO;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


//Import the required class
import com.copilot.user.mgmt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;



@RestController
@RequestMapping("/users")
@Validated
public class UserManagementController {

	//Autowired service
	@Autowired
	private UserService userService;
	
    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO userDTO) {
        // Logic to save the user
    	userService.createUser(userDTO);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }
    
    //Write a method to get the user details by username
    //Use the getUserByUserName method of the service
    //Return UserDTO object
    @GetMapping("/{userName}")
	public UserDTO getUserByUserName(@PathVariable String userName) {
		return userService.getUserByUserName(userName);
	}
    
    
}