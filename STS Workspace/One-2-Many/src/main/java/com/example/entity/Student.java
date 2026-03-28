package com.example.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    private String name;
    private int number;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Address> addresses = new ArrayList<>();

    public Student() {}

    public Student(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    // 🔥 Helper methods (VERY IMPORTANT)
    public void addAddress(Address address) {
        addresses.add(address);
        address.setStudent(this);
    }

    public void removeAddress(Address address) {
        addresses.remove(address);
        address.setStudent(null);
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId +
                ", name=" + name +
                ", number=" + number + "]";
    }
}