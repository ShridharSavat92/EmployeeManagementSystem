package com.spring.empManagement.EmployeeManagement.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.empManagement.EmployeeManagement.model.Company;
import com.spring.empManagement.EmployeeManagement.model.Employee;
import com.spring.empManagement.EmployeeManagement.repository.CompRepo;
import com.spring.empManagement.EmployeeManagement.repository.EmpRepo;

@RestController
public class CompController {

	@Autowired
	CompRepo compRepo;
	
	@Autowired
	EmpRepo empRepo;
	
	@PostMapping("/SaveRecords")
	public Company saveCompanyRecords(@RequestBody Company comp) {
		List<Employee> listOfEmployees =comp.getListOfEmployee();
		List<Employee> res=new ArrayList();
		if(listOfEmployees.isEmpty()) {
			comp=compRepo.save(comp);
		}else {
			comp=compRepo.save(comp);
			for(Employee emp:listOfEmployees) {
				emp.setCompany(comp);
				res.add(empRepo.save(emp));
			}
			
			comp.setListOfEmployee(listOfEmployees);
		}
		
		return comp;
	}
	
	@PutMapping("/UpdateRecords")
	public Company updateCompanyRecords(@RequestBody Company comp) {
		return saveCompanyRecords(comp);
	
	}
	
	@DeleteMapping("/DeleteRecords")
	public String deleteCompanyRecords(@RequestParam int id) {
		Optional<Company> companyRecords=compRepo.findById(id);
		if(companyRecords.isPresent()) {
			compRepo.deleteById(id);
			return "Records has been successfully deleted";
		}else {
			return "Records not found";
		}
		
	}
	
	@GetMapping("/GetCompanyRecordById")
	public Optional<Company> getCompanyRecords(@RequestParam int id) {
		return compRepo.findById(id);
	}
	
	@GetMapping("/GetEmployeeRecordsById")
	public Optional<Employee> getEmployeeRecords(@RequestParam int id){
		return empRepo.findById(id);
	}
	
	@GetMapping("/GetCompanyRecordsByDate")
	public List<Company> getCompanyRecordsByDate(Date registerDate){
		return compRepo.findByRegisterDate(registerDate);
	}
	
	@GetMapping("/GetEmployeeRecordsByDate")
	public List<Employee> getEmployeeRecordsByDate(@RequestParam Date joiningDate){
		return empRepo.findByJoiningDate(joiningDate);
	}
	
	@GetMapping("/GetEmployeeRecordsByYear")
	public List<Employee> getEmployeeRecordsByYear(@RequestParam int year){
		return empRepo.getByYear(year);
	}
	
	@GetMapping("/GetEmployeeRecordsByMonth")
	public List<Employee> getEmployeeRecordByMonth(@RequestParam int month){
		return empRepo.getByMonth(month);
	}
}
	
