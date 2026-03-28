package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ FIXED
    private int addressId;

    private String houseDetails;
    private String city;
    private String state;

    @ManyToOne(fetch = FetchType.LAZY) // ✅ better performance
    @JoinColumn(name = "student_id_fk")
    private Student student;

    public Address() {}

    public Address(String houseDetails, String city, String state, Student student) {
        this.houseDetails = houseDetails;
        this.city = city;
        this.state = state;
        this.student = student;
    }

    public int getAddressId() {
        return addressId;
    }

    public String getHouseDetails() {
        return houseDetails;
    }

    public void setHouseDetails(String houseDetails) {
        this.houseDetails = houseDetails;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

   
    @Override
    public String toString() {
        return "Address [addressId=" + addressId +
                ", houseDetails=" + houseDetails +
                ", city=" + city +
                ", state=" + state + "]";
    }
}