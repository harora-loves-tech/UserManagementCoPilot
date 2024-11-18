package com.copilot.user.mgmt.service;

//Generate imports
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.copilot.user.mgmt.dto.AuthenticationRequestDTO;
import com.copilot.user.mgmt.dto.UserDTO;
import com.copilot.user.mgmt.entity.UserEntity;
import com.copilot.user.mgmt.repository.UserRepository;

@SpringBootTest
//Generate annotations
public class UserServiceTest {
	
	//Generate annotations
	@Mock
	UserRepository userRepository;

	@InjectMocks
	UserService userService;
	
	//Test case for createUser method
	@Test
	public void testCreateUser() {
		UserDTO userDTO = new UserDTO("user", "password", "first", "last");
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName(userDTO.getUserName());
		userEntity.setPassword(userDTO.getPassword());
		userEntity.setFirstName(userDTO.getFirstName());
		userEntity.setLastName(userDTO.getLastName());
		userEntity.setId(1L);
		when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);
		assertEquals(userEntity.getId(), userService.createUser(userDTO));
	}
	
	//Test case for getUserByUserName method
	@Test
	public void testGetUserByUserName() {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName("user");
		userEntity.setPassword("password");
		userEntity.setFirstName("first");
		userEntity.setLastName("last");
		when(userRepository.findByUserName("user")).thenReturn(userEntity);
		UserDTO userDTO = new UserDTO(userEntity.getUserName(), "", userEntity.getFirstName(),
				userEntity.getLastName());
		assertEquals(userDTO.getUserName(), userService.getUserByUserName("user").getUserName());
		assertEquals(userDTO.getFirstName(), userService.getUserByUserName("user").getFirstName());
		assertEquals(userDTO.getLastName(), userService.getUserByUserName("user").getLastName());
	}
	
	//Test case for authenticateUser method
	@Test
	public void testAuthenticateUser() {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName("user");
		userEntity.setPassword("password");
		when(userRepository.findByUserName("user")).thenReturn(userEntity);
		assertEquals(true, userService.authenticateUser(new AuthenticationRequestDTO("user", "password")));
	}
}
