package com.spring.empManagement.EmployeeManagement.repository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.empManagement.EmployeeManagement.model.Employee;
@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {
	public List<Employee> findByJoiningDate(Date joiningDate);
	
	@Query
	("select e from Employee e where year(e.joiningDate) = ?1")
	List<Employee> getByYear(int year);
	
	@Query
	("select e from Employee e where month(e.joiningDate) = ?1")
	List<Employee> getByMonth(int month);

}
