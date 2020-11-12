package com.banking.app.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.banking.app.dao.EmployeeDAO;
import com.banking.app.dao.impl.EmployeeDAOImpl;
import com.banking.app.exception.BusinessException;
import com.banking.app.model.Employee;
import com.banking.app.model.Transaction;
import com.banking.app.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	public static Logger log = Logger.getLogger(EmployeeServiceImpl.class);
	private EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	
	@Override
	public Employee employeeLogIn(String username, String password) throws BusinessException {
		log.debug("in EmployeeServiceImpl employeeLogIn()");
		Employee employee = null;
		if (employeeDAO.getEmployeeInfo(username, password) != null) {
			employee = employeeDAO.getEmployeeInfo(username, password);
		}else {
			throw new BusinessException("Your username and password are incorrect. Please check your username and password and try again.");
		}
		return employee;
	}

	@Override
	public List<Transaction> getAllTransactions() throws BusinessException {
		List<Transaction> transactionList = null;
		transactionList = employeeDAO.getAllTransactions();
		return transactionList;
	}

}
