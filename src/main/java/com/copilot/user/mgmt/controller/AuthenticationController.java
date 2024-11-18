package com.copilot.user.mgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.copilot.user.mgmt.dto.AuthenticationRequestDTO;
import com.copilot.user.mgmt.service.UserService;
import com.copilot.user.mgmt.util.JwtUtil;

import jakarta.validation.Valid;

@RestController
@Validated
public class AuthenticationController {

	@Autowired
	private UserService userService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@PostMapping("/authenticate")
	public ResponseEntity<String> authenticateUser(@Valid @RequestBody AuthenticationRequestDTO authenticationRequestDTO) {
		
		if(userService.authenticateUser(authenticationRequestDTO)) {
			return ResponseEntity.ok(jwtUtil.generateToken(authenticationRequestDTO.getUsername()));
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	}
	
	@PostMapping("/validate/{userName}")
	public ResponseEntity<String> validateToken(@RequestHeader("Authorization") String token, @PathVariable String userName) {
	    if (jwtUtil.validateToken(token, userName)) {
	        return ResponseEntity.ok("Token is valid");
	    }
	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
	}
	
}
