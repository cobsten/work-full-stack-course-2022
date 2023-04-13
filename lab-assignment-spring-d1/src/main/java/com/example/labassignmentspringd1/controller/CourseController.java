package com.example.labassignmentspringd1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.labassignmentspringd1.entity.Course;
import com.example.labassignmentspringd1.service.CourseService;

@RestController
@RequestMapping("/api/v1")
public class CourseController {
	
	private CourseService courseService;

	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
    @GetMapping("/courses")
    public List<Course> getAllCourses(){
         return courseService.findAll();
    }
    
}
