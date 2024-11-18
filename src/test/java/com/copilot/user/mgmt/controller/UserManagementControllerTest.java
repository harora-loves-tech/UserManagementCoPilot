package com.copilot.user.mgmt.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Generate imports
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class UserManagementControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	//Test case for a user with invalid userName
	@Test
	public void testCreateUserWithInvalidUserName() throws Exception {
		String userDTO = "{\n" + "    \"userName\": \"user\",\n" + "    \"password\": \"password\",\n"
				+ "    \"firstName\": \"first\",\n" + "    \"lastName\": \"last\"\n" + "}";
		mockMvc.perform(post("/users").contentType("application/json").content(userDTO))
				.andExpect(status().isBadRequest())
				.andExpect(result -> result.getResponse().getContentAsString().contains("User Name should be an email"));
				
	}
	
	//Test case for a user with blank password
	@Test
	public void testCreateUserWithBlankPassword() throws Exception {
        String userDTO = "{\n" + "    \"userName\": \"user1@gmail.com\", \n" + "    \"password\": \"\",\n" 
        		+ "    \"firstName\": \"first\",\n" + "    \"lastName\": \"last\"\n" + "}";
        mockMvc.perform(post("/users").contentType("application/json").content(userDTO))
                .andExpect(status().isBadRequest())
                .andExpect(result -> result.getResponse().getContentAsString().contains("Password should be atleast 8 characters long"));
	
	}
	
	//Test case for a user with blank firstName
	@Test
	public void testCreateUserWithBlankFirstName() throws Exception {
	       String userDTO = "{\n" + "    \"userName\": \"user1@gmail.com\", \n" + "    \"password\": \"validpassword\",\n" 
	        		+ "    \"firstName\": \"\",\n" + "    \"lastName\": \"last\"\n" + "}";
	           mockMvc.perform(post("/users").contentType("application/json").content(userDTO))
                        .andExpect(status().isBadRequest())
                        .andExpect(result -> result.getResponse().getContentAsString().contains("First Name cannot be blank"));
	 }
	
	//Test case for a user with blank lastName
	@Test
	public void testCreateUserWithBlankLastName() throws Exception {
	       String userDTO = "{\n" + "    \"userName\": \"user1@gmail.com\", \n" + "    \"password\": \"validpassword\",\n" 
	        		+ "    \"firstName\": \"Harish\",\n" + "    \"lastName\": \"\"\n" + "}";
	           mockMvc.perform(post("/users").contentType("application/json").content(userDTO))
                        .andExpect(status().isBadRequest())
                        .andExpect(result -> result.getResponse().getContentAsString().contains("Last Name cannot be blank"));
	}
	
	//Test case for a valid user
	@Test
	public void testCreateUser() throws Exception {
           String userDTO = "{\n" + "    \"userName\": \"harish@gmail.com\", \n" + "    \"password\": \"validpassword\",\n"
	            	+ "    \"firstName\": \"Harish\",\n" + "    \"lastName\": \"Arora\"\n" + "}";
           mockMvc.perform(post("/users").contentType("application/json").content(userDTO))
                    .andExpect(status().isCreated())
                    .andExpect(result -> result.getResponse().getContentAsString().contains("User created successfully"));
	}
           
}
