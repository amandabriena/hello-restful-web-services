package com.hellospring.restfulwebservices.myhelloworld;

import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class MyHelloWorldController {
	
	private MessageSource messageSource;
	
	public MyHelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
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
	
	@GetMapping(path ="/my-hello-world-internationalized")
	public String helloWorldInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("hello.world.message", null, "Default Message", locale);
	}

}
