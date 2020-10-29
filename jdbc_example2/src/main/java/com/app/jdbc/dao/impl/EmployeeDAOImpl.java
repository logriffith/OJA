package com.app.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.app.jdbc.dao.EmployeeDAO;
import com.app.jdbc.dbutil.PostgresSqlConnection;
import com.app.jdbc.exception.BusinessException;
import com.app.jdbc.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public int createEmployee(Employee employee) throws BusinessException {
		int c =0;
		try(Connection connection = PostgresSqlConnection.getConnection()){
			//Step 3
			String sql = "insert into test.employees (id,occupation,email,phone_number,status)"
					+ "values (?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getOccupation());
			preparedStatement.setString(3, employee.getEmail());
			preparedStatement.setString(4, employee.getPhoneNumber());
			preparedStatement.setString(5, employee.getStatus());
			//Step 4
			c = preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // take off this line when in production
			throw new BusinessException("Internal error occured. Please contact system administrator.");
		}
		return c;
	}

	@Override
	public int updateEmployeeContact(int id, String phone) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
