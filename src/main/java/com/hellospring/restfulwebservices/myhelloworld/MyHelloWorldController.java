package com.hellospring.restfulwebservices.myhelloworld;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class MyHelloWorldController {
	
	@GetMapping(path ="/my-hello-world")
	public String helloWorld() {
		return "> hello world";
	}
	
	@GetMapping(path ="/my-hello-world-bean")
	public MyHelloWorldBean helloWorldBean() {
		return new MyHelloWorldBean("hello world");
	}

}
