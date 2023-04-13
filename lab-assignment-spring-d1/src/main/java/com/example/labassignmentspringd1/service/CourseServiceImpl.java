package com.example.labassignmentspringd1.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.labassignmentspringd1.entity.Course;

import com.example.labassignmentspringd1.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	private CourseRepository courseRepository;
	
	public CourseServiceImpl (CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}
	
	@Override
	public List<Course> findAll(){
		return courseRepository.findAll();
	}
}
