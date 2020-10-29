package com.app.jdbc.dao;

import com.app.jdbc.model.Employee;

//DAO - Data Access Object
//A DAO represents that all the code which is related  to your DB or persistence or
//storage will be written inside this.
public interface EmployeeDAO {
	
	public int createEmployee(Employee employee);
	
	public int updateEmployeeContact(int id, String phone);
	
	public void deleteEmployee(int id);
	
	public Employee getEmployeeId(int id);
}
