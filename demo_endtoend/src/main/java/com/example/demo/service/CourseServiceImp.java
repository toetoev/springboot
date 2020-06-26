package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.model.CourseStatus;
import com.example.demo.model.Employee;
import com.example.demo.repo.CourseRepository;

@Service
public class CourseServiceImp implements CourseService{
	
	@Autowired
	CourseRepository crepo;
	
	@Override
	public ArrayList<Course> findAll() {
		return (ArrayList<Course>) crepo.findAll();
	}

	@Override
	public boolean saveCourse(Course course) {
		if(crepo.save(course) != null) {
			return true;
		}
		return false;
	}

	@Override
	public void deleteCourse(Course course) {
		crepo.delete(course);
	}

	@Override
	public Course findCourseById(Integer id) {
		return crepo.findById(id).get();
	}
	
	public ArrayList<String> enumIteration(){
		CourseStatus[] c_status = CourseStatus.values();
		
		ArrayList<String> coursestatus = new ArrayList<String>();
		for(CourseStatus status : c_status) {
			coursestatus.add(status.toString());
		}
		
		return coursestatus;
	}
}
