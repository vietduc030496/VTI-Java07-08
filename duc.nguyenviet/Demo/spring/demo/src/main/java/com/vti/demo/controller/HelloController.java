package com.vti.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vti.demo.entity.Student;

@Controller
public class HelloController {

	@GetMapping("/")
	public String hello(Model model) {
		Student student = new Student();
		model.addAttribute("studentForm", student);
		return "hello";
	}

	@PostMapping("/test")
	public String testModel(@ModelAttribute("studentForm") Student student) {
		System.out.println(student.getName());
		return "success";
	}
}
