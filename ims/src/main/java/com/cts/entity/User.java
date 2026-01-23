package com.cts.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String password;
	private String email;
	private String phone;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Role> roles;
	

}
