package com.employee.search.model;

public class Employee {
	
	private int id;
	private String occupation;
	private String email;
	private long phoneNumber;
	private String status;
	private String employer;
	
	public Employee() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getOccupation() {
		return occupation;
	}
	
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", occupation=" + occupation + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", status=" + status + ", employer=" + employer + "]";
	}

	

	public Employee(int id, String occupation, String email, long phoneNumber, String status, String employer) {
		super();
		this.id = id;
		this.occupation = occupation;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.employer = employer;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}
	
}
