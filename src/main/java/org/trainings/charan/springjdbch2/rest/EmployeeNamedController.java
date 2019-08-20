package org.trainings.charan.springjdbch2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trainings.charan.springjdbch2.model.Employee;
import org.trainings.charan.springjdbch2.model.EmployeeVO;
import org.trainings.charan.springjdbch2.service.EmployeeNamedService;

@RestController
@RequestMapping("/employee-named")
public class EmployeeNamedController {
	@Autowired
	private EmployeeNamedService employeeNamedService;
	@GetMapping("/{name}/{email}")
	public Employee getEmployeeByNameAndEmail(String name,String email) {
		return employeeNamedService.getEmployeeByNameAndEmail(name, email);
	}
	@GetMapping("/address/{id}")
	public EmployeeVO getEmployeeVOWithAddressById(Integer id) {
		return employeeNamedService.getEmployeeWithAddressById(id);
	}
	@PostMapping("/insertaddress")
	public void getEmployeeVOWithAddressById(@RequestBody EmployeeVO empvo) {
		employeeNamedService.AddEmployeeDAO(empvo);
	}
}
