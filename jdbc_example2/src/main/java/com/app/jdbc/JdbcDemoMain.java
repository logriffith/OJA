package com.app.jdbc;

import com.app.jdbc.dao.EmployeeDAO;
import com.app.jdbc.dao.impl.EmployeeDAOImpl;
import com.app.jdbc.exception.BusinessException;
import com.app.jdbc.model.Employee;

public class JdbcDemoMain {

	public static void main(String[] args) {
		Employee employee = new Employee(108, "criminal", "venom@addicted.com", "7879900", "active");
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		try {
			if (employeeDAO.createEmployee(employee)>0) {
				System.out.println("Employee created with details below:");
				System.out.println(employee);
			}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}

}
