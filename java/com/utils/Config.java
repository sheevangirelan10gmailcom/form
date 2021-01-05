package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class Config {

	
	@BeforeSuite
	void launch() {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\vaibhavkukreja\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
driver.get("http://google.com");
	}
}
