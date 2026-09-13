package com.JwtDemoApplication.JwtDemoApplication.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String empUserName;
	String empPassword;
	String empName;
	String empEmail;
	int empPhone;
	String empAddress;

}
