package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.repo.DepartmentRepository;

@Service
public class DepartmentServiceImp implements DepartmentService{

	@Autowired
	DepartmentRepository drepo;
	
	@Override
	public ArrayList<Department> findAll() {
		return (ArrayList<Department>) drepo.findAll();
	}

	@Override
	public boolean saveDepartment(Department d) {
		if(drepo.save(d) != null) {
			return true;
		}
		return false;
	}

	@Override
	public void deleteDepartment(Department d) {
		drepo.delete(d);
	}

	@Override
	public ArrayList<String> findAllDepartmentNames() {
		return drepo.findAllDepartmentNames();
	}

	@Override
	public Department findDepartmentById(Integer id) {
		return drepo.findById(id).get();
	}
	
	@Override
	public Department findDepartmentByName(String name) {
		ArrayList<Department> list = (ArrayList<Department>) drepo.findByName(name);
		return list.get(0);
	}
}
