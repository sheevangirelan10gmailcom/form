package com.common;

import java.io.File;
import java.util.Date;

public class FormElementObject {
	private String firstname;
	private String lastname;
	private String email;
	private String currCompany;
	private String mobile;
	private String dob;
	private String position;
	private String portfollio;
	private String salary;
	private String file;
	private String relocate;

	
	public FormElementObject(String firstName,String Lastname,String email,String currCompany,String mobile,
			String dob,String position,String portfolio,String salary,String file,String relocate){
		
		
		
		this.firstname=firstName;
		this.lastname=Lastname;
		this.email=email;
		this.currCompany=currCompany;
		this.mobile=mobile;
		this.dob=dob;
		this.position=position;
		this.portfollio=portfolio;
		this.salary=salary;
		this.file=file;
		this.relocate=relocate;
	}
	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCurrCompany() {
		return currCompany;
	}

	public void setCurrCompany(String currCompany) {
		this.currCompany = currCompany;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPortfollio() {
		return portfollio;
	}

	public void setPortfollio(String portfollio) {
		this.portfollio = portfollio;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getRelocate() {
		return relocate;
	}

	public void setRelocate(String relocate) {
		this.relocate = relocate;
	}

	
	
}
