package com.example.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
	
	private Long id;
	private String name;
	private String email;
	private String department;
	private double salary;

}
