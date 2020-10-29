package com.app.jdbc.dao;

import com.app.jdbc.exception.BusinessException;
import com.app.jdbc.model.Employee;

//DAO - Data Access Object
//A DAO represents that all the code which is related  to your DB or persistence or
//storage will be written inside this.
public interface EmployeeDAO {
	
	public int createEmployee(Employee employee) throws BusinessException;
	
	public int updateEmployeeContact(int id, String phone) throws BusinessException;
	
	public void deleteEmployee(int id) throws BusinessException;
	
	public Employee getEmployeeById(int id) throws BusinessException;
}
