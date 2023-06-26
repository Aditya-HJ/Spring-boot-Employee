
package com.example.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(value="/emp")
public class EmployeeController {
	@Autowired
	EmployeeService empser;
	@PostMapping(value="/add")
	public String addEmployee(@RequestBody Employee e) {
		return empser.addEmployee(e);
	}
	@PostMapping(value="/addAll")
	public String addEmployee(@RequestBody List<Employee> e) {
		return empser.addEmployee(e);
	}
	@GetMapping(value="/Read/{e}")
	public Employee readEmployee(@PathVariable int e) throws EmpIdNotFoundException {
		return empser.addEmployee(e);
	}
	@GetMapping(value="/Read")
	public List<Employee> readAllEmployee() {
		return empser.addEmployee();
	}
	@DeleteMapping(value="/del/{e}")
	public String delEmployee(@PathVariable int e) {
		return empser.addEmployee1(e);
	}
	@DeleteMapping(value="/delAll")
	public String delAllEmployee2() {
		return empser.addEmployee2();	
	}
	@PutMapping(value="/update/{e}")	
	public String updateEmployee(@RequestBody Employee e) {
		return empser.updateEmployee(e);
	}
	@GetMapping(value="/getAllName/{name}")
	public List<Employee> getAllName(@PathVariable String name) {
		return empser.getAllName(name);
	}
	@GetMapping(value="/getGender")
	public List<Employee> getGender1() {
		return empser.getGender1();
	}
	@GetMapping(value="/getMax")
	public Employee getMax() {
		return empser.getMax();
	}
	@GetMapping(value="/getMin")
	public Employee getMin() {
		return empser.getMin();
	}
	@GetMapping(value="/Age")
	public List<Employee> getAge() {
		return empser.getAge(); 
	}
	@GetMapping(value="/high")
	public List<Employee> getHighest() {
		return empser.getHighest();
	}
	@GetMapping(value="/findBySalary/{s1}/{s2}")
	public List<Employee> findEmpBySalary(@PathVariable int s1,@PathVariable int s2) {
		return empser.findEmpBySalary(s1,s2);
	}
	@GetMapping(value="/findByGender/{gender}")
	public List<Employee> findByGender(@PathVariable String gender) {
		return empser.findEmpByGender(gender);
	}
	@GetMapping(value="/findName/{name}")
	public List<Employee> findEmpByName(@PathVariable String name) {
		return empser.findEmpByName(name);
	}
	@GetMapping(value="/findByNameAge")
	public List<String> findByNameAge() {
		return empser.findEmpByNameAge();
	}
	@GetMapping(value="/findByName")
	public List<String> findByName() {
		return empser.findByName();
	}
	@PostMapping(value="/findByAgeEligibility")
	public String findByAge(@RequestBody Employee e) {
		return empser.findByAge(e);
	}
	@GetMapping(value="/EmpNameException/{name}")
	public List<Employee> findByEmpName(@PathVariable String name) throws EmpNameException {
		return empser.findByEmpName(name);
	}
	@GetMapping(value="/SalaryException/{salary}")
	public List<Employee> findByEmpSalary(@PathVariable int salary) throws SalaryNotFoundException {
		return empser.findByEmpSalary(salary);
	}
}
