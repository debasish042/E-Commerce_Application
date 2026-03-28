package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.service.AppService;

@SpringBootApplication
public class One2ManyApplication implements CommandLineRunner {

    @Autowired
    private AppService appService;

    public static void main(String[] args) {
        SpringApplication.run(One2ManyApplication.class, args);
    }

    @Override
    public void run(String... args) {
        appService.saveData();
        appService.getData();
    }
}