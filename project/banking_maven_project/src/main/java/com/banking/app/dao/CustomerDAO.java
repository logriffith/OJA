package com.banking.app.dao;


import java.util.List;

import com.banking.app.exception.BusinessException;
import com.banking.app.model.Account;
import com.banking.app.model.Customer;
import com.banking.app.model.Transaction;

public interface CustomerDAO {
	
	//Accounts
	public Account getAccount(int accountId, int customerId) throws BusinessException;
	public Account getAccountById(int accountId) throws BusinessException;
	public List<Account> getAllAccounts(int customerId) throws BusinessException;
	public int newAccount(Account account) throws BusinessException;
	public int newAccountForCustomerId(int customerId,int accountId) throws BusinessException;
	public List<Integer> getAllAccountIds() throws BusinessException;
	
	//Bank Transactions
	public List<Transaction> getAllTransactionsForAccount(int accountId, int customerId) throws BusinessException;
	public int updateAccountBalance(double newBalance, int accountId) throws BusinessException;
	public int newTransactionForAccountId(int transactionId, int accountId) throws BusinessException;
	public int newAccountTransaction (Transaction transaction) throws BusinessException;
	public List<Integer> getAllTransactionIds() throws BusinessException;
	
	//New Customer and Searching for Customer
	public int newCustomer(String newUsername, String newPassword, String firstName, String lastName, boolean approvalStatus) throws BusinessException;
	public Customer getCustomerInfo(String username, String password) throws BusinessException;
}
//by default all methods in an interface are public and abstract, so the keyword public is not needed here.