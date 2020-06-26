package com.example.demo.repo;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	
	@Query("Select d.name from Department d")
	ArrayList<String> findAllDepartmentNames();
	
	List<Department> findByName(String name);
}
