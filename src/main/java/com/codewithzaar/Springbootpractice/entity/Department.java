package com.codewithzaar.Springbootpractice.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // generates getters, setters, toString(), equals(), and hashCode() methods
@NoArgsConstructor // generates a no-args constructor.
@AllArgsConstructor // generates a constructor with all fields as arguments.
@Builder
@Entity // marks a Java class as a persistent entity, representing a table in db.
public class Department
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;

	@NotBlank(message = "Please add a department name.")
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;

}
