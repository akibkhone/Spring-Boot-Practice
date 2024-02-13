package com.codewithzaar.Springbootpractice.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.codewithzaar.Springbootpractice.entity.Department;
import com.codewithzaar.Springbootpractice.exception.DepartmentNotFoundException;
import com.codewithzaar.Springbootpractice.repository.DepartmentRepository;

@SpringBootTest
public class DepartmentServiceTest
{

	@Autowired
	private DepartmentService departmentService;

	@MockBean
	private DepartmentRepository departmentRepository;

	@BeforeEach
	void setUp() throws Exception
	{
		Optional<Department> department = Optional.of(
				Department.builder().departmentId((long) 1).departmentName("IT").departmentCode("IT-001").departmentAddress(
						"Mumbai"
				).build()
		);
		Mockito.when(departmentRepository.findById((long) 1)).thenReturn(department);
		Mockito.when(departmentRepository.findAll()).thenReturn(Collections.singletonList(department.get()));
	}

	@Test
	@DisplayName("Test fetchDepartmentById")
	public void testFetchDepartmentByIdWhenDepartmentPresent() throws DepartmentNotFoundException
	{
		Optional<Department> department = departmentService.fetchDepartmentById((long) 1);
		assertTrue(department.isPresent());
		assertEquals("IT", department.get().getDepartmentName());
	}

	@Test
	public void testFetchDepartmentByIdWhenDepartmentNotPresent()
	{
		assertThrows(DepartmentNotFoundException.class, () -> {
			departmentService.fetchDepartmentById((long) 2);
		});
	}

	@Test
	public void testFetchDepartmentList() throws DepartmentNotFoundException
	{
		List<Department> departments = departmentService.fetchDepartmentList();
		assertTrue(!departments.isEmpty());
		assertEquals("IT", departments.get(0).getDepartmentName());
	}

	@Test
	public void testUpdateDepartmentById() throws DepartmentNotFoundException
	{
		// Create a new department object with updated values
		Department department = Department.builder().departmentId((long) 1).departmentName("HR").departmentCode(
				"HR-001"
		).departmentAddress("Pune").build();

		// Mock the existing department to be returned by findById
		Department existingDepartment = Department.builder().departmentId((long) 1).departmentName("IT").departmentCode(
				"IT-001"
		).departmentAddress("Mumbai").build();
		Mockito.when(departmentRepository.findById((long) 1)).thenReturn(Optional.of(existingDepartment));

		// Mock the save operation to return the updated department
		Mockito.when(departmentRepository.save(existingDepartment)).thenReturn(department);

		// Call the updateDepartmentById method
		Department updatedDepartment = departmentService.updateDepartmentById((long) 1, department);

		// Assertions
		assertEquals("HR", updatedDepartment.getDepartmentName());
		assertEquals("Pune", updatedDepartment.getDepartmentAddress());
		assertEquals("HR-001", updatedDepartment.getDepartmentCode());
	}

}
