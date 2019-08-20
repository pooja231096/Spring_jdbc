package org.trainings.charan.springjdbch2.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trainings.charan.springjdbch2.entity.EmployeeEntity;
import org.trainings.charan.springjdbch2.model.Employee;
import org.trainings.charan.springjdbch2.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
@Autowired
private EmployeeService empservice;
	@GetMapping("/all")
	public List<Employee> getAllEmployees() {
		return empservice.getAllEmployees();
	}
	@GetMapping("/id/{id}")
	public Employee getEmployeeById(@PathVariable("id") Integer id) {
	return empservice.getEmployeeById(id);
	}
	@GetMapping("/name/{name}/email/{email}")
	public Employee getAllEmployees2(@PathVariable("name") String name,@PathVariable("email") String email) {
		return empservice.getAllEmployees2(name, email);
	}
	@PostMapping("/add")
	public ResponseEntity<Boolean> addEmployee(Employee emp) {
		boolean result=empservice.insertEmployee(emp);
		return new ResponseEntity<Boolean>(result,HttpStatus.OK);
	}
	@PostMapping("/update")
	public ResponseEntity<Boolean> updateEmployee(Employee emp) {
		boolean result=empservice.updateEmployee(emp);
		return new ResponseEntity<Boolean>(result,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable("id") Integer id) {
return new ResponseEntity<Boolean>(empservice.deleteEmployee(id),HttpStatus.OK);
	}
	@GetMapping("/all/jpa")
	public List<EmployeeEntity> getAllEmployeesWithJpa() {
		return empservice.getAllEmployeesWithJpa();
	}
}
