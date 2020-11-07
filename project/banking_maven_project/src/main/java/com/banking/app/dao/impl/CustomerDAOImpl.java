package com.banking.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.banking.app.dao.CustomerDAO;
import com.banking.app.dao.dbutil.CustomerQueries;
import com.banking.app.dao.dbutil.PostgresSqlConnection;
import com.banking.app.dao.dbutil.UserQueries;
import com.banking.app.exception.BusinessException;
import com.banking.app.model.Account;
import com.banking.app.model.Customer;
import com.banking.app.model.Transaction;


public class CustomerDAOImpl implements CustomerDAO{
	
	public static Logger log = Logger.getLogger(CustomerDAOImpl.class);

	@Override
	public String getUsername(int customerId) throws BusinessException {
		log.debug("In getUsername()");
		String username = null;
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = UserQueries.GET_USERNAME_BY_CUSTOMER_ID;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				log.debug("username found");
				username = resultSet.getString("username");
			} else {
				throw new BusinessException("Invalid customer ID. There is no username for the customer ID = "+customerId);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new BusinessException("Internal error occurred. Please contact the System Administrator");
		}
		
		return username;
	}

	@Override
	public String getPassword(int customerId) throws BusinessException {
		log.debug("In getPassword()");
		String password = null;
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = UserQueries.GET_PASSWORD_BY_CUSTOMER_ID;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				log.debug("password found");
				password = resultSet.getString("customer_password");
			} else {
				throw new BusinessException("Invalid customer ID. There is no password for the customer ID = "+customerId);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new BusinessException("Internal error occurred. Please contact the System Administrator");
		}
		
		return password;
	}

	@Override
	public Account getAccount(int accountId, int customerId) throws BusinessException {
		log.debug("In getAccount()");
		Account account = null; 
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = CustomerQueries.GET_ACCOUNT_BY_ACCOUNTID_AND_CUSTOMERID;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			preparedStatement.setInt(2, accountId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				log.debug("account found");
				account = new Account(accountId, resultSet.getString("account_type"),
						resultSet.getDouble("balance"), resultSet.getBoolean("approved"));
			}else {
				throw new BusinessException("There are no accounts with account ID = "+accountId+" and customer ID = "+customerId);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new BusinessException("Internal error occurred. Please contact the System Administrator");
		}
		return account;
	}

	@Override
	public List<Account> getAllAccounts(int customerId) throws BusinessException {
		log.debug("In getAllAccounts()");
		List<Account> accountList = new ArrayList<>();
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = CustomerQueries.GET_ALL_ACCOUNTS_BY_CUSTOMERID;
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
				throw new BusinessException("The customer with ID = "+customerId+" doesn't have an account yet.");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new BusinessException("Internal error occurred. Please contact the System Administrator");
		}
		return accountList;
	}

	@Override
	public int getCustomerId(String username, String password) throws BusinessException {
		int customerId = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()){
			log.debug("In getCustomerId()");
			String sql = CustomerQueries.GET_CUSTOMERID;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				log.debug("ID found");
				customerId = resultSet.getInt("customer_id");
			} else {
				throw new BusinessException("I'm sorry. There is no customer with that username and password.");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new BusinessException("Internal error occurred. Please contact the System Administrator");
		}
		return customerId;
	}

	@Override
	public List<Transaction> getAllTransactionsForAccount(int accountId, int customerId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateAccountBalance(int accountId, int customerId) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int newAccountId(int customerId) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createAccount(Account account) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int newCustomer(String newUsername, String newPassword, String firstName, String lastName,
			boolean approvalStatus) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int newTransactionForAccount(int accountId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int newAccountTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return 0;
	}

}

//one employee
//insert into bank.employees (username,employee_password,first_name,last_name)
//values ('employee1','password','Pete','Ross');

//insert new customer
//insert into bank.customers (username,customer_password,first_name,last_name,approved)
//values ('farmboy','password','Clark','Kent',true);

//delete customer
//delete from bank.customers where username='farmboy1' and customer_password='password';

//assigning account to customer
//insert into bank.customer_accounts (customer_id)
//values (1);
//adding to all accounts
//insert into bank.all_accounts (account_id,account_type,balance,approved)
//values (1,'savings',1000,true);

//new transaction
//insert into bank.account_transactions (account_id)
//values (1);