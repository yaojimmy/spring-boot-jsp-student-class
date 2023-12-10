package com.spring.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.springboot.model.Student;
import com.spring.springboot.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

	@GetMapping("hello")
	public String hello(@RequestParam(value="name", defaultValue="World", required=true) String name, Model model) {
		model.addAttribute("name", name);
		return "hello";
	}
	
	
	@GetMapping({"/", "/viewStudents"})
    public String getAllStudents(Model model) {
		List<Student> students = studentService.findAllStudents();
		System.out.println(students);
        model.addAttribute("list", students);
        return "ViewStudents";
    }
	
	
	@GetMapping({"/addStudent"})
	public String addStudent(Model model) {
		model.addAttribute("student", new Student());
		
		return "AddStudent";
	}
	
	@PostMapping("/saveNewStudent")
	public String saveNewStudent(Student student, RedirectAttributes redirectAttributes) {
		studentService.addStudent(student);
		
		return "redirect:/viewStudents";
	}
	

	/*
    @GetMapping("/find/{id}")
    public String getStudentById(@PathVariable("id") Long id) {
        Student student = studentService.findStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        Student newStudent = studentService.addStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public String updateStudent(@RequestBody Student student) {
        Student updateStudent = studentService.updateStudent(student);
        return new ResponseEntity<>(updateStudent, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/
}
