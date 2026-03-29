package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping
	public String test(){
		return "User service is working";
	}
	
	@GetMapping
	public String getById(@PathVariable int id) { 
		return "Get mapping is working";
	}
	
	

}
