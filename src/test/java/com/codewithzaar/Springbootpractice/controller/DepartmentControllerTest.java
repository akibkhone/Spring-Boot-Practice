package com.codewithzaar.Springbootpractice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.codewithzaar.Springbootpractice.entity.Department;
import com.codewithzaar.Springbootpractice.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest
{

	@Autowired
	private MockMvc mockMvc;

	private Department department;

	@MockBean
	private DepartmentService departmentService;

	@BeforeEach
	void setUp() throws Exception
	{
		department = Department.builder().departmentId((long) 1).departmentName("IT").departmentCode(
				"IT-001"
		).departmentAddress("Mumbai").build();
	}

	@Test
	public void testSaveDepartment() throws Exception
	{
		Department inputDepartment = Department.builder().departmentName("IT").departmentCode("IT-001").departmentAddress(
				"Mumbai"
		).build();
		Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
		mockMvc.perform(
				MockMvcRequestBuilders.post("/saveDepartment").contentType(MediaType.APPLICATION_JSON).content(
						"{\r\n" + "    \"departmentName\": \"IT\",\r\n" + "    \"departmentAddress\": \"Mumbai\",\r\n"
								+ "    \"departmentCode\": \"IT-001\"\r\n" + "}"
				)
		).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testFetchDepartmentById() throws Exception
	{
		Mockito.when(departmentService.fetchDepartmentById(1L)).thenReturn(Optional.of(department));

		mockMvc.perform(MockMvcRequestBuilders.get("/fetchDepartmentById/1")).andExpect(
				MockMvcResultMatchers.status().isOk()
		).andExpect(MockMvcResultMatchers.jsonPath("$.departmentId").value(1L)).andExpect(
				MockMvcResultMatchers.jsonPath("$.departmentName").value("IT")
		).andExpect(MockMvcResultMatchers.jsonPath("$.departmentAddress").value("Mumbai")).andExpect(
				MockMvcResultMatchers.jsonPath("$.departmentCode").value("IT-001")
		);
	}

	@Test
	public void testFetchDepartments() throws Exception
	{
		Department department1 = new Department(1L, "IT", "IT-001", "Mumbai");
		Department department2 = new Department(2L, "HR", "HR-002", "New York");
		List<Department> departmentList = Arrays.asList(department1, department2);

		Mockito.when(departmentService.fetchDepartmentList()).thenReturn(departmentList);

		mockMvc.perform(MockMvcRequestBuilders.get("/fetchDepartments")).andExpect(
				MockMvcResultMatchers.status().isOk()
		).andExpect(MockMvcResultMatchers.jsonPath("$[0].departmentName").value("IT")).andExpect(
				MockMvcResultMatchers.jsonPath("$[1].departmentName").value("HR")
		);
	}

}
