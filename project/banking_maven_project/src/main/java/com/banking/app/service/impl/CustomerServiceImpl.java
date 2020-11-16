package com.banking.app.service.impl;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.banking.app.dao.CustomerDAO;
import com.banking.app.dao.impl.CustomerDAOImpl;
import com.banking.app.exception.BusinessException;
import com.banking.app.model.Account;
import com.banking.app.model.Customer;
import com.banking.app.model.Transaction;
import com.banking.app.service.CustomerService;


public class CustomerServiceImpl implements CustomerService{
	
	
	public static Logger log = Logger.getLogger(CustomerServiceImpl.class);
	private CustomerDAO customerDAO = new CustomerDAOImpl();
	
	//Accounts
	@Override
	public Account getAccount(int accountId, int customerId) throws BusinessException {
		log.debug("in CustomerServiceImpl getAccount()");
		Account account = null; 
		customerDAO.getAccount(accountId, customerId);
		if (customerDAO.getAccount(accountId, customerId) != null) {
			account = customerDAO.getAccount(accountId, customerId);
		}else {
			throw new BusinessException("Records show that you do not own that account.");
		}
		return account; 
	}
	
	@Override
	public Account getAccountById(int accountId) throws BusinessException {
		log.debug("in CustomerServiceImpl getAccountById()");
		Account account = null;
		customerDAO.getAccountById(accountId);
		if (customerDAO.getAccountById(accountId) != null) {
			account = customerDAO.getAccountById(accountId);
		}else {
			throw new BusinessException("According to our records, that account doesn't exist.");
		}
		return account;
	}

	@Override
	public List<Account> getAllAccounts(int customerId) throws BusinessException {
		log.debug("in CustomerServiceImpl getAllAccounts ");
		List<Account> allCustomerAccounts = customerDAO.getAllAccounts(customerId);
		return allCustomerAccounts;
	}
	
	@Override
	public void newAccount(Account account,int customerId, int accountId) throws BusinessException {
		int x = customerDAO.newAccountForCustomerId(customerId, accountId);
		int y = customerDAO.newAccount(account);
		if(x > 0 && y > 0) {
			log.info("Employee: Okay, you have a new "+account.getAccountType()+" account. Your account number is "+accountId+".");
		}else {
			throw new BusinessException("The account was not created.");
		}
	}
	
	@Override
	public List<Integer> getAllAccountIds() throws BusinessException {
		List<Integer> accountIdList = null;
		accountIdList = customerDAO.getAllAccountIds();
		Collections.sort(accountIdList);
		return accountIdList;
	}
	
	//Bank Transactions
	@Override
	public List<Transaction> getAllTransactionsForAccount(int accountId, int customerId) throws BusinessException {
		List<Transaction> transactionList = null;
		if(getAccount(accountId, customerId) != null) {
			transactionList = customerDAO.getAllTransactionsForAccount(accountId, customerId);
		}else {
			throw new BusinessException("You do not have access to this account.");
		}
		return transactionList;
	}
	
	@Override
	public void withdrawFromAccount(int accountId, int customerId, double amount) throws BusinessException {
		if(amount > 0) {
			Account account = customerDAO.getAccount(accountId, customerId);
			double newBalance = account.getBalance() - amount;
				if(newBalance >= 0) {
					int update = customerDAO.updateAccountBalance(newBalance, accountId);
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
			Account account = customerDAO.getAccount(accountId, customerId);
			double newBalance = account.getBalance() + amount; 
			int update = customerDAO.updateAccountBalance(newBalance, accountId);
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
			Account fromAccount = customerDAO.getAccount(accountId, customerId);
			Account transferToAccount = customerDAO.getAccountById(transferToAccountId);
			double fromAccountBalance = fromAccount.getBalance();
			double transferToAccountBalance = transferToAccount.getBalance();
			if ((fromAccountBalance - amount) >= 0) {
				transferToAccountBalance = transferToAccountBalance + amount;
				fromAccountBalance = fromAccountBalance - amount;
				int deposit = customerDAO.updateAccountBalance(transferToAccountBalance, transferToAccountId);
				int withdrawal = customerDAO.updateAccountBalance(fromAccountBalance, accountId);
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
	public void makeNewTransaction(Transaction transaction,int transactionId, int accountId) throws BusinessException {
		int x = customerDAO.newTransactionForAccountId(transactionId, accountId);
		int y = customerDAO.newAccountTransaction(transaction);
		if(x > 0 &&  y > 0) {
			log.debug("The transaction was recorded.");
		}else {
			log.debug("Invalid transaction.");
		}
	}

	@Override
	public List<Integer> getAllTransactionIds() throws BusinessException {
		List<Integer> transactionIdList = null;
		transactionIdList = customerDAO.getAllTransactionIds();
		Collections.sort(transactionIdList);
		return transactionIdList;
	}
	
	//Customer Methods
	@Override
	public Customer customerLogIn(String username, String password) throws BusinessException {
		log.debug("in CustomerServiceImpl customerLogIn()");
		Customer customer = null;
		if (customerDAO.getCustomerInfo(username, password) != null) {
			customer = customerDAO.getCustomerInfo(username, password);
		}else {
			throw new BusinessException("Your username and password are incorrect. Please check your username and password and try again.");
		}
		return customer;
	}

	@Override
	public void newCustomer(String newUsername, String newPassword, String firstName, String lastName, boolean approvalStatus) throws BusinessException {
		if(newUsername.length() > 0 && newPassword.length() > 0 && firstName.length() > 0 && lastName.length() > 0) {
			int c = customerDAO.newCustomer(newUsername, newPassword, firstName, lastName, approvalStatus);
			if (c > 0) {
				log.info("Welcome to Griffith Community Bank "+firstName+" "+lastName+".");
			}else {
				throw new BusinessException("I'm sorry, something went wrong when we tried to put you into our system.");
			}
		}else {
			throw new BusinessException("I'm sorry, you didn't give me your information");
		}
	}

}
