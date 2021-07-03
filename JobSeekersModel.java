package org.jobSeekers.model;

import org.springframework.stereotype.Component;

@Component
public class JobSeekersModel {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String mobile;
	
	
	public JobSeekersModel() {
		
	}
	
	public JobSeekersModel(String firstName, String middleName, String lastName, String email, String mobile) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
	}
	String getFirstName() {
		return firstName;
	}
	void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	String getMiddleName() {
		return middleName;
	}
	void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	String getLastName() {
		return lastName;
	}
	void setLastName(String lastName) {
		this.lastName = lastName;
	}
	String getEmail() {
		return email;
	}
	void setEmail(String email) {
		this.email = email;
	}
	String getMobile() {
		return mobile;
	}
	void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
	

}
