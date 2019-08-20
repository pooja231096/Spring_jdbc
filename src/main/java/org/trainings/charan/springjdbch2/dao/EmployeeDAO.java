package org.trainings.charan.springjdbch2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.trainings.charan.springjdbch2.constants.EmployeeConstants;
import org.trainings.charan.springjdbch2.model.Employee;

@Repository
public class EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query(EmployeeConstants.GET_ALL_EMPLOYEES, prepareRowMapper());

	}

	public Employee getEmployeeById(Integer Id) {
		return jdbcTemplate.queryForObject(EmployeeConstants.GET_EMPLOYEE_BY_ID, new Object[] { Id },
				prepareRowMapper());
	}

	public boolean insertEmployee(Employee emp) {
		int rows = jdbcTemplate.update(EmployeeConstants.INSERT_EMPLOYEE, emp.getName(), emp.getDob(), emp.getEmail());
		return (rows == 1);
	}

	public boolean updateEmployee(Employee emp) {
		int rows = jdbcTemplate.update(EmployeeConstants.UPDATE_EMPLOYEE, emp.getName(), emp.getDob(), emp.getEmail(),emp.getId());
		return (rows == 1);
	}

	public boolean deleteEmployee(Integer id) {
		int rows = jdbcTemplate.update(EmployeeConstants.DELETE_EMPLOYEE, id);

		return (rows == 1);
	}

	private RowMapper<Employee> prepareRowMapper() {
		return new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setId(rs.getInt("ID"));
				employee.setName(rs.getString("NAME"));
				employee.setEmail(rs.getString("EMAIL"));
				employee.setDob(rs.getDate("DOB"));
				return employee;

			}

		};
	}
}