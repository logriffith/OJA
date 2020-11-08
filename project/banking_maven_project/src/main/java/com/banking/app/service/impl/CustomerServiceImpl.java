package com.banking.app.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.banking.app.dao.impl.CustomerDAOImpl;
import com.banking.app.exception.BusinessException;
import com.banking.app.model.Account;
import com.banking.app.model.Customer;
import com.banking.app.model.Transaction;
import com.banking.app.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	
	public static Logger log = Logger.getLogger(CustomerDAOImpl.class);
	private CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
	
	@Override
	public Account getAccount(int accountId, int customerId) throws BusinessException {
		log.debug("in CustomerServiceImpl getAccount()");
		Account account = null; 
		customerDAOImpl.getAccount(accountId, customerId);
		if (customerDAOImpl.getAccount(accountId, customerId) != null) {
			account = customerDAOImpl.getAccount(accountId, customerId);
		}else {
			throw new BusinessException("Records show that you do not own that account.");
		}
		return account; 
	}

	@Override
	public List<Account> getAllAccounts(int customerId) throws BusinessException {
		log.debug("in CustomerServiceImpl getAllAccounts ");
		List<Account> allCustomerAccounts = null;
		allCustomerAccounts = customerDAOImpl.getAllAccounts(customerId);
		return allCustomerAccounts;
	}

	@Override
	public List<Transaction> getAllTransactionsForAccount(int accountId, int customerId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer customerLogIn(String username, String password) throws BusinessException {
		log.debug("in CustomerServiceImpl getCustomerId()");
		Customer customer = null;
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		customerDAOImpl.getCustomerInfo(username, password);
		if (customerDAOImpl.getCustomerInfo(username, password) != null) {
			customer = customerDAOImpl.getCustomerInfo(username, password);
		}else {
			throw new BusinessException("Your username and password are incorrect. Please check your username and password and try again.");
		}
		return customer;
	}

	@Override
	public void withdrawFromAccount(int accountId, int customerId, double amount) throws BusinessException {
		if(amount > 0) {
		Account account = customerDAOImpl.getAccount(accountId, customerId);
		double newBalance = account.getBalance() - amount;
			if(newBalance >= 0) {
				customerDAOImpl.updateAccountBalance(newBalance, accountId);
			}else {
				throw new BusinessException("Withdrawal denied. You don't have enough money in your account for this transaction.");
			}
		}else {
			throw new BusinessException("I'm sorry, the amount to be withdrawn must be a positive number.");
		}
	}

	@Override
	public void depositInAccount(int accountId, int customerId, double amount) throws BusinessException {
		if(amount > 0) {
			Account account = customerDAOImpl.getAccount(accountId, customerId);
			double newBalance = account.getBalance() + amount; 
			customerDAOImpl.updateAccountBalance(newBalance, accountId);
		}else {
			throw new BusinessException("Deposit denied. You can only deposit a positive amount of money.");
		}
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


}
