package com.banking.app.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.banking.app.dao.impl.CustomerDAOImpl;
import com.banking.app.exception.BusinessException;
import com.banking.app.model.Account;
import com.banking.app.model.Transaction;
import com.banking.app.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	
	public static Logger log = Logger.getLogger(CustomerDAOImpl.class);

	@Override
	public boolean customerLogIn(String inputtedUsername, String inputtedPassword) throws BusinessException {
		boolean loginSuccessful = false;
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		String username = customerDAOImpl.getUsername(customerDAOImpl.getCustomerId(inputtedUsername, inputtedPassword));
		String password = customerDAOImpl.getPassword(customerDAOImpl.getCustomerId(inputtedUsername, inputtedPassword));
		if(username.equals(inputtedUsername) && password.equals(inputtedPassword)) {
			log.debug("username and password match");
			loginSuccessful = true;
		}else {
			throw new BusinessException("I'm sorry. Your username and password were not correct.");
		}
		return loginSuccessful;
	}

	@Override
	public Account getAccount(int accountId, String username, String password) throws BusinessException {
		Account account = null; 
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		customerDAOImpl.getAccount(accountId, customerDAOImpl.getCustomerId(username,password));
		if (customerDAOImpl.getAccount(accountId, customerDAOImpl.getCustomerId(username,password)) != null) {
			account = customerDAOImpl.getAccount(accountId, customerDAOImpl.getCustomerId(username,password));
		}
		return account; 
	}

	@Override
	public List<Account> getAllAccounts(int customerId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getAllTransactionsForAccount(int accountId, int customerId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCustomerId(String username, String password) throws BusinessException {
		int customerId = 0;//needs work
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		customerDAOImpl.getCustomerId(username, password);
		if (customerDAOImpl.getCustomerId(username, password) != 0) {
			customerId = customerDAOImpl.getCustomerId(username, password);
		}else {
			throw new BusinessException("I'm sorry. There is no account with that username and password.");
		}
		return customerId;
	}

	@Override
	public int withdrawFromAccount(int accountId, int customerId, double amount) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int depositInAccount(int accountId, int customerId, double amount) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int makeTransfer(int fromAccountId, int customerId, int toAccountId, double amount)
			throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int newAccount(int customerId) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int newCustomer(String newUsername, String newPassword, String firstName, String lastName,
			boolean approvalStatus) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getUsername(int customerId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword(int customerId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
