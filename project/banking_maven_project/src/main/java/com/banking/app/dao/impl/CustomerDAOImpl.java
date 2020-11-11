package com.banking.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.Logger;

import com.banking.app.dao.CustomerDAO;
import com.banking.app.dao.dbutil.BankingQueries;
import com.banking.app.dao.dbutil.PostgresSqlConnection;
import com.banking.app.exception.BusinessException;
import com.banking.app.model.Account;
import com.banking.app.model.Customer;
import com.banking.app.model.Transaction;


public class CustomerDAOImpl implements CustomerDAO{
	
	public static Logger log = Logger.getLogger(CustomerDAOImpl.class);

	@Override
	public Account getAccountById(int accountId) throws BusinessException {
		log.debug("In CustomerDAOImpl getAccountById()");
		Account account = null;
		try (Connection connection = PostgresSqlConnection.getConnection()){
			String sql = BankingQueries.GET_ACCOUNT_BY_ACCOUNTID;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, accountId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				account = new Account(accountId, resultSet.getString("account_type"),
						resultSet.getDouble("balance"),resultSet.getBoolean("approved"));
			}else {
				throw new BusinessException("I'm sorry, that account does not exist.");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new BusinessException("Internal error occurred. Please contact the System Administrator.");
		}
		return account;
	}
	
	@Override
	public Account getAccount(int accountId, int customerId) throws BusinessException {
		log.debug("In CustomerDAOImpl getAccount()");
		Account account = null; 
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = BankingQueries.GET_ACCOUNT_BY_ACCOUNTID_AND_CUSTOMERID;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			preparedStatement.setInt(2, accountId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				log.debug("account found");
				account = new Account(accountId, resultSet.getString("account_type"),
						resultSet.getDouble("balance"), resultSet.getBoolean("approved"));
			}else {
				throw new BusinessException("There are no accounts with account number "+accountId+" under your name.");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new BusinessException("Internal error occurred. Please contact the System Administrator.");
		}
		return account;
	}

	@Override
	public List<Account> getAllAccounts(int customerId) throws BusinessException {
		log.debug("In CustomerDAOImpl getAllAccounts()");
		List<Account> accountList = new ArrayList<>();
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = BankingQueries.GET_ALL_ACCOUNTS_BY_CUSTOMERID;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				log.debug("account found");
				Account account = new Account(resultSet.getInt("account_id"), resultSet.getString("account_type"),
						resultSet.getDouble("balance"), resultSet.getBoolean("approved"));
				accountList.add(account);
			}
			if(accountList.size() == 0) {
				throw new BusinessException("You do not have an account yet.");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new BusinessException("Internal error occurred. Please contact the System Administrator.");
		}
		return accountList;
	}
	
	@Override
	public List<Transaction> getAllTransactionsForAccount(int accountId, int customerId) throws BusinessException {
		log.debug("In CustomerDAOImpl getAllTransactionsForAccount()");
		List<Transaction> transactionList = new ArrayList<>();
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = BankingQueries.GET_ALL_TRANSACTIONS_FOR_ACCOUNTID;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, accountId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				log.debug("transaction found");
				Transaction transaction = new Transaction(resultSet.getInt("account_id"), resultSet.getString("transaction_type"),
						resultSet.getDouble("amount"), resultSet.getTimestamp("transaction_date"));
				transactionList.add(transaction);
			}
			if(transactionList.size() == 0) {
				throw new BusinessException("There are no transactions for this account yet.");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new BusinessException("Internal error occurred. Please contact the System Administrator.");
		}
		return transactionList;
	}
	
	@Override
	public Customer getCustomerInfo(String username, String password) throws BusinessException {
		Customer customer = null;
		log.debug("In CustomerDAOImpl getCustomerInfo()");
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = BankingQueries.GET_CUSTOMER_INFO;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				log.debug("customer found");
				customer = new Customer(resultSet.getInt("customer_id"),resultSet.getString("first_name"), resultSet.getString("last_name"));
			} else {
				throw new BusinessException("I'm sorry. There is no customer with that username and password.");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new BusinessException("Internal error occurred. Please contact the System Administrator.");
		}
		return customer;
	}

	@Override
	public int updateAccountBalance(double newBalance, int accountId) throws BusinessException {
		int c = 0;
		log.debug("In CustomerDAOImpl updateAccountBalance()");
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = BankingQueries.UPDATE_BALANCE_BY_ACCOUNTID;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, newBalance);
			preparedStatement.setInt(2, accountId);
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new BusinessException("Internal error occurred. Please contact the System Administrator.");
		}
		return c;
	}


	@Override
	public int newAccount(Account account) throws BusinessException {
		int a = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = BankingQueries.NEW_ACCOUNT;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, account.getAccountId());
			preparedStatement.setString(2, account.getAccountType());
			preparedStatement.setDouble(3, account.getBalance());
			preparedStatement.setBoolean(4, account.isApprovedAccount());
			a = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new BusinessException("Internal error occurred. Please contact the System Administrator.");
		}
		return a;
	}
	
	@Override
	public int newAccountForCustomerId(int customerId, int accountId) throws BusinessException {
		int b = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = BankingQueries.NEW_ACCOUNT_FOR_CUSTOMERID;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, accountId);
			preparedStatement.setInt(2, customerId);
			b = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new BusinessException("Internal error occurred. Please contact the System Administrator.");
		}
		return b;
	}

	@Override
	public int newCustomer(String newUsername, String newPassword, String firstName, String lastName, boolean approvalStatus) throws BusinessException {
		int c = 0;	
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = BankingQueries.NEW_CUSTOMER;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newUsername);
			preparedStatement.setString(2, newPassword);
			preparedStatement.setString(3, firstName);
			preparedStatement.setString(4, lastName);
			preparedStatement.setBoolean(5, approvalStatus);
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new BusinessException("Internal error occurred. Please contact the System Administrator.");
		}
		return c;
	}

	@Override
	public int newTransactionForAccountId(int transactionId, int accountId) throws BusinessException {
		int c = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = BankingQueries.NEW_TRANSACTION_FOR_ACCOUNTID;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, transactionId);
			preparedStatement.setInt(2, accountId);
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new BusinessException("Internal error occurred. Please contact the System Administrator.");
		}
		return c;
	}

	@Override
	public int newAccountTransaction(Transaction transaction) throws BusinessException {
		int t = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = BankingQueries.NEW_TRANSACTION;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, transaction.getTransactionId());
			preparedStatement.setString(2, transaction.getTransactionType());
			preparedStatement.setDouble(3, transaction.getTransactionAmount());
			preparedStatement.setTimestamp(4, new java.sql.Timestamp(transaction.getDate().getTime()));
			t = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new BusinessException("Internal error occurred. Please contact the System Administrator.");
		}
		return t;
	}

	@Override
	public List<Integer> getAllTransactionIds() throws BusinessException {
		List<Integer> transactionIdList = new ArrayList<>();
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = BankingQueries.GET_ALL_TRANSACTIONIDS;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				transactionIdList.add(resultSet.getInt("transaction_id"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new BusinessException("Internal error occurred. Please contact the System Administrator.");
		}
		return transactionIdList;
	}

	@Override
	public List<Integer> getAllAccountIds() throws BusinessException {
		List<Integer> accountIdList = new ArrayList<>();
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = BankingQueries.GET_ALL_ACCOUNTIDS;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				accountIdList.add(resultSet.getInt("account_id"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new BusinessException("Internal error occurred. Please contact the System Administrator.");
		}
		return accountIdList;
	}
}