package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.model.Employee;

public interface EmployeeService {
	public ArrayList<Employee> findAll();
	public boolean saveEmployee(Employee emp);
	public void deleteEmployee(Employee emp);
	public Employee findEmployeesByName(String name);
	public Employee findEmployee(Integer id);
	public ArrayList<String> findAllEmployeesName();
}
