package com.banking.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.banking.app.dao.EmployeeDAO;
import com.banking.app.dao.dbutil.BankingQueries;
import com.banking.app.dao.dbutil.PostgresSqlConnection;
import com.banking.app.exception.BusinessException;
import com.banking.app.model.Employee;
import com.banking.app.model.Transaction;

public class EmployeeDAOImpl implements EmployeeDAO{

	public static Logger log = Logger.getLogger(CustomerDAOImpl.class);
	
	@Override
	public Employee getEmployeeInfo(String username, String password) throws BusinessException {
		Employee employee = null;
		log.debug("In EmployeeDAOImpl getEmployeeInfo()");
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = BankingQueries.GET_EMPLOYEE_INFO;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				log.debug("employee found");
				employee = new Employee(resultSet.getInt("employee_id"),resultSet.getString("first_name"), resultSet.getString("last_name"));
			} else {
				throw new BusinessException("I'm sorry. There is no customer with that username and password.");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new BusinessException("Internal error occurred. Please contact the System Administrator.");
		}
		return employee;
	}

	@Override
	public List<Transaction> getAllTransactions() throws BusinessException {
		log.debug("In EmployeeDAOImpl getAllTransactions()");
		List<Transaction> transactionList = new ArrayList<>();
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = BankingQueries.GET_ALL_TRANSACTIONS;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				log.debug("transaction found");
				Transaction transaction = new Transaction(resultSet.getInt("account_id"), resultSet.getString("transaction_type"),
						resultSet.getDouble("amount"), resultSet.getTimestamp("transaction_date"));
				transactionList.add(transaction);
			}
			if(transactionList.size() == 0) {
				throw new BusinessException("There are no transactions in our records.");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e);
			throw new BusinessException("Internal error occurred. Please contact the System Administrator.");
		}
		return transactionList;
	}



}
