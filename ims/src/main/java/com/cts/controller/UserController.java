package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.config.JwtUtility;
import com.cts.model.LoginDto;
import com.cts.model.UserDto;
import com.cts.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtility jwtUtility;
	
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto userDto1=userService.createUser(userDto);
		return new ResponseEntity<UserDto>(userDto1,HttpStatus.CREATED);
	}
	@PostMapping("/login")
	public String login(@RequestBody LoginDto loginDto) {
//		loginDto.getUsername()loginDto --send it to 
//		generate the token
		System.out.println("login called");
	   	 Authentication authentication = authenticationManager.authenticate(
	   	            new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
	   	        if (authentication.isAuthenticated()) {
	   	            return jwtUtility.generateToken(loginDto.getUsername());
	   	        } else {
	   	            throw new UsernameNotFoundException("Invalid user email and password request!");
	   	        }
			
	}
	

}












