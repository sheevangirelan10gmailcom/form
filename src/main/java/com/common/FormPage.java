package com.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
	WebDriver driver;
	@FindBy(xpath = "//div[@id='fnameInput']/input")
	WebElement firstName;

	@FindBy(xpath = "//div[@id='lnameInput']/input")
	WebElement lastName;

	@FindBy(xpath = "//*[@type='email']")
	WebElement email;
	
	/*
	 * @FindBy(xpath = "//div[@id='lnameInput']/input") WebElement Address;
	 */

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public void setFirstName(WebElement firstName) {
		this.firstName = firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public void setLastName(WebElement lastName) {
		this.lastName = lastName;
	}

	public WebElement getEmail() {
		return email;
	}

	public void setEmail(WebElement email) {
		this.email = email;
	}

	public WebElement getCurrCompany() {
		return currCompany;
	}

	public void setCurrCompany(WebElement currCompany) {
		this.currCompany = currCompany;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public void setMobile(WebElement mobile) {
		this.mobile = mobile;
	}

	public WebElement getDob() {
		return dob;
	}

	public void setDob(WebElement dob) {
		this.dob = dob;
	}

	public WebElement getPosition() {
		return position;
	}

	public void setPosition(WebElement position) {
		this.position = position;
	}

	public WebElement getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(WebElement portfolio) {
		this.portfolio = portfolio;
	}

	public WebElement getSalary() {
		return salary;
	}

	public void setSalary(WebElement salary) {
		this.salary = salary;
	}

	public WebElement getUploadResume() {
		return uploadResume;
	}

	public void setUploadResume(WebElement uploadResume) {
		this.uploadResume = uploadResume;
	}

	public WebElement getRelocateYes() {
		return relocateYes;
	}

	public void setRelocateYes(WebElement relocateYes) {
		this.relocateYes = relocateYes;
	}

	public WebElement getRelocateNo() {
		return relocateNo;
	}

	public void setRelocateNo(WebElement relocateNo) {
		this.relocateNo = relocateNo;
	}

	public WebElement getRelocateNotSure() {
		return relocateNotSure;
	}

	public void setRelocateNotSure(WebElement relocateNotSure) {
		this.relocateNotSure = relocateNotSure;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public void setSubmit(WebElement submit) {
		this.submit = submit;
	}

	@FindBy(xpath = "//div[@id='curCompanyInput']/input")
	WebElement currCompany;

	@FindBy(xpath = "//*[@type='tel']")
	WebElement mobile;

	@FindBy(xpath = "//*[@class='input-group date']/input")
	WebElement dob;

	@FindBy(xpath = "//div[@id='positionInput']/input")
	WebElement position;

	@FindBy(xpath = "//div[@id='portfolioInput']/input")
	WebElement portfolio;

	@FindBy(xpath = "//div[@id='salaryInput']/input")
	WebElement salary;

	@FindBy(xpath = "//*[@type='file']")
	WebElement uploadResume;

	@FindBy(xpath = "//*[@type='radio' and @id='yes']  ")
	WebElement relocateYes;
	@FindBy(xpath = "//*[@type='radio' and @id='no']  ")
	WebElement relocateNo;
	@FindBy(xpath = "//*[@type='radio' and @id='notSure']  ")
	WebElement relocateNotSure;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;

	public FormPage(WebDriver driver) {
		this.driver = driver;
		System.out.println("form page driver "+driver);
		PageFactory.initElements(driver,this);
	}

	public void createForm(WebDriver driver, FormElementObject form) throws InterruptedException {
		// Fill name

		System.out.println("Creating form");
		FormPage fp = new FormPage(driver);
		
		
		fp.getFirstName().sendKeys(form.getFirstname());
		fp.getLastName().sendKeys(form.getLastname());
		Thread.sleep(2000);
        fp.getEmail().sendKeys(form.getEmail());
        fp.getCurrCompany().sendKeys(form.getCurrCompany());
        fp.getMobile().sendKeys(form.getMobile());
        Thread.sleep(2000);
        fp.getDob().sendKeys(form.getDob());
        fp.getPosition().sendKeys(form.getPosition());
        fp.getPortfolio().sendKeys(form.getPortfollio());
        Thread.sleep(2000);
        fp.getSalary().sendKeys(form.getSalary());
        Thread.sleep(2000);
        fp.getUploadResume().sendKeys(form.getFile());
        Thread.sleep(2000);
       if(form.getRelocate().equalsIgnoreCase("yes"))
    	   fp.getRelocateYes().click();
       else if(form.getRelocate().equalsIgnoreCase("no"))
    	   fp.getRelocateNo();
       else
    	   fp.getRelocateNotSure();
       
       Thread.sleep(5000);
       fp.getSubmit().click();
       
       
		Thread.sleep(15000);
	
	}

}
