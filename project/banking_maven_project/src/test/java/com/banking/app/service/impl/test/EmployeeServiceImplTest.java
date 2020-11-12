package com.banking.app.service.impl.test;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.banking.app.exception.BusinessException;
import com.banking.app.model.Employee;
import com.banking.app.service.EmployeeService;
import com.banking.app.service.impl.EmployeeServiceImpl;

class EmployeeServiceImplTest {
	
	public static Logger log = Logger.getLogger(EmployeeServiceImplTest.class);
	private static EmployeeService employeeService;
	
	@BeforeAll //always static
	public static void setUpEmployeeService() {
		employeeService = new EmployeeServiceImpl();
	}
	
	@Test
	void testEmployeeLogInFirstName() {
		try {
			Employee employee = employeeService.employeeLogIn("employee1", "password");
			assertEquals("Pete",employee.getFirstName());
		} catch (BusinessException e) {
			log.debug(e.getMessage());
		}
				
	}
	
	@Test
	void testEmployeeLogInLastName() {
		try {
			Employee employee = employeeService.employeeLogIn("employee1", "password");
			assertEquals("Ross",employee.getLastName());
		} catch (BusinessException e) {
			log.debug(e.getMessage());
		}
				
	}
	
	@Test
	void testEmployeeLogInEmployeeId() {
		try {
			Employee employee = employeeService.employeeLogIn("employee1", "password");
			assertEquals(1,employee.getEmployeeId());
		} catch (BusinessException e) {
			log.debug(e.getMessage());
		}		
	}
}
