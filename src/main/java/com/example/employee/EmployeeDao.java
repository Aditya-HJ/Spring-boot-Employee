package com.example.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository empres;
	public String addEmployee(Employee e) {
		empres.save(e);
		return "Successfully saved";
	}
	public String addEmployee(List<Employee> e) {
		empres.saveAll(e);
		return "Successfully saved";
	}
	public Employee addEmployee(int e) {
		return empres.findById(e).get();
	}
	public List<Employee> addEmployee() {
		return empres.findAll();
	}
	public String addEmployee1(int e) {
		empres.deleteById(e);
		return "Successfully deleted";
	}
	public String addEmployee2() {
		empres.deleteAll();
		return "Successfully deleted";
	}
	public String updateEmployee(Employee e) {
		empres.save(e);
		return "Successfully updated";
	}
	public List<Employee> findEmpBySalary(int s1,int s2) {
		return empres.getBySalary(s1,s2);
	}
	public List<Employee> findEmpByGender(String gender) {
		return empres.getByGender(gender);
	}
	public List<Employee> findEmpByName(String name) {
		return empres.getByName(name);
	}
	public List<String> findEmpByNameAge() {
		return empres.getByNameAge();
	}
	public List<String> findByName() {
		return empres.getByName();
	}
	public String findByAge(Employee e) {
		empres.save(e);
		return "Saved Successfully";
	}
	public Employee getById(int e) throws EmpIdNotFoundException {
		return empres.findById(e).orElseThrow(()->new EmpIdNotFoundException());
	}
	public List<Employee> findByEmpName(String name) {
		return empres.findAll();
	}
	public List<Employee> findByEmpSalary(int salary) {
		return empres.findAll();
	}
	public List<Employee> findByEmpAge(int age) {
		return empres.findAll();
	}
}
