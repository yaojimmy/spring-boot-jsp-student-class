package com.spring.springboot.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String professor;
    @Column(nullable = false, updatable = false)
    private String courseCode;
    @ElementCollection
    private List<Integer> studentIds;

    public Course() {
        this.studentIds = new ArrayList<>();
    }

    public Course(String name, String professor) {
        this.name = name;
        this.professor = professor;
        this.studentIds = new ArrayList<>();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public void addStudent(Integer studentId) {
        studentIds.add(studentId);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public List<Integer> getStudentIds() {
        return this.studentIds;
    }
    public void setStudentIds(List<Integer> studentIds) {
        this.studentIds = studentIds;
    }
}
