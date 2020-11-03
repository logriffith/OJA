package com.app.jdbc.dao.impl;

public class EmployeeQueries {
	
	public static final String INSERT_EMPLOYEE = "insert into test.employees (id,occupation,email,phone_number,status,employer)"
			+ "values (?,?,?,?,?,?)";
	
	public static final String UPDATE_EMPLOYEE_PHONE = "update test.employees set phone_number=? where id=?";
	
	public static final String DELETE_EMPLOYEE = "delete from test.employees where id = ?";
	
	public static final String GET_EMPLOYEE_BY_ID = "select occupation,email,phone_number,status,employer from test.employees where id = ?";
}
