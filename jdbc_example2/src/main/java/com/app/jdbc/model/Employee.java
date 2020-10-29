package com.app.jdbc.model;

public class Employee {
	
	private int id;
	private String occupation;
	private String email;
	private String phoneNumber;
	private String status;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
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
				+ ", status=" + status + "]";
	}
	public Employee(int id, String occupation, String email, String phoneNumber, String status) {
		super();
		this.id = id;
		this.occupation = occupation;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}
	
}
