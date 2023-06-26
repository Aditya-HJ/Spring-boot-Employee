package com.example.employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empdao;
	public String addEmployee(Employee e) {
		return empdao.addEmployee(e);
	}
	public String addEmployee(List<Employee> e) {
		return empdao.addEmployee(e);
	}
	public Employee addEmployee(int e) throws EmpIdNotFoundException {
		return empdao.getById(e);
	}
	public List<Employee> addEmployee() {
		return empdao.addEmployee();
	}
	public String addEmployee1(int e) {
		return empdao.addEmployee1(e);
	}
	public String addEmployee2() {
		return empdao.addEmployee2();
	}
	public String updateEmployee(Employee e) {
		return empdao.updateEmployee(e);
	}
	public List<Employee> getAllName(String name) {
		List<Employee> allEmp=empdao.addEmployee();
		return allEmp.stream().filter(x->x.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
	}
	public List<Employee> getGender1() {
		List<Employee> male=empdao.addEmployee();
		return male.stream().filter(x->x.getGender().equalsIgnoreCase("female")).collect(Collectors.toList());
	}
	public Employee getMax() {
		List<Employee> maxsal=empdao.addEmployee();
		return maxsal.stream().max(Comparator.comparing(Employee::getSalary)).get();
	}
	public Employee getMin() {
		List<Employee> minsal=empdao.addEmployee();
		return minsal.stream().min(Comparator.comparing(Employee::getSalary)).get();
	}
	public List<Employee> getAge() {
		List<Employee> age=empdao.addEmployee();
		return age.stream().filter(x->x.getAge()>=28).collect(Collectors.toList());
	}
	public List<Employee> getHighest() {
		List<Employee> high=empdao.addEmployee();
		return high.stream().filter(x->x.getAge()>28 && x.getSalary()>50000).collect(Collectors.toList());
	}
	public List<Employee> findEmpBySalary(int s1,int s2) {
		return empdao.findEmpBySalary(s1,s2);
	}
	public List<Employee> findEmpByGender(String gender) {
		return empdao.findEmpByGender(gender);
	}
	public List<Employee> findEmpByName(String name) {
		return empdao.findEmpByName(name);
	}
	public List<String> findEmpByNameAge() {
		return empdao.findEmpByNameAge();
	}
	public List<String> findByName() {
		return empdao.findByName();
	}
	public String findByAge(Employee e) {
		try {
		if(e.getAge()>=18) {
			return empdao.findByAge(e);
		}
		else {
			throw new AgeException();
		}
		}
		catch(AgeException a) {
			a.printStackTrace();
			return "AgeException";
			
			
		}
	}
	public List<Employee> findByEmpName(String name) throws EmpNameException{
		List<Employee> li = empdao.findEmpByName(name);
		List<Employee> l1=li.stream().filter(x->x.getName().equalsIgnoreCase(name)).toList();
		if(l1.isEmpty()) {
			 throw new EmpNameException();
		}
		else {
			return l1;
		}
	}
	public List<Employee> findByEmpSalary(int salary) throws SalaryNotFoundException {
		List<Employee> sal=empdao.findByEmpSalary(salary);
		List<Employee> sal1 = sal.stream().filter(x->x.getSalary()>salary).toList();
		if(sal1.isEmpty()) {
			throw new SalaryNotFoundException();
		}
		else {
			return sal1;
		}
	}
//	public List<Employee> findByEmpAge(int age) {
//		if(age.getAge()>=18) {
//			return empdao.findByEmpAge(age);
//		}
//		else {
//			throw new AgeException();
//		}
//	}
}
