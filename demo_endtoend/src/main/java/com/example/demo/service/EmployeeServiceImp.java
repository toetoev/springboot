package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{
	
	@Autowired
	EmployeeRepository erepo;

	@Override
	public ArrayList<Employee> findAll() {
		ArrayList<Employee> emp = (ArrayList<Employee>) erepo.findAll();
		return emp;
	}

	@Override
	public boolean saveEmployee(Employee emp) {
		if(erepo.save(emp) != null) {
			return true;
		}
		return false;
	}

	@Override
	public void deleteEmployee(Employee emp) {
		erepo.delete(emp);	
	}

	@Override
	public Employee findEmployeesByName(String name) {
		ArrayList<Employee> list = (ArrayList<Employee>) erepo.findByName(name);
		return list.get(0);
	}

	@Override
	public Employee findEmployee(Integer id) {
		return (Employee) erepo.findById(id).get();
	}

	@Override
	public ArrayList<String> findAllEmployeesName() {
		return erepo.findAllEmployeeNames();
	}
}
