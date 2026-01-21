package com.cts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password4j.BcryptPassword4jPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) {
		http.authorizeHttpRequests(req->req
				.requestMatchers(HttpMethod.GET,"/api/insurance").hasAnyRole("CUSTOMER")
				.requestMatchers("/api/**").hasAnyRole("ADMIN")
				.anyRequest().authenticated());
		
		return http.build();
	}
	
	//UserDetailsService userDetailsService=new InMemoryUserDetailsManager();
	@Bean
	UserDetailsService userDetailsService() {
		UserDetails user1=User.withUsername("rajesh")
							.password(passwordEncoder()
							.encode("rajesh123"))
							.roles("CUSTOMER").build();
		UserDetails user2=User.withUsername("suresh")
					.password(passwordEncoder()
					.encode("suresh123"))
					.roles("ADMIN").build();
		return new InMemoryUserDetailsManager(user1,user2);
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

}
