package org.trainings.charan.springjdbch2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trainings.charan.springjdbch2.dao.EmployeeNameDAO;
import org.trainings.charan.springjdbch2.dao.EmployeeVODAO;
import org.trainings.charan.springjdbch2.model.Employee;
import org.trainings.charan.springjdbch2.model.EmployeeVO;

@Service
public class EmployeeNamedService {
	@Autowired
	private EmployeeNameDAO employeeNamedDAO;
	@Autowired
	private EmployeeVODAO employeeVODAO;
	public Employee getEmployeeByNameAndEmail(String name,String email) {
		return employeeNamedDAO.getEmployeeByNameAndEmail(name, email);
		
	}
	public EmployeeVO getEmployeeWithAddressById(Integer id) {
		return employeeVODAO.getEmployeeVOById(id);
	}
	
	public void AddEmployeeDAO(EmployeeVO emp) {
		employeeVODAO.addEmployeeVO(emp);
	}
	
}
