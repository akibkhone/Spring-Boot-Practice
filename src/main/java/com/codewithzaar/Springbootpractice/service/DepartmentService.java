package com.codewithzaar.Springbootpractice.service;

import java.util.List;
import java.util.Optional;

import com.codewithzaar.Springbootpractice.entity.Department;

public interface DepartmentService
{

	public Department saveDepartment(Department department);

	public Optional<Department> fetchDepartmentById(Long departmentId);

	public List<Department> fetchDepartmentList();

	public void deleteDepartmentById(Long departmentId);

	public Department updateDepartmentById(Long departmentId, Department department);

}
