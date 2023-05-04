package com.hellospring.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hellospring.restfulwebservices.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
	

}
