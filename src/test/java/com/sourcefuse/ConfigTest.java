package com.sourcefuse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utils.ConfigVar;


public class ConfigTest {

	public static WebDriver driver;
	@BeforeTest
	@Parameters("Browser")
	void launch(String Browser) throws InterruptedException {
		System.out.println("Inside launch method");
		
		if(Browser.equalsIgnoreCase("Chrome")) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get(ConfigVar.path);
		
		Thread.sleep(15000);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
	}}
	
	@AfterTest
	void cleanUp()
	{
		driver.quit();
	}
}
