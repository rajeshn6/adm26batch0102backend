package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findUserByUsername(String username); //select * from user where username="suresh";

	
}
