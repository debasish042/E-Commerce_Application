package com.example.student.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Students")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int studentId;
	
	private Long number;
	
	private String studentName;
	
	@OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;
	
	public Student() {
	}
	
	
	public Student(int i, long l, String string) {
		super();
	}
	
	public Student(int studentId,Long number,String studentName,Address address) {
		this.studentId=studentId;
		this.number=number;
		this.studentName=studentName;
		this.address=address;
		
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {this.studentId=studentId;}
	
	public Long getNumber() {return number;}
	
	public void setNumber(Long number) {this.number=number;}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName=studentName;
	}
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", number=" + number + ", studentName=" + studentName + ", address="
				+ address + "]";
	}
	
	

}
