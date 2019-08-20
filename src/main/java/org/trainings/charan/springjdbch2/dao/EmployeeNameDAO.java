package org.trainings.charan.springjdbch2.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.trainings.charan.springjdbch2.constants.EmployeeConstants;
import org.trainings.charan.springjdbch2.model.Employee;

@Repository
public class EmployeeNameDAO {
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public Employee getEmployeeByNameAndEmail(String name, String email) {

		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("name", name);
		paramMap.addValue("email", email);
		return (Employee) namedParameterJdbcTemplate.queryForObject(EmployeeConstants.GET_EMPLOYEE_BY_NAME_AND_EMAIL,
				paramMap, new BeanPropertyRowMapper<>(Employee.class));

	}
}
