package com.cts.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.entity.User;
import com.cts.model.UserDto;
import com.cts.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	public UserDto createUser(UserDto userDto) {
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		ModelMapper modelMapper=new ModelMapper();
		User user=userRepository.save(modelMapper.map(userDto, User.class));
		return modelMapper.map(user, UserDto.class);
	}
	
}
