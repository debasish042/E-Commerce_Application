package com.example.employee.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.employee.Entity.Employee;
import com.example.employee.dto.EmployeeDTO;

public interface EmployeeInterface {
	
	EmployeeDTO saveEmployee(EmployeeDTO employee);
	
	List<EmployeeDTO> saveEmployees(List<EmployeeDTO> employeesDTOs);
	
	List<EmployeeDTO> getAllEmployees();
	
	EmployeeDTO getEmployeeById(Long id);
	
	void deleteEmployee(Long id);
	
	List<EmployeeDTO> getEmployeesByDepartment(String department);
	
	List<EmployeeDTO> getEmployeesSalaryGreaterThan(double salary);
	
	List<EmployeeDTO> searchEmployeeByName(String keyword);
	
	List<EmployeeDTO> getLowPayingEmployees(String department,double salary);
	
	Page<EmployeeDTO> getEmployeesWithPagination(int page,int size);
	
	Page<EmployeeDTO> getEmployeewithPaginationAndSorting(int page,int size,String field);
	
	List<EmployeeDTO> getEmployeesByFilter(String department, double salary);

}
