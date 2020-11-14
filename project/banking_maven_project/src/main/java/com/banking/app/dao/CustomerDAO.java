package com.banking.app.dao;


import java.util.List;

import com.banking.app.exception.BusinessException;
import com.banking.app.model.Account;
import com.banking.app.model.Customer;
import com.banking.app.model.Transaction;

public interface CustomerDAO {
	
	//Accounts
	Account getAccount(int accountId, int customerId) throws BusinessException;
	Account getAccountById(int accountId) throws BusinessException;
	List<Account> getAllAccounts(int customerId) throws BusinessException;
	int newAccount(Account account) throws BusinessException;
	int newAccountForCustomerId(int customerId,int accountId) throws BusinessException;
	List<Integer> getAllAccountIds() throws BusinessException;
	
	//Bank Transactions
	List<Transaction> getAllTransactionsForAccount(int accountId, int customerId) throws BusinessException;
	int updateAccountBalance(double newBalance, int accountId) throws BusinessException;
	int newTransactionForAccountId(int transactionId, int accountId) throws BusinessException;
	int newAccountTransaction (Transaction transaction) throws BusinessException;
	List<Integer> getAllTransactionIds() throws BusinessException;
	
	//New Customer and Searching for Customer
	int newCustomer(String newUsername, String newPassword, String firstName, String lastName, boolean approvalStatus) throws BusinessException;
	Customer getCustomerInfo(String username, String password) throws BusinessException;
}
