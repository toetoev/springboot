package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.model.Department;

public interface DepartmentService {
	public ArrayList<Department> findAll();
	public boolean saveDepartment(Department d);
	public void deleteDepartment(Department d);
	public ArrayList<String> findAllDepartmentNames();
	public Department findDepartmentByName(String name);
	public Department findDepartmentById(Integer id);
}
