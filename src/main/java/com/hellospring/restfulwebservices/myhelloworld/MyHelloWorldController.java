package com.hellospring.restfulwebservices.myhelloworld;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	@GetMapping(path ="/my-hello-world/path-variable/{name}")
	public MyHelloWorldBean helloWorldBeanPathParameters(@PathVariable String name) {
		return new MyHelloWorldBean(String.format("Hello world %s !", name));
	}

}
