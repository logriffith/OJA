package com.banking.app.dao;

import java.util.List;

import com.banking.app.exception.BusinessException;
import com.banking.app.model.Account;
import com.banking.app.model.Customer;
import com.banking.app.model.Transaction;

public interface EmployeeDAO{
	
	public Customer getEmployeeInfo(String username, String password) throws BusinessException;
	public Account getAccountById(int accountId) throws BusinessException;
	public List<Transaction> getAllTransactionsForAccount(int accountId, int customerId) throws BusinessException;
	public List<Transaction> getAllTransactions() throws BusinessException;
	public List<Account> getAllAccounts(int customerId) throws BusinessException;
	
}
