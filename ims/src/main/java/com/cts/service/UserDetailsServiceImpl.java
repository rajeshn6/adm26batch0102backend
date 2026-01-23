package com.cts.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.entity.User;
import com.cts.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findUserByUsername(username);
		System.out.println("user details service  implemenation");
		System.out.println("user data from the db:"+user);
		List<GrantedAuthority> listOfGranterAuthorities=user.getRoles().stream()
		.map(role->new SimpleGrantedAuthority("ROLE_"+role.getRoleName()))
		.collect(Collectors.toList());
		UserDetails userDetails=new org.springframework.security.core.userdetails.User(user.getUsername(),
				user.getPassword(),true,true,true,true,listOfGranterAuthorities);
		
		return userDetails;
	}

}
