package com.app.jdbc;

import com.app.jdbc.dao.EmployeeDAO;
import com.app.jdbc.dao.impl.EmployeeDAOImpl;
import com.app.jdbc.exception.BusinessException;
import com.app.jdbc.model.Employee;

public class JdbcDemoMain {

	public static void main(String[] args) {
		//for testing createEmployee method
//		Employee employee = new Employee(110, "jedi", "jedimaster@temple.com", 7789840094L, "active", "unemployed");
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
//		try {
//			if (employeeDAO.createEmployee(employee)>0) {//if there is a positive number of rows inserted
//				System.out.println("Employee created with details below:");
//				System.out.println(employee);
//			}
//		} catch (BusinessException e) {
//			System.out.println(e.getMessage());
//		}
		
		//testing updateEmployeePhone method
//		int id=105;
//		long newPhone=1010101010L;
//		try {
//			if(employeeDAO.updateEmployeePhone(id, newPhone)>0){
//				System.out.println("The updated phone number of employee with id= "+id+" is "+newPhone);
//			}
//		} catch (BusinessException e) {
//			System.out.println(e.getMessage());
//		}
		
		//testing deleteEmployee method
		int id = 150;
		try {
			if(employeeDAO.getEmployeeById(id) != null) {
				employeeDAO.deleteEmployee(id);
//				if (employeeDAO.getEmployeeById(id) == null) {
//					System.out.println("The employee with ID "+id+" was deleted");
//				}
			}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		
		//testing getEmployeeById method
//		int id = 102;
//		try {
//			Employee employee = employeeDAO.getEmployeeById(id);
//			if(employee != null) {
//				System.out.println("Employee found with ID = "+id+" and the details are...");
//				System.out.println(employee);
//			}
//		} catch (BusinessException e) {
//			System.out.println(e.getMessage());
//		}
	}

}
