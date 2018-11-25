package com.webservices.rest.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/hello-world")
	public String hello() {
		return "Hello";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorld helloWorldBean() {
		return new HelloWorld("hello");
	}
	
	@GetMapping(path = "/hello-world-bean/{name}")
	public HelloWorld helloworldbeanwithPath(@PathVariable String name) {
		return new HelloWorld(String.format("name %s", name));
	}
	
}
