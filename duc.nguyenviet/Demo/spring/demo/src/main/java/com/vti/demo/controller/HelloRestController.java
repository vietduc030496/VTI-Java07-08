package com.vti.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	@PostMapping("/api/test/{age}")
	public String restApi(@PathVariable("age") int age) {
		System.out.println("i am " + age + "yearl old");
		return "VTI welcome ";
	}

}
