package com.example.employee.sevice.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.employee.Entity.Employee;
import com.example.employee.Repository.EmployeeRepository;
import com.example.employee.Service.EmployeeInterface;
import com.example.employee.dto.EmployeeDTO;
import com.example.employee.exception.ResourceNotFoundException;
import com.example.employee.exception.ResultNotFoundException;
import com.example.employee.mapper.EmployeeMapper;

@Service
public class EmployeeServiceImpl implements EmployeeInterface {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Save single employee
    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
    	
    	logger.info("Saving Employee with name:{}",employeeDTO.getName());

       Employee employee = EmployeeMapper.mapToEntity(employeeDTO);
       
       Employee savedEmployee = employeeRepository.save(employee);
       
       logger.info("Employee saved with name:{}",savedEmployee.getName());
       
       return EmployeeMapper.mapToDTO(savedEmployee);
    }

    // Save multiple employees
    @Override
    public List<EmployeeDTO> saveEmployees(List<EmployeeDTO> employeeDTOs) {

        // Convert DTO → Entity
        List<Employee> employees = employeeDTOs.stream()
        		.map(EmployeeMapper::mapToEntity)
        		.toList();

        // Save in DB
        List<Employee> savedEmployees = employeeRepository.saveAll(employees);

        // Convert Entity → DTO
        return savedEmployees.stream()
        		.map(EmployeeMapper::mapToDTO)
        		.toList();
    }

    // Get all employees
    @Override
    public List<EmployeeDTO> getAllEmployees() {
    	logger.info("Fetching all the Employees");

        List<Employee> employees = employeeRepository.findAll();
       

        return employeeRepository.findAll()
        		.stream()
        		.map(EmployeeMapper::mapToDTO)
        		.collect(Collectors.toList());
    }

    // Get employee by ID
    @Override
    public EmployeeDTO getEmployeeById(Long id) {
    	logger.info("Fetching Employee with id:{}" +id);

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        return EmployeeMapper.mapToDTO(employee);
    }

    // Delete employee
    @Override
    public void deleteEmployee(Long id) {
    	
    	logger.info("Deleting employee with id:{}"+id);
        employeeRepository.deleteById(id);
        
        logger.info("Employee deleted successfully");
    }
    
    @Override
    public List<EmployeeDTO> getEmployeesByDepartment(String department){
    	List<Employee> employees= employeeRepository.findByDepartment(department);
    	
    	return employees.stream()
    			.map(EmployeeMapper::mapToDTO)
    			.toList();
    }
    
    public List<EmployeeDTO> getEmployeesSalaryGreaterThan(double salary){
    	
    	List<Employee> employees = employeeRepository.findBySalaryGreaterThan(salary);
    	
    	return employees.stream().map(EmployeeMapper::mapToDTO).toList();
    	
    }
    
    public List<EmployeeDTO> searchEmployeeByName(String keyword){
    	
    	List<Employee> employee= employeeRepository.findByNameContaining(keyword);
    	
    	return employee.stream().map(EmployeeMapper::mapToDTO).toList();
    }

    @Override
    public List<EmployeeDTO> getLowPayingEmployees(String department, double salary) {

        logger.info("Fetching low paying employees for department {} with salary < {}", department, salary);

        List<Employee> employees = employeeRepository.findLowPayingEmployees(department, salary);

        if (employees.isEmpty()) {
            logger.warn("No employees found for department {} with salary < {}", department, salary);
            throw new ResultNotFoundException(
                    "No low paying employees found in department: " + department +
                    " with salary less than " + salary);
        }

        return employees.stream()
                .map(EmployeeMapper::mapToDTO)
                .toList();
    }
    
    @Override
    public Page<EmployeeDTO> getEmployeesWithPagination(int page, int size) {

        Page<Employee> employeePage =
                employeeRepository.findAll(PageRequest.of(page, size));

        return employeePage.map(EmployeeMapper::mapToDTO);
    }

	@Override
	public Page<EmployeeDTO> getEmployeewithPaginationAndSorting(int page, int size, String field) {
		
		Page<Employee> employeePage = employeeRepository.findAll(PageRequest.of(page, size,Sort.by(field)));
		
		
		return employeePage.map(EmployeeMapper::mapToDTO);
	}

	@Override
	public List<EmployeeDTO> getEmployeesByFilter(String department, double salary) {
		
		logger.info("filtering employees with department {} and salary {}",department,salary);
		List<Employee> employees= employeeRepository.filterEmployee(department, salary);
		if(employees.isEmpty()) {
			logger.warn("No such employees found with department{} and salary{}",department,salary);
			throw new ResultNotFoundException(
					"No such Employee Found");
		}
		
		return employees.stream().map(EmployeeMapper::mapToDTO).toList();
	}

	

}