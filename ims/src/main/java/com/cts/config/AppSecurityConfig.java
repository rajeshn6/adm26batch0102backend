package com.cts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.bind.annotation.RequestMethod;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
	//UserDetailsService userDetailsService=new InMemoryUserDetailsManager();
	@Autowired
	private JwtFilter jwtFilter;
	
 	@Bean
 	SecurityFilterChain securityFilterChain(HttpSecurity http)  {
 		http.csrf(req->req.disable());
 		http.cors(req->req.disable());
 		http.authorizeHttpRequests(req->
 		req.requestMatchers("/api/user").permitAll()
 		.requestMatchers("/api/user/login").permitAll()
 		.anyRequest().authenticated()
 		);
 		http.httpBasic(Customizer.withDefaults());
 		http.addFilterBefore(jwtFilter, BasicAuthenticationFilter.class);
 		return http.build();
 	}
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
// 	@Bean 
// 	AuthenticationProvider authenticationProvider() {
// 		 DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService());
// 		 provider.setPasswordEncoder(passwordEncoder());
// 		return provider;
// 	}
//	@Bean
//	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//		return config.getAuthenticationManager();
//	}
//	@Bean
//	UserDetailsService userDetailsService() {
//		UserDetails user1=User.withUsername("rajesh")
//							.password(passwordEncoder()
//							.encode("rajesh123"))
//							.roles("EMPLOYEE") //get
//							.build();
//						
//		UserDetails user2=User.withUsername("suresh")
//					.password(passwordEncoder()
//					.encode("suresh123"))
//					.roles("ADMIN","SUPERVISOR")  // all resource
//					.build();
//		return new InMemoryUserDetailsManager(user1,user2);
//	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

}
