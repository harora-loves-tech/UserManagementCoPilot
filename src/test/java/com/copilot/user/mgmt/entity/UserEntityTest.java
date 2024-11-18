package com.copilot.user.mgmt.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserEntityTest {

	//Generate test cases for entity class UserEntity
	//Test case for constructor
	//Test case for constructor with null values
	//Test case for getters and setters
	//Test case for equals method
	//Test case for hashcode method
	//Test case for toString method
	//Generate code for test cases mentioned above
	
	@Test
	public void testUserEntity() {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(1L);
		userEntity.setUserName("user");
		userEntity.setPassword("password");
		userEntity.setFirstName("first");
		userEntity.setLastName("last");
		assertEquals(1L, userEntity.getId());
		assertEquals("user", userEntity.getUserName());
		assertEquals("password", userEntity.getPassword());
		assertEquals("first", userEntity.getFirstName());
		assertEquals("last", userEntity.getLastName());
	}
	
	@Test
	public void testUserEntityWithNullValues() {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(null);
		userEntity.setUserName(null);
		userEntity.setPassword(null);
		userEntity.setFirstName(null);
		userEntity.setLastName(null);
		assertEquals(null, userEntity.getId());
		assertEquals(null, userEntity.getUserName());
		assertEquals(null, userEntity.getPassword());
		assertEquals(null, userEntity.getFirstName());
		assertEquals(null, userEntity.getLastName());
	}
	
	@Test
	public void testGettersAndSetters() {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(1L);
		userEntity.setUserName("user");
		userEntity.setPassword("password");
		userEntity.setFirstName("first");
		userEntity.setLastName("last");
		assertEquals(1L, userEntity.getId());
		assertEquals("user", userEntity.getUserName());
		assertEquals("password", userEntity.getPassword());
		assertEquals("first", userEntity.getFirstName());
		assertEquals("last", userEntity.getLastName());
	}
	
	@Test
	public void testEquals() {
		UserEntity userEntity1 = new UserEntity();
		userEntity1.setId(1L);
		userEntity1.setUserName("user");
		userEntity1.setPassword("password");
		userEntity1.setFirstName("first");
		userEntity1.setLastName("last");

		UserEntity userEntity2 = new UserEntity();
		userEntity2.setId(1L);
		userEntity2.setUserName("user");
		userEntity2.setPassword("password");
		userEntity2.setFirstName("first");
		userEntity2.setLastName("last");

		assertEquals(userEntity1, userEntity2);
	}
	
	@Test
	public void testHashCode() {
		UserEntity userEntity1 = new UserEntity();
		userEntity1.setId(1L);
		userEntity1.setUserName("user");
		userEntity1.setPassword("password");
		userEntity1.setFirstName("first");
		userEntity1.setLastName("last");

		UserEntity userEntity2 = new UserEntity();
		userEntity2.setId(1L);
		userEntity2.setUserName("user");
		userEntity2.setPassword("password");
		userEntity2.setFirstName("first");
		userEntity2.setLastName("last");

		assertEquals(userEntity1.hashCode(), userEntity2.hashCode());
	}
	
	@Test
	public void testToString() {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(1L);
		userEntity.setUserName("user");
		userEntity.setPassword("password");
		userEntity.setFirstName("first");
		userEntity.setLastName("last");
		assertEquals("UserEntity [id=1, userName=user, password=password, firstName=first, lastName=last]",
				userEntity.toString());
	}
	
}
