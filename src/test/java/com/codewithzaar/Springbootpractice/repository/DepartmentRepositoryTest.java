package com.codewithzaar.Springbootpractice.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.codewithzaar.Springbootpractice.entity.Department;

@DataJpaTest
public class DepartmentRepositoryTest
{

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	void setUp() throws Exception
	{
		Department department = 
				Department.builder().departmentName("IT").departmentCode("IT-001").departmentAddress(
						"Mumbai"
				).build();
		entityManager.persist(department);
	}

	@Test
	void testWhenFindDepartmentById()
	{
		Department department = departmentRepository.findById(1L).get();
		assertEquals("Mumbai", department.getDepartmentAddress());
	}

}
