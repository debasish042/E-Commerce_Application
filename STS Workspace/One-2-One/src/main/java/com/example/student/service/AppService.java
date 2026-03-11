package com.example.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.entity.Address;
import com.example.student.entity.Student;
import com.example.student.repository.AddressRepository;
import com.example.student.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class AppService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Transactional
	public void saveData() {
		
		Student student = new Student();
		student.setStudentName("Debasish Sahu");
		student.setNumber(700896L);
		
		
		Address address= new Address();
		address.setHouseLocation("Tikabali");
		address.setCity("Kandhamal");
		address.setState("Odisha");
		
		student.setAddress(address);
		
		studentRepo.save(student);
		
		
	}
	@Transactional
	public void getStudentById() {
		
		Student student = studentRepo.findById(2)
		        .orElseThrow(() -> new RuntimeException("Student not found"));
		System.out.println(student);
		student.getAddress().getCity();
		
		Address address = student.getAddress();
		
		System.out.println(address.getHouseLocation());
	}

}
