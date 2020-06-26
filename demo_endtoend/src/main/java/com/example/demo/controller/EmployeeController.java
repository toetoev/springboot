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
import com.example.demo.model.Employee;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.DepartmentServiceImp;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImp;

import net.bytebuddy.implementation.bind.annotation.BindingPriority;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService eservice;

	@Autowired
	public void setEmployeeService(EmployeeServiceImp esi) {
		this.eservice = esi;
	}
	
	@Autowired
	DepartmentService dservice;
	
	@Autowired
	public void setDepartmentService(DepartmentServiceImp dsi) {
		this.dservice = dsi;
	}

	@RequestMapping("/list")
	public String employeeList(Model model) {
		model.addAttribute("employee", eservice.findAll());
		return "employeeList";
	}
	
	@RequestMapping("/add")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("depnames", dservice.findAllDepartmentNames());
		return "employeeForm";
	}
	
	@RequestMapping("/save")
	public String saveEmployee(@Valid @ModelAttribute("employee")Employee employee, Model model, BindingResult bindresult) {
		if(bindresult.hasErrors()) {
			model.addAttribute("employee", employee);
			model.addAttribute("depnames", dservice.findAllDepartmentNames());
			return "employeeForm";
		}
		Department d = dservice.findDepartmentByName(employee.getDepartment().getName());
		employee.setDepartment(d);
		eservice.saveEmployee(employee);
		return "forward:/employee/list";
	}
	
	@RequestMapping("/edit/{id}")
	public String editEmployee(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("employee", eservice.findEmployee(id));
		model.addAttribute("depnames", dservice.findAllDepartmentNames());
		return "employeeForm";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteEmployee(@ModelAttribute("employee") Employee employee) {
		eservice.deleteEmployee(employee);
		return "forward:/employee/list";
	}
}
