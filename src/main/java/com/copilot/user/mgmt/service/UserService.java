package com.copilot.user.mgmt.service;

import com.copilot.user.mgmt.dto.AuthenticationRequestDTO;
import com.copilot.user.mgmt.dto.UserDTO;
import com.copilot.user.mgmt.entity.UserEntity;
import com.copilot.user.mgmt.repository.UserRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Long createUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        return userRepository.save(userEntity).getId();
    }
    
    //Write a method which returns the user details by username mapped to the repository method
    //Use the repository method findByUserName
    //Return UserDTO object
	public UserDTO getUserByUserName(String userName) {
		UserEntity userEntity = userRepository.findByUserName(userName);
		UserDTO userDTO = new UserDTO(userEntity.getUserName(), "", userEntity.getFirstName(),
				userEntity.getLastName());
		return userDTO;
	}

	public boolean authenticateUser(@Valid AuthenticationRequestDTO authenticationRequestDTO) {
		UserEntity userEntity = userRepository.findByUserName(authenticationRequestDTO.getUsername());
		if (userEntity != null && userEntity.getPassword().equals(authenticationRequestDTO.getPassword())) {
			return true;
		}
		return false;
	}
}