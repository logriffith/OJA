package com.banking.app.dao.dbutil;

public class BankingQueries {
	
	public static final String GET_ALL_ACCOUNTS_BY_CUSTOMERID = "select all_accounts.account_id, account_type, balance, approved "
			+ "from bank.all_accounts inner join bank.customer_accounts on all_accounts.account_id = customer_accounts.account_id "
			+ "where customer_id = ?";
	
	public static final String GET_ACCOUNT_BY_ACCOUNTID_AND_CUSTOMERID="select account_type, balance, approved "
			+ "from bank.all_accounts inner join bank.customer_accounts on all_accounts.account_id = customer_accounts.account_id"
			+ " where customer_id = ? and all_accounts.account_id = ?";
	
	public static final String GET_ACCOUNT_BY_ACCOUNTID = "select account_type, balance, approved from bank.all_accounts where account_id = ?";
	
	public static final String GET_CUSTOMER_INFO = "select customer_id, first_name, last_name from bank.customers where username = ? and customer_password = ?";
	
	public static final String GET_EMPLOYEE_INFO = "select employee_id, first_name, last_name from bank.employees where username = ? and employee_password = ?";
	
	public static final String UPDATE_BALANCE_BY_ACCOUNTID = "update bank.all_accounts set balance = ? where account_id = ?";
	
	public static final String GET_ALL_TRANSACTIONS_FOR_ACCOUNTID = "select account_transactions.account_id,transaction_type, amount, transaction_date "
			+ "from bank.all_transactions inner join bank.account_transactions on all_transactions.transaction_id = account_transactions.transaction_id "
			+ "where account_transactions.account_id = ?";
	
	public static final String GET_ALL_TRANSACTIONS = "select account_transactions.account_id,transaction_type, amount, transaction_date "
			+ "from bank.all_transactions inner join bank.account_transactions on all_transactions.transaction_id = account_transactions.transaction_id";
	
	public static final String NEW_TRANSACTION_FOR_ACCOUNTID = "insert into bank.account_transactions (transaction_id,account_id) values (? , ?)";
	
	public static final String NEW_TRANSACTION = "insert into bank.all_transactions (transaction_id,transaction_type,amount,transaction_date) "
			+ "values (? , ? , ? ,?)";
	
	public static final String GET_ALL_TRANSACTIONIDS = "select transaction_id from bank.account_transactions";
	
	public static final String GET_ALL_ACCOUNTIDS = "select account_id from bank.customer_accounts";
	
	public static final String NEW_ACCOUNT_FOR_CUSTOMERID = "insert into bank.customer_accounts (account_id ,customer_id) values (? , ?)";
	
	public static final String NEW_ACCOUNT = "insert into bank.all_accounts (account_id,account_type,balance,approved) values (? , ? , ? , ?)";
	
	public static final String NEW_CUSTOMER = "insert into bank.customers (username,customer_password,first_name,last_name,approved) "
			+ "values (?, ? , ? , ? , ?)";
	
}

