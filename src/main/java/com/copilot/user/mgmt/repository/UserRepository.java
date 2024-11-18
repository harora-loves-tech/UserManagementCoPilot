package com.copilot.user.mgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.copilot.user.mgmt.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	//Generate method and annotations to find user by userName
	public UserEntity findByUserName(String userName);
}