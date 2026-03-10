package com.example.employee.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.employee.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	
	List<Employee> findByDepartment(String department);
	
	List<Employee> findBySalaryGreaterThan(double salary);
	
	List<Employee> findByNameContaining(String keyword);
	
	@Query("select e from Employee e where e.department= :department and e.salary > :salary" )
	List<Employee> findHighSalaryEmployees(
			@Param("department")String department,
			@Param("salary")double salary);
	
	@Query(value= "select * from Employee where department= :department and salary < :salary", nativeQuery=true)
	List<Employee> findLowPayingEmployees(
			@Param("department")String department,
			@Param("salary")double salary);
	
	
	@Query(value="""
			 select e from Employee e
                   where(:department is null or e.department = :department)
                   and (:salary is null or e.salary >= :salary)""")
	List<Employee> filterEmployee(
			@Param("department") String department,
			@Param("salary") double salary);

}
