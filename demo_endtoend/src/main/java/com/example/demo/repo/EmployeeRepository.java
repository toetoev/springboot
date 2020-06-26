package com.example.demo.repo;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	List<Employee> findByName(String name);
	
	@Query("Select e.name from Employee e")
	ArrayList<String> findAllEmployeeNames();
}
