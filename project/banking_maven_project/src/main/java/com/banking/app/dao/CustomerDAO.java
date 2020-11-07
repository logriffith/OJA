package com.banking.app.dao;


import java.util.List;

import com.banking.app.exception.BusinessException;
import com.banking.app.model.Account;
import com.banking.app.model.Customer;
import com.banking.app.model.Transaction;

public interface CustomerDAO {
	
	//public boolean isLoginCorrect(String username, String password);
	public String getUsername(int customerId) throws BusinessException;
	public String getPassword(int customerId) throws BusinessException;
	public Account getAccount(int accountId, int customerId) throws BusinessException;
	public List<Account> getAllAccounts(int customerId) throws BusinessException;
	public List<Transaction> getAllTransactionsForAccount(int accountId) throws BusinessException;
	public int getCustomerId(String username, String password) throws BusinessException;
	public int withdrawFromAccount(int accountId) throws BusinessException;
	public int depositInAccount(int accountId) throws BusinessException;
	public int makeTransfer(int fromAccountId, int toAccountId) throws BusinessException;
	public int newAccount(Account account) throws BusinessException;
	public int newCustomer(Customer customer) throws BusinessException;
}
