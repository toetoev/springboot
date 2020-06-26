package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Course;
import com.example.demo.model.Employee;
import com.example.demo.service.CourseService;
import com.example.demo.service.CourseServiceImp;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImp;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService cservice;
	
	@Autowired
	private EmployeeService eservice;
	
	@Autowired
	public void addCourseService(CourseServiceImp cimp) {
		this.cservice = cimp;
	}
	
	@Autowired
	public void addEmployeeService(EmployeeServiceImp eimp) {
		this.eservice = eimp;
	}
	
	@RequestMapping("/add")
	public String addCourse(Model model) {
		model.addAttribute("course", new Course());
		model.addAttribute("empnames", eservice.findAllEmployeesName());
		model.addAttribute("c_status", cservice.enumIteration());
		return "courseForm";
	}
	
	@RequestMapping("/list")
	public String showCourse(Model model) {
		model.addAttribute("courselist", cservice.findAll());
		return "courseList";
	}
	
	@RequestMapping("/save")
	public String saveCourse(@ModelAttribute("course") @Valid Course course, Model model, BindingResult bindresult) {
		if(bindresult.hasErrors()) {
			model.addAttribute("empnames", course);
			model.addAttribute("c_status", cservice.enumIteration());
			return "courseForm";
		}
		Employee emp = eservice.findEmployeesByName(course.getEmployee().getName());
		course.setEmployee(emp);
		cservice.saveCourse(course);
		return "forward:/course/list";
	}
}
