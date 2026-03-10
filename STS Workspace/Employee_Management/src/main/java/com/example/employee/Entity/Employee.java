package com.example.employee.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Name can not be Empty")
	private String name;
	
	@Email(message="Invalid email format")
	private String email;
	
	@NotBlank(message="departmet required")
	private String department;
	
	@Positive(message="salary must be positive")
	private double salary;
	
	public Employee() {
		super();
	}
	public Employee(Long id, String name, String email, String department, double salary) {
		super();
		this.id= id;
		this.name= name;
		this.email=email;
		this.department=department;
		this.salary= salary;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", department=" + department + ", salary="
				+ salary + "]";
	}
	
	
	

}
