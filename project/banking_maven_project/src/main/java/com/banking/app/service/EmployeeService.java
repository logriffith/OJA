package com.banking.app.service;

import java.util.List;

import com.banking.app.exception.BusinessException;
import com.banking.app.model.Employee;
import com.banking.app.model.Transaction;

public interface EmployeeService {

	public Employee employeeLogIn(String username, String password) throws BusinessException;
	public List<Transaction> getAllTransactions() throws BusinessException;
	
}
