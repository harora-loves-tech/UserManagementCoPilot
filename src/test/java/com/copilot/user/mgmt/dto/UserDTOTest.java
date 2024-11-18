package com.copilot.user.mgmt.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserDTOTest {
	
	//Test case for constructor
	@Test
	public void testUserDTO() {
		UserDTO userDTO = new UserDTO("user", "password", "first", "last");
		assertEquals("user", userDTO.getUserName());
		assertEquals("password", userDTO.getPassword());
		assertEquals("first", userDTO.getFirstName());
		assertEquals("last", userDTO.getLastName());
	}

	//Test case for constructor with null values
	@Test
	public void testUserDTOWithNullValues() {
		UserDTO userDTO = new UserDTO(null, null, null, null);
		assertEquals(null, userDTO.getUserName());
		assertEquals(null, userDTO.getPassword());
		assertEquals(null, userDTO.getFirstName());
		assertEquals(null, userDTO.getLastName());
	}
	
}
