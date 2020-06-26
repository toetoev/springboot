package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.model.Course;

public interface CourseService {
	public ArrayList<Course> findAll();
	public boolean saveCourse(Course course);
	public void deleteCourse(Course course);
	public Course findCourseById(Integer id);
	public ArrayList<String> enumIteration();
}
