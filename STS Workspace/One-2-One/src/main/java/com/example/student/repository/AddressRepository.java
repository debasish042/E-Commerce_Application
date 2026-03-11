package com.example.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>{

}
