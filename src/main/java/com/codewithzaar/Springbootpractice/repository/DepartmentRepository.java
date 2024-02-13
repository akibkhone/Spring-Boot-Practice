package com.codewithzaar.Springbootpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithzaar.Springbootpractice.entity.Department;

/**
 * This interface extends JpaRepository, which provides CRUD operations for the
 * Department entity, and Long represents the type of the primary key.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>
{

	
	public Department findTop1ByDepartmentName(String departmentName);
	
	public Department findTop1ByDepartmentNameIgnoreCase(String departmentName);

}
