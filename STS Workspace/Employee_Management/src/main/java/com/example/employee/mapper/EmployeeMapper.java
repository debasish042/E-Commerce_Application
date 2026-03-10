package com.example.employee.mapper;

import com.example.employee.Entity.Employee;
import com.example.employee.dto.EmployeeDTO;

public class EmployeeMapper {
	
	public static EmployeeDTO mapToDTO(Employee employee) {
	
	EmployeeDTO dto= new EmployeeDTO();
	
	dto.setId(employee.getId());
	dto.setName(employee.getName());
	dto.setEmail(employee.getEmail());
	dto.setDepartment(employee.getDepartment());
	dto.setSalary(employee.getSalary());
	return dto;
	}
	
	public static Employee mapToEntity(EmployeeDTO dto) {
		
		Employee employee = new Employee();
		
		employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());

        return employee;
		
		
	}

}
