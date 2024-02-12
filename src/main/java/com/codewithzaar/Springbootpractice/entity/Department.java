package com.codewithzaar.Springbootpractice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data // generates getters, setters, toString(), equals(), and hashCode() methods for
			// all fields in your class
//@NoArgsConstructor // generates a no-args constructor.
//@AllArgsConstructor // generates a constructor with all fields as arguments.


@Entity // marks a Java class as a persistent entity, representing a table in the
				// database.
public class Department
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;

	private String departmentName;
	private String departmentAddress;
	private String departmentCode;

	// Getter and Setter methods for departmentId
	public Long getDepartmentId()
	{
		return departmentId;
	}

	public void setDepartmentId(Long departmentId)
	{
		this.departmentId = departmentId;
	}

	// Getter and Setter methods for departmentName
	public String getDepartmentName()
	{
		return departmentName;
	}

	public void setDepartmentName(String departmentName)
	{
		this.departmentName = departmentName;
	}

	// Getter and Setter methods for departmentAddress
	public String getDepartmentAddress()
	{
		return departmentAddress;
	}

	public void setDepartmentAddress(String departmentAddress)
	{
		this.departmentAddress = departmentAddress;
	}

	// Getter and Setter methods for departmentCode
	public String getDepartmentCode()
	{
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode)
	{
		this.departmentCode = departmentCode;
	}

	// No-argument constructor
	public Department()
	{
	}

	// All-argument constructor
	public Department(Long departmentId, String departmentName, String departmentAddress, String departmentCode)
	{
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentAddress = departmentAddress;
		this.departmentCode = departmentCode;
	}

	// toString() method
	@Override
	public String toString()
	{
		return "Department{" + "departmentId=" + departmentId + ", departmentName='" + departmentName + '\''
				+ ", departmentAddress='" + departmentAddress + '\'' + ", departmentCode='" + departmentCode + '\'' + '}';
	}
}
