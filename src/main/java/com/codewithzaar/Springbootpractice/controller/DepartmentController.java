package com.codewithzaar.Springbootpractice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.codewithzaar.Springbootpractice.entity.Department;
import com.codewithzaar.Springbootpractice.service.DepartmentService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class DepartmentController
{

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/saveDepartment")
	public Department saveDepartment(@RequestBody Department department)
	{
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/fetchDepartmentById/{id}")
	public Optional<Department> getDepartmentById(@PathVariable("id") Long departmentId)
	{
		return departmentService.fetchDepartmentById(departmentId);
	}

	@GetMapping("/fetchDepartments")
	public List<Department> fetchDepartmentList()
	{
		return departmentService.fetchDepartmentList();
	}

	@DeleteMapping("/deleteDepartmentById/{id}")
	public String deleteDepartment(@PathVariable("id") Long departmentId)
	{
		departmentService.deleteDepartmentById(departmentId);
		return "Department Id " + departmentId + " deleted successfully !!";
	}

	@PutMapping("updateDepartmentById/{id}")
	public Department updateDepartmentById(@PathVariable("id") Long departmentId,
			@RequestBody Department department)
	{
		return departmentService.updateDepartmentById(departmentId, department);
	}

}
