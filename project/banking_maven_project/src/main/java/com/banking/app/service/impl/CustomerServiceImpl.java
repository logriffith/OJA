package com.banking.app.service.impl;

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
	public Account getAccountById(int accountId) throws BusinessException {
		log.debug("in CustomerServiceImpl getAccountById()");
		Account account = null;
		customerDAOImpl.getAccountById(accountId);
		if (customerDAOImpl.getAccountById(accountId) != null) {
			account = customerDAOImpl.getAccountById(accountId);
		}else {
			throw new BusinessException("According to our records, that account doesn't exist.");
		}
		return account;
	}

	@Override
	public List<Account> getAllAccounts(int customerId) throws BusinessException {
		log.debug("in CustomerServiceImpl getAllAccounts ");
		List<Account> allCustomerAccounts = customerDAOImpl.getAllAccounts(customerId);
		return allCustomerAccounts;
	}

	@Override
	public List<Transaction> getAllTransactionsForAccount(int accountId, int customerId) throws BusinessException {
		List<Transaction> transactionList = null;
		if(getAccount(accountId, customerId) != null) {
			transactionList = customerDAOImpl.getAllTransactionsForAccount(accountId, customerId);
		}else {
			throw new BusinessException("You do not have access to this account.");
		}
		return transactionList;
	}

	@Override
	public Customer customerLogIn(String username, String password) throws BusinessException {
		log.debug("in CustomerServiceImpl getCustomerId()");
		Customer customer = null;
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
				int update = customerDAOImpl.updateAccountBalance(newBalance, accountId);
				if(update > 0) {
					log.info("Okay, here is $"+amount+".");
				}else {
					throw new BusinessException("I'm sorry, something went wrong with your withdrawal.");
				}
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
			int update = customerDAOImpl.updateAccountBalance(newBalance, accountId);
			if(update > 0) {
				log.info("$"+amount+" was deposited successfully.");
			}else {
				throw new BusinessException("I'm sorry, something went wrong with your deposit.");
			}
		}else {
			throw new BusinessException("Deposit denied. You can only deposit a positive amount of money.");
		}
	}

	@Override
	public void makeTransfer(int accountId, int customerId, int transferToAccountId, double amount) throws BusinessException {
		if(amount > 0) {
			Account fromAccount = customerDAOImpl.getAccount(accountId, customerId);
			Account transferToAccount = null;
			if(customerDAOImpl.getAccount(transferToAccountId, customerId) != null) {
				//both accounts owned by same customer
				transferToAccount = customerDAOImpl.getAccount(transferToAccountId, customerId);
			}else {
				//the other account is owned by a different customer
				transferToAccount = customerDAOImpl.getAccountById(transferToAccountId);
			}
			double fromAccountBalance = fromAccount.getBalance();
			double transferToAccountBalance = transferToAccount.getBalance();
			if ((fromAccountBalance - amount) >= 0) {
				transferToAccountBalance = transferToAccountBalance + amount;
				fromAccountBalance = fromAccountBalance - amount;
				int deposit = customerDAOImpl.updateAccountBalance(transferToAccountBalance, transferToAccountId);
				int withdrawal = customerDAOImpl.updateAccountBalance(fromAccountBalance, accountId);
				if(deposit > 0 && withdrawal > 0 ) {
					log.info("$"+amount+" was transferred successully.");
				}else {
					throw new BusinessException("I'm sorry, something went wrong with the transfer.");
				}
			}else {
				throw new BusinessException("I'm sorry, but you don't have enough funds for this transaction.");
			}
		}else {
			throw new BusinessException("I'm sorry, we can only transfer positively valued funds.");
		}
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
