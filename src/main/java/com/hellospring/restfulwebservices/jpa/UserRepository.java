package com.hellospring.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hellospring.restfulwebservices.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	

}
