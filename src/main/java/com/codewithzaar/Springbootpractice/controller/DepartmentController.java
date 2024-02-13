package com.codewithzaar.Springbootpractice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.codewithzaar.Springbootpractice.entity.Department;
import com.codewithzaar.Springbootpractice.exception.DepartmentNotFoundException;
import com.codewithzaar.Springbootpractice.service.DepartmentService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class DepartmentController
{

	@Autowired
	private DepartmentService departmentService;

	// Default spring logger using slf4j, where you don't need to need to add
	// dependency in POM
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

	@PostMapping("/saveDepartment")
	public Department saveDepartment(@Valid @RequestBody Department department)
	{
		LOGGER.info("Saving department detail for departmentId :", department.getDepartmentId());
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/fetchDepartmentById/{id}")
	public Optional<Department> getDepartmentById(@PathVariable("id") Long departmentId)
			throws DepartmentNotFoundException
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
		LOGGER.info("Deleting department detail for departmentId :", departmentId);
		departmentService.deleteDepartmentById(departmentId);
		return "Department Id " + departmentId + " deleted successfully !!";
	}

	@PutMapping("/updateDepartmentById/{id}")
	public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department)
	{
		LOGGER.info("Updating department detail for departmentId :", department.getDepartmentId());
		return departmentService.updateDepartmentById(departmentId, department);
	}

	@GetMapping("/fetchDepartmentByName/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName)
	{
		return departmentService.fetchDepartmentByName(departmentName);
	}

}
