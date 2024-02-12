package com.codewithzaar.Springbootpractice.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithzaar.Springbootpractice.entity.Department;
import com.codewithzaar.Springbootpractice.repository.DepartmentRepository;

import lombok.extern.log4j.Log4j;

@Service
public class DepartmentServiceImpl implements DepartmentService
{
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department)
	{
		return departmentRepository.save(department);
	}

	@Override
	public Optional<Department> fetchDepartmentById(Long departmentId)
	{
		return departmentRepository.findById(departmentId);
	}

	@Override
	public List<Department> fetchDepartmentList()
	{
		return departmentRepository.findAll();
	}

	@Override
	public void deleteDepartmentById(Long departmentId)
	{
		departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department updateDepartmentById(Long departmentId, Department department)
	{
		Department existingDepartment = departmentRepository.findById(departmentId).get();
		if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName()))
		{
			existingDepartment.setDepartmentName(department.getDepartmentName());
		}
		if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress()))
		{
			existingDepartment.setDepartmentAddress(department.getDepartmentAddress());
		}
		if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode()))
		{
			existingDepartment.setDepartmentCode(department.getDepartmentCode());
		}
		return departmentRepository.save(existingDepartment);
	}

}
