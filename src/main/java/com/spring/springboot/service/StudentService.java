package com.spring.springboot.service;

import com.spring.springboot.exception.UserNotFoundException;
import com.spring.springboot.model.Student;
import com.spring.springboot.repo.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student addStudent(Student student) {
        student.setStudentCode(UUID.randomUUID().toString());
        return studentRepo.save(student);
    }

    public List<Student> findAllStudents() {
        return studentRepo.findAll();
    }

    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }

    public Student findStudentById(Long id) {
        return studentRepo.findStudentById(id)
                .orElseThrow(() -> new UserNotFoundException("User By id " + id + " was not found"));
    }

    @Transactional
    public void deleteStudent(Long id) {
        studentRepo.deleteStudentById(id);
    }
    
    public Student addStudentCourse(Student student, Long courseId) {
    	student.addCourse(courseId);
    	return studentRepo.save(student);
    }
    
    public Student deleteStudentCourse(Student student, Long courseId) {
    	student.removeCourse(courseId);
        return studentRepo.save(student);
    }
}
