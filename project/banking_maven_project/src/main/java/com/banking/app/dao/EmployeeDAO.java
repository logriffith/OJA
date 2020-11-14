package com.banking.app.dao;

import java.util.List;

import com.banking.app.exception.BusinessException;
import com.banking.app.model.Employee;
import com.banking.app.model.Transaction;

public interface EmployeeDAO{
	
	Employee getEmployeeInfo(String username, String password) throws BusinessException;
	List<Transaction> getAllTransactions() throws BusinessException;
	
}
