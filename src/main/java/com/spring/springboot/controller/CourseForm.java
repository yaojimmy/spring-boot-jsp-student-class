package com.spring.springboot.controller;

//Remove the CourseForm class from the inner class and place it at the top level
	public class CourseForm {
	    private Long newCourseId;
	    private Integer newGrade;

	    // Getters and setters for newCourseId and newGrade

	    public Long getNewCourseId() {
	        return newCourseId;
	    }

	    public void setNewCourseId(Long newCourseId) {
	        this.newCourseId = newCourseId;
	    }

	    public Integer getNewGrade() {
	        return newGrade;
	    }

	    public void setNewGrade(Integer newGrade) {
	        this.newGrade = newGrade;
	    }
	}