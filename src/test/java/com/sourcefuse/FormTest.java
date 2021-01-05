package com.sourcefuse;

import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.common.FormElementObject;
import com.common.FormPage;
import com.utils.DBConnectTest;

public class FormTest {
	WebDriver driver;
	FormElementObject form = null;

	@BeforeClass
	void init() {
		driver = ConfigTest.driver;

	}

	@Test(priority = 1)
	void fillForm() throws InterruptedException, ClassNotFoundException, SQLException, ParseException {

		String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\Sheevangi Relan Resume.pdf";
		form = new FormElementObject("Sheevangi", "Relan", "sheevangirelan10@gmail.com", "samsung", "9810372558",
				"11/11/1992", "QA", "abc.com", "10000000", filepath, "Yes");

		FormPage fp = new FormPage(driver);
		fp.createForm(driver, form);
		Thread.sleep(3000);
		
		/* Insert form Entry to DB*/
		
		DBConnectTest.insertToDB(form);
		
		/*Fetch form Entry from DB*/
		DBConnectTest.getFromDB();
	}

	@Test(priority = 2)
	void fillFormMissingFirstName() throws InterruptedException, ClassNotFoundException, SQLException, ParseException {

		String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\Sheevangi Relan Resume.pdf";
		FormElementObject form = new FormElementObject("", "Relan", "sheevangirelan10@gmail.com", "samsung",
				"9810372558", "11/11/1992", "QA", "abc.com", "10000000", filepath, "Yes");

		FormPage fp = new FormPage(driver);
		fp.createForm(driver, form);
		WebElement errorMsg = driver.findElement(By.xpath("//*[contains(text(),'Please fill out this field']"));
		// Assertions
		Assert.assertTrue(errorMsg.isDisplayed());

	}

	@Test(priority = 2)
	void fillFormMissingLastName() throws InterruptedException, ClassNotFoundException, SQLException, ParseException {

		String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\Sheevangi Relan Resume.pdf";
		FormElementObject form = new FormElementObject("Sheevangi", "", "sheevangirelan10@gmail.com", "samsung",
				"9810372558", "11/11/1992", "QA", "abc.com", "10000000", filepath, "Yes");

		FormPage fp = new FormPage(driver);
		fp.createForm(driver, form);
		WebElement errorMsg = driver.findElement(By.xpath("//*[contains(text(),'Please fill out this field']"));
		// Hard Assertions
		Assert.assertTrue(errorMsg.isDisplayed());

	}

	@Test(priority = 3)
	void fillFormMissingEmail() throws InterruptedException, ClassNotFoundException, SQLException, ParseException {

		String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\Sheevangi Relan Resume.pdf";
		FormElementObject form = new FormElementObject("Sheevangi", "Relan", "", "samsung", "9810372558", "11/11/1992",
				"QA", "abc.com", "10000000", filepath, "Yes");

		FormPage fp = new FormPage(driver);
		fp.createForm(driver, form);
		WebElement errorMsg = driver.findElement(By.xpath("//*[contains(text(),'Please fill out this field']"));
		// Hard Assertions
		Assert.assertTrue(errorMsg.isDisplayed());

	}

	@Test(priority = 4)
	void fillFormMissingCompanyName()
			throws InterruptedException, ClassNotFoundException, SQLException, ParseException {

		String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\Sheevangi Relan Resume.pdf";
		FormElementObject form = new FormElementObject("Sheevangi", "Relan", "sheevangirelan10@gmail.com", "",
				"9810372558", "11/11/1992", "QA", "abc.com", "10000000", filepath, "Yes");

		FormPage fp = new FormPage(driver);
		fp.createForm(driver, form);
		WebElement errorMsg = driver.findElement(By.xpath("//*[contains(text(),'Please fill out this field']"));
		// Hard Assertions
		Assert.assertTrue(errorMsg.isDisplayed());

	}

	@Test(priority = 5)
	void fillFormMissingMobile() throws InterruptedException, ClassNotFoundException, SQLException, ParseException {

		String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\Sheevangi Relan Resume.pdf";
		FormElementObject form = new FormElementObject("Sheevangi", "Relan", "sheevangirelan10@gmail.com", "samsung",
				"", "11/11/1992", "QA", "abc.com", "10000000", filepath, "Yes");

		FormPage fp = new FormPage(driver);
		fp.createForm(driver, form);
		WebElement errorMsg = driver.findElement(By.xpath("//*[contains(text(),'Please fill out this field']"));
		// Hard Assertions
		Assert.assertTrue(errorMsg.isDisplayed());

	}

	@Test(priority = 6)
	void fillFormInvalidMobile() throws InterruptedException, ClassNotFoundException, SQLException, ParseException {

		String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\Sheevangi Relan Resume.pdf";
		FormElementObject form = new FormElementObject("Sheevangi", "Relan", "sheevangirelan10@gmail.com", "samsung",
				"0000000000000000000000000000000", "11/11/1992", "QA", "abc.com", "10000000", filepath, "Yes");

		FormPage fp = new FormPage(driver);
		fp.createForm(driver, form);
		WebElement errorMsg = driver.findElement(By.xpath("//*[contains(text(),'Please match the requested format.']"));
		// Hard Assertions
		Assert.assertTrue(errorMsg.isDisplayed());

	}

	@Test(priority = 7)
	void fillFormMissingDOB() throws InterruptedException, ClassNotFoundException, SQLException, ParseException {

		String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\Sheevangi Relan Resume.pdf";
		FormElementObject form = new FormElementObject("Sheevangi", "Relan", "sheevangirelan10@gmail.com", "samsung",
				"8860606060", "", "QA", "abc.com", "10000000", filepath, "Yes");

		FormPage fp = new FormPage(driver);
		fp.createForm(driver, form);
		WebElement errorMsg = driver.findElement(By.xpath("//*[contains(text(),'Please fill out this field']"));
		// Hard Assertions
		Assert.assertTrue(errorMsg.isDisplayed());

	}

	@Test(priority = 8)
	void fillFormMissingPosition() throws InterruptedException, ClassNotFoundException, SQLException, ParseException {

		String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\Sheevangi Relan Resume.pdf";
		FormElementObject form = new FormElementObject("Sheevangi", "Relan", "sheevangirelan10@gmail.com", "samsung",
				"8860606060", "10/10/1992", "", "abc.com", "10000000", filepath, "Yes");

		FormPage fp = new FormPage(driver);
		fp.createForm(driver, form);
		WebElement errorMsg = driver.findElement(By.xpath("//*[contains(text(),'Please fill out this field']"));
		// Hard Assertions
		Assert.assertTrue(errorMsg.isDisplayed());

	}

	@Test(priority = 9)
	void fillFormMissingProfile() throws InterruptedException, ClassNotFoundException, SQLException, ParseException {

		String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\Sheevangi Relan Resume.pdf";
		FormElementObject form = new FormElementObject("Sheevangi", "Relan", "sheevangirelan10@gmail.com", "samsung",
				"8860606060", "10/10/1992", "QA", "", "10000000", filepath, "Yes");

		FormPage fp = new FormPage(driver);
		fp.createForm(driver, form);
		WebElement errorMsg = driver.findElement(By.xpath("//*[contains(text(),'Please fill out this field']"));
		// Hard Assertions
		Assert.assertTrue(errorMsg.isDisplayed());

	}

	@Test(priority = 9)
	void fillFormMissingSalary() throws InterruptedException, ClassNotFoundException, SQLException, ParseException {

		String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\Sheevangi Relan Resume.pdf";
		FormElementObject form = new FormElementObject("Sheevangi", "Relan", "sheevangirelan10@gmail.com", "samsung",
				"8860606060", "10/10/1992", "QA", "abc.com", "", filepath, "Yes");

		FormPage fp = new FormPage(driver);

		fp.createForm(driver, form);
		WebElement errorMsg = driver.findElement(By.xpath("//*[contains(text(),'Please fill out this field']"));
		// Hard Assertions
		Assert.assertTrue(errorMsg.isDisplayed());

	}

	@Test(priority = 9)
	void fillFormMissingFile() throws InterruptedException, ClassNotFoundException, SQLException, ParseException {

		String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\Sheevangi Relan Resume.pdf";
		FormElementObject form = new FormElementObject("Sheevangi", "Relan", "sheevangirelan10@gmail.com", "samsung",
				"8860606060", "10/10/1992", "QA", "abc.com", "1000000", "", "Yes");

		FormPage fp = new FormPage(driver);
		fp.createForm(driver, form);
		WebElement errorMsg = driver.findElement(By.xpath("//*[contains(text(),'Please fill out this field']"));
		// Hard Assertions
		Assert.assertTrue(errorMsg.isDisplayed());

	}

	@Test(priority = 10)
	void fillFormMissingRelocation() throws InterruptedException, ClassNotFoundException, SQLException, ParseException {

		String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\Sheevangi Relan Resume.pdf";
		FormElementObject form = new FormElementObject("Sheevangi", "Relan", "sheevangirelan10@gmail.com", "samsung",
				"8860606060", "10/10/1992", "QA", "abc.com", "1000000", filepath, "");

		FormPage fp = new FormPage(driver);
		fp.createForm(driver, form);
		WebElement errorMsg = driver.findElement(By.xpath("//*[contains(text(),'Please fill out this field']"));
		// Hard Assertions
		Assert.assertTrue(errorMsg.isDisplayed());

	}

	@Test(priority = 11)
	void HardSoftAsserts() throws InterruptedException, ClassNotFoundException, SQLException, ParseException {

		String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\Sheevangi Relan Resume.pdf";
		FormElementObject form = new FormElementObject("Sheevangi", "Relan", "sheevangirelan10@gmail.com", "samsung",
				"9810372558", "11/11/1992", "QA", "abc.com", "10000000", filepath, "Yes");

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
		if (form.getRelocate().equalsIgnoreCase("yes"))
			fp.getRelocateYes().click();
		else if (form.getRelocate().equalsIgnoreCase("no"))
			fp.getRelocateNo();
		else
			fp.getRelocateNotSure();

		Thread.sleep(5000);

		// HardAsserts
		Assert.assertNotNull(fp.getFirstName());
		Assert.assertNotNull(fp.getLastName());
		Assert.assertNotNull(fp.getEmail());
		Assert.assertNotNull(fp.getCurrCompany());
		Assert.assertNotNull(fp.getMobile());
		Assert.assertNotNull(fp.getDob());
		Assert.assertNotNull(fp.getPortfolio());
		Assert.assertNotNull(fp.getPosition());
		Assert.assertNotNull(fp.getUploadResume());
		Assert.assertNotNull(fp.getRelocateYes());

		// SoftAsserts
		SoftAssert sa = new SoftAssert();

		WebElement address = driver.findElement(By.xpath("//div[@id='addressInput']/textarea"));
		WebElement whenStart = driver.findElement(By.xpath("//div[@id='whenStartInput']/input"));
		sa.assertEquals(address.getText(), "House address");
		sa.assertEquals(whenStart.getText(), "in 1 month");

		fp.getSubmit().click();
		sa.assertAll();
	}

	@Test(priority = 120, dependsOnMethods = { "fillform" })
	void verifyEmailSent() throws ClassNotFoundException, SQLException {

		String emailStatus = DBConnectTest.getEmailStatusfromDB(form);

		Assert.assertEquals(emailStatus, "Yes", "Email did not trigger");
	}
}
