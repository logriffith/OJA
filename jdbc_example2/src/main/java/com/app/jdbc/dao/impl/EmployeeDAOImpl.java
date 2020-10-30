package com.app.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.app.jdbc.dao.EmployeeDAO;
import com.app.jdbc.dbutil.PostgresSqlConnection;
import com.app.jdbc.exception.BusinessException;
import com.app.jdbc.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public int createEmployee(Employee employee) throws BusinessException {
		int c =0;
		//inside the parentheses next to the try keyword is composed of Step 1,2,6
		try(Connection connection = PostgresSqlConnection.getConnection()){
			//Step 3
			String sql = "insert into test.employees (id,occupation,email,phone_number,status,employer)"
					+ "values (?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getOccupation());
			preparedStatement.setString(3, employee.getEmail());
			preparedStatement.setLong(4, employee.getPhoneNumber());
			preparedStatement.setString(5, employee.getStatus());
			preparedStatement.setString(6, employee.getEmployer());
			//Step 4
			c = preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // take off this line when in production
			throw new BusinessException("Internal error occurred. Please contact system administrator.");
		}
		return c;
	}

	@Override
	public int updateEmployeePhone(int id, long newPhone) throws BusinessException {
		int c = 0;
		try (Connection connection = PostgresSqlConnection.getConnection()) {
			//Step 3
			String sql = "update test.employees set phone_number=? where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, newPhone);
			preparedStatement.setInt(2, id);
			//Step 4
			c = preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // take off this line when in production
			throw new BusinessException("Internal error occurred. Please contact system administrator.");
		}
		return c;
	}

	@Override
	public void deleteEmployee(int id) throws BusinessException {
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = "delete from test.employees where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred. Please contact system administrator.");
		}	
	}

	@Override
	public Employee getEmployeeById(int id) throws BusinessException {
		Employee employee = null;
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = "select occupation,email,phone_number,status,employer from test.employees where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			//if there is an employee there, create the Employee object
			if(resultSet.next()) {
				employee = new Employee(id, resultSet.getString("occupation"), resultSet.getString("email"), 
						resultSet.getLong("phone_number"), resultSet.getString("status"), resultSet.getString("employer"));
			}else {
				throw new BusinessException("Records show that there is no employee with the ID = "+id);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occurred. Please contact system administrator.");
		}
		return employee;
	}

}
