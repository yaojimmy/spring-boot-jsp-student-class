package com.spring.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.springboot.model.Course;
import com.spring.springboot.model.Student;
import com.spring.springboot.service.CourseService;
import com.spring.springboot.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private final StudentService studentService;
	private final CourseService courseService;

    public StudentController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

	@GetMapping("hello")
	public String hello(@RequestParam(value="name", defaultValue="World", required=true) String name, Model model) {
		model.addAttribute("name", name);
		return "hello";
	}
	
	
	@GetMapping({"/", "/viewStudents"})
    public String getAllStudents(Model model) {
		List<Student> students = studentService.findAllStudents();
        model.addAttribute("list", students);
		List<Course> courses = courseService.findAllCourses();
        model.addAttribute("cList", courses);
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
	
	@GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        studentService.deleteStudent(id);
        return "redirect:/viewStudents";
    }
	
	@GetMapping("/editStudent/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.findStudentById(id));
		List<Course> courses = courseService.findAllCourses();
        model.addAttribute("cList", courses);
		
		return "EditStudent";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(Student student, RedirectAttributes redirectAttributes) {
		studentService.updateStudent(student);
		
		return "redirect:/viewStudents";
	}
	
	@GetMapping({"/addCourse"})
	public String addCourse(Model model) {
		model.addAttribute("course", new Course());
		
		return "AddCourse";
	}
	
	@PostMapping("/saveNewCourse")
	public String saveNewCourse(Course course, RedirectAttributes redirectAttributes) {
		courseService.addCourse(course);
		
		return "redirect:/viewStudents";
	}
	
	@GetMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        courseService.deleteCourse(id);
        return "redirect:/viewStudents";
    }
	
	@GetMapping("/editCourse/{id}")
	public String editCourse(@PathVariable Long id, Model model) {
		model.addAttribute("course", courseService.findCourseById(id));
		
		return "EditCourse";
	}
	
	@PostMapping("/saveCourse")
	public String saveCourse(Course course, RedirectAttributes redirectAttributes) {
		courseService.updateCourse(course);
		
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
    }*/
}
