package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Address;
import com.example.entity.Student;
import com.example.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class AppService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public void saveData() {

        Student raja = new Student("Raja", 700809);

        Address a1 = new Address("Tikabali", "Bangalore", "Karnataka", null);
        Address a2 = new Address("Arabaka", "Bhubaneswar", "Odisha", null);
        Address a3 = new Address("Rajeevnagar", "Bangalore", "Karnataka", null);

        // 🔥 Use helper methods (VERY IMPORTANT)
        raja.addAddress(a1);
        raja.addAddress(a2);
        raja.addAddress(a3);

        // ✅ Single save (cascade handles children)
        studentRepository.save(raja);

        System.out.println("Data saved successfully...");
    }

    @Transactional
    public void getData() {
        Student student = studentRepository.findById(1).orElseThrow();

        System.out.println(student);

        // Access addresses (LAZY → works inside transaction)
        student.getAddresses().forEach(System.out::println);
    }
}