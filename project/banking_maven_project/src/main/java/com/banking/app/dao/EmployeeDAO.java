package com.banking.app.dao;

import java.util.List;

import com.banking.app.model.Account;
import com.banking.app.model.Transaction;

public interface EmployeeDAO{
	
	//public boolean isLoginCorrect(String username, String password);
	public String getUsername();
	public String getPassword();
	public Account getAccount(int accountId);
	public List<Account> getAllAccounts(int customerId);
	public List<Transaction> getAllTransactionsForAccount(int accountId);
	public List<Transaction> getAllTransactions();
	public List<Account> getAllAccounts();
}
