package com.example.employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.Entity.Employee;
import com.example.employee.Service.EmployeeInterface;
import com.example.employee.dto.EmployeeDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeInterface employeeService;
	
	
	public EmployeeController(EmployeeInterface employeeService) {
		this.employeeService=employeeService;
	}
	
	@PostMapping("/single")
	public EmployeeDTO saveEmployee(@Valid @RequestBody EmployeeDTO employee) {
		return employeeService.saveEmployee(employee);
	}
	@PostMapping("/bulk")
	public List<EmployeeDTO> saveEmployees(@Valid @RequestBody List<EmployeeDTO> employees) {
	    return employeeService.saveEmployees(employees);
	}
	
	@GetMapping
	public List<EmployeeDTO> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public EmployeeDTO getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}
	
	public void deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
	}
	
	@GetMapping("/department/{department}")
	public List<EmployeeDTO> getEmployeeByDepartment(@PathVariable String department){
		return employeeService.getEmployeesByDepartment(department);
	}
	
	@GetMapping("/salary/{salary}")
	public List<EmployeeDTO> getEmployeesSalaryGreaterThen(@PathVariable double salary){
		return employeeService.getEmployeesSalaryGreaterThan(salary);
	}
	
	@GetMapping("/search")
	public List<EmployeeDTO> searchEmployeeByName(@RequestParam String keyword){
		return employeeService.searchEmployeeByName(keyword);
	}
	@GetMapping("/lowSalary/department")
	public List<EmployeeDTO> getLowPayingEmployees(@RequestParam String department,@RequestParam double salary){
		return employeeService.getLowPayingEmployees(department, salary);
	}
	@GetMapping("/pagination")
	public Page<EmployeeDTO> getEmployeeWithPagination(
			@RequestParam int page,
			@RequestParam int size
			){
		return employeeService.getEmployeesWithPagination(page, size);
	}
	
	@GetMapping("/pagination-sort")
	public Page<EmployeeDTO> getEmployeewithPaginationAndSorting(@RequestParam int page,
			@RequestParam int size,
			@RequestParam String field){
		return employeeService.getEmployeewithPaginationAndSorting(page, size, field);
	}
	
	@GetMapping("/Filter")
	public List<EmployeeDTO> getEmployeesWithFilter(
			@RequestParam(required=false) String department, 
			@RequestParam(required=false) double salary){
		return employeeService.getEmployeesByFilter(department, salary);
	}
	
	
	

}
