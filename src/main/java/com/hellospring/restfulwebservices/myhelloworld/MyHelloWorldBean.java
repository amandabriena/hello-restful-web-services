package com.hellospring.restfulwebservices.myhelloworld;


public class MyHelloWorldBean {
	private String message;
	
	public MyHelloWorldBean(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MyHelloWorldBean [message=" + message + "]";
	}
	
	
}
