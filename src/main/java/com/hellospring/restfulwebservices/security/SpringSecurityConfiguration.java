package com.hellospring.restfulwebservices.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//Authentication for all requests
		http.authorizeHttpRequests(auth ->auth.anyRequest().authenticated());
		
		//Web page is shown when the req is not authenticated:
		http.httpBasic(withDefaults());
		
		//Disable CSRF -> Post, put
		http.csrf().disable();
		
		return http.build();
	}
}
