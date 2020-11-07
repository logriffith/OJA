package com.banking.app.service;

import java.util.List;

import com.banking.app.exception.BusinessException;
import com.banking.app.model.Account;
import com.banking.app.model.Transaction;

public interface CustomerService {
	
	public String getUsername(int customerId) throws BusinessException;
	public String getPassword(int customerId) throws BusinessException;
	public boolean customerLogIn(String inputtedUsername, String inputtedPassword) throws BusinessException;
	public Account getAccount(int accountId, String username, String password) throws BusinessException;
	public List<Account> getAllAccounts(int customerId) throws BusinessException;
	public List<Transaction> getAllTransactionsForAccount(int accountId, int customerId) throws BusinessException;
	public int getCustomerId(String username, String password) throws BusinessException;
	public int withdrawFromAccount(int accountId, int customerId, double amount) throws BusinessException;
	public int depositInAccount(int accountId, int customerId, double amount) throws BusinessException;
	public int makeTransfer(int fromAccountId, int customerId, int toAccountId, double amount) throws BusinessException;
	public int newAccount(int customerId) throws BusinessException;
	public int newCustomer(String newUsername, String newPassword, String firstName, String lastName, boolean approvalStatus) throws BusinessException;
}
