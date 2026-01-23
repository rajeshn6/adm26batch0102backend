package com.cts.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private int id;
	private String username;
	private String password;
	private String email;
	private String phone;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<RoleDto> roles;
	

}
