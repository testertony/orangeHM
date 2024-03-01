package com.orangeHR;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.Base;
import com.base.GlobalVariables;
import com.orange.poc.Login;

public class LoginTestPOM {
	
	WebDriver driver;
	Base base;
	Login login;
	String username;
	String password;
	String invalidPwd;

	
	@BeforeTest
	public void beforeTest() {
		base = new Base(driver);
		driver = base.setupChromeDriver();
		login = new Login(driver);
			
//		// External Credentials hardcoded
//		this.username = "Admin";
//		this.password = "admin123";
//		this.invalidPwd = "xyz123";
		
		// External Credentials within a JSON file
		this.username = base.getJSONData(GlobalVariables.JSON_DATA_CREDENTIALS, GlobalVariables.JSON_DATA_VALID_USERNANME);
		this.password = base.getJSONData(GlobalVariables.JSON_DATA_CREDENTIALS, GlobalVariables.JSON_DATA_VALID_PASSWORD);
		this.invalidPwd = base.getJSONData(GlobalVariables.JSON_DATA_CREDENTIALS, GlobalVariables.JSON_DATA_INVALID_PASSWORD);
		
	}	
  
	@Test
	public void TC001POM() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		// Step 1: Launch browser application.
		base.launchBrowser(GlobalVariables.QA_URL);
		
		// Step 2: Enter valid username and valid password.
		// Step 3: Click on the Login button.
		login.loginOrange(username, password);
		
		// Step 4: Validate user is logged in.
		Assert.assertTrue(login.successfulLogin());
		
	}
	@Test
	public void TC002POM() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// Step 1: Launch browser application.
		base.launchBrowser(GlobalVariables.QA_URL);
		
		// Step 2: Enter valid username and invalid password.
		// Step 3: Click on the login button.
		login.loginOrange(username, invalidPwd);
		
		// Step 4: Validate 
		Assert.assertTrue(login.actualInvalidMsg());
		
	}

	@AfterTest
	public void afterTest() {
		
		base.driverClose();
	}

}
