package org.trainings.charan.springjdbch2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.trainings.charan.springjdbch2.dao.EmployeeDAO;
import org.trainings.charan.springjdbch2.dao.EmployeeNameDAO;
import org.trainings.charan.springjdbch2.entity.EmployeeEntity;
import org.trainings.charan.springjdbch2.model.Employee;
import org.trainings.charan.springjdbch2.repository.EmployeeRepository;

import com.google.common.base.Optional;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private EmployeeRepository empRepos;
	@Autowired
	private EmployeeNameDAO empNameDAO;
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

public Employee getEmployeeById(Integer id) {
return employeeDAO.getEmployeeById(id)	;
}
public boolean insertEmployee(Employee emp) {
	return employeeDAO.insertEmployee(emp);
}
public boolean updateEmployee(Employee emp) {
	return employeeDAO.updateEmployee(emp);
}
public boolean deleteEmployee(Integer id) {
	return employeeDAO.deleteEmployee(id);
}
public Employee getAllEmployees2(String name,String email) {
	return empNameDAO.getEmployeeByNameAndEmail(name, email);
}
public List<EmployeeEntity> getAllEmployeesWithJpa(){
	return empRepos.findAll();
}
public void addEmployeeWithJpa(EmployeeEntity emp) {
	empRepos.save(emp);
}
public EmployeeEntity findEmployeeById(Integer id) {
java.util.Optional<EmployeeEntity> empEntity=empRepos.findById(id);
if(empEntity.isPresent()) {
	return empEntity.get();
}
return null;
}
}
