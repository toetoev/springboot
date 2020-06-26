package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.DepartmentServiceImp;

@Controller
@RequestMapping(value = "/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService dservice;
	
	@Autowired
	public void addDepartmentService(DepartmentServiceImp depimp) {
		this.dservice = depimp;
	}
	
	@RequestMapping(value = "/add")
	public String addDepartment(Model model) {
		model.addAttribute("departments", new Department());
		return "departmentForm";
	}
	
	@RequestMapping(value = "/list")
	public String displayDepartment(Model model) {
		model.addAttribute("dlists", dservice.findAll());
		return "departmentList";
	}
	
	@RequestMapping(value = "/save")
	public String saveDepartment(@ModelAttribute("departments") @Valid Department dept, BindingResult bindresult, Model model) {
		if(bindresult.hasErrors()) {
			return "departmentForm";
		}
		dservice.saveDepartment(dept);
		return "forward:/department/list";
	}
	
	@RequestMapping("/edit/{id}")
	public String editDepartment(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("departments", dservice.findDepartmentById(id));
		return "departmentForm";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteDepartment(@PathVariable("id") Integer id) {
		dservice.deleteDepartment(dservice.findDepartmentById(id));
		return "forward:/department/list";
	}
}
