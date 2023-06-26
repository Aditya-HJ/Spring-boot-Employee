package com.example.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	@Query(value="select*from employee where salary>? AND salary<?",nativeQuery=true)
	
	public List<Employee> getBySalary(int sal1,int sal2);
	
	@Query(value="select*from employee where gender like ?",nativeQuery=true)
	
	public List<Employee> getByGender(String gender);
	
	@Query(value="select*from employee where name like ?",nativeQuery=true)
	
	public List<Employee> getByName(String name);
	
	@Query(value="select name,age from employee",nativeQuery=true)
	
	public List<String> getByNameAge();
	
	@Query(value="select name from employee",nativeQuery=true)
	
	public List<String> getByName();
}
