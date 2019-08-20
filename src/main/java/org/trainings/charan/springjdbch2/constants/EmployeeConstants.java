package org.trainings.charan.springjdbch2.constants;

public interface EmployeeConstants {

	String GET_ALL_EMPLOYEES="select * from employees";

	String GET_EMPLOYEE_BY_ID="select * from employees where id=?";
	String INSERT_EMPLOYEE="insert into employees(name,dob,email) values(?,?,?)";

	String UPDATE_EMPLOYEE ="update employees set name=?,dob=?,email=? where id=?";

	String DELETE_EMPLOYEE = "delete from employees where id=?";
	String GET_EMPLOYEE_BY_NAME_AND_EMAIL="select * from employees where name= :name AND email= :email";
	String QGET_EMPLOYEE_BY_NAME_AND_EMAIL="select * from employees where name=? AND email=?";

	String INSERT_ADDRESS = "INSERT INTO ADDRESS(EMPLOYEE_ID,STREET,CITY,STATE,PINCODE) VALUES(?,?,?,?,?)";
}
