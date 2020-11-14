package com.banking.app.service;

import java.util.List;

import com.banking.app.exception.BusinessException;
import com.banking.app.model.Account;
import com.banking.app.model.Customer;
import com.banking.app.model.Transaction;

public interface CustomerService {
	
	//Accounts
	Account getAccount(int accountId, int customerId) throws BusinessException;
	Account getAccountById(int accountId) throws BusinessException;
	List<Account> getAllAccounts(int customerId) throws BusinessException;
	void newAccount(Account account,int customerId, int accountId) throws BusinessException;
	List<Integer> getAllAccountIds() throws BusinessException;
	
	//Bank Transactions
	List<Transaction> getAllTransactionsForAccount(int accountId, int customerId) throws BusinessException;
	void withdrawFromAccount(int accountId, int customerId, double amount) throws BusinessException;
	void depositInAccount(int accountId, int customerId, double amount) throws BusinessException;
	void makeTransfer(int accountId, int customerId, int transferToAccountId, double amount) throws BusinessException;
	void makeNewTransaction(Transaction transaction,int transactionId, int accountId) throws BusinessException;
	List<Integer> getAllTransactionIds() throws BusinessException;
	
	//Customer Methods
	Customer customerLogIn(String username, String password) throws BusinessException;
	void newCustomer(String newUsername, String newPassword, String firstName, String lastName, boolean approvalStatus) throws BusinessException;
	
}
