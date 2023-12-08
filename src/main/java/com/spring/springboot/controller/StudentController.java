package com.spring.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.springboot.StudentService;

@Controller
public class StudentController {
	
	private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

	@GetMapping({"/", "/hello"})
	public String hello(@RequestParam(value="name", defaultValue="World", required=true) String name, Model model) {
		model.addAttribute("name", name);
		return "hello";
	}
}
