package com.spring.empManagement.EmployeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.empManagement.EmployeeManagement.model.Employee;
import com.spring.empManagement.EmployeeManagement.repository.EmpRepo;

@RestController
public class EmpController {
	@Autowired
	EmpRepo empRepo;
	
}
