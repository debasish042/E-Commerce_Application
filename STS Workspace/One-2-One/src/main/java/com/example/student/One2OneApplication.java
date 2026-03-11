package com.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.student.service.AppService;

@SpringBootApplication
public class One2OneApplication implements CommandLineRunner {
	
	@Autowired
	AppService appService;

	public static void main(String[] args) {
		SpringApplication.run(One2OneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		appService.saveData();
		appService.getStudentById();
	}

}
