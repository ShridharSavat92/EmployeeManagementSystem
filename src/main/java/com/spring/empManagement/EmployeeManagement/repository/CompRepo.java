package com.spring.empManagement.EmployeeManagement.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.empManagement.EmployeeManagement.model.Company;
@Repository
public interface CompRepo extends JpaRepository<Company, Integer> {
	
	public List<Company> findByRegisterDate(Date registerDate);

}
