package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.UserDto;
import com.cts.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto userDto1=userService.createUser(userDto);
		return new ResponseEntity<UserDto>(userDto1,HttpStatus.CREATED);
	}
	

}
