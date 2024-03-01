package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.Duration;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	private WebDriver driver;
	
	/*HEADER
	 * Constructor principal
	 * @author: Jose.rodriguez
	 * @param:
	 * @throws:
	 * @return:
	 * @date:
	 */
	
	public Base(WebDriver driver) {
		this.driver = driver;
	}
	
	// Chrome driver setup
	public WebDriver setupChromeDriver() {
		ChromeOptions chromeOpt = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}
	
	// Launch browser application
	public void launchBrowser(String url) {
		try {
			driver.get(url);
			driver.manage().window().maximize();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}	
	// Implicit wait
	public void implicitWait3seg() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	// Type in valid user and valid password	
	public void type(By locator, String inputText) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	// Click on login button
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	// Validate that user is logged in successfully
	public boolean isLoggedIn(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	
	// Driver close
	public void driverClose() {
		driver.close();
	}
	
	// Validate that incorrect credentials were submitted (Wrong pass).
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	/*
	 * Get JSON Data directly
	 * 
	 * @author: Jose.Rodriguez	
	 * @param: jsonFile, jsonKey
	 * @return: jsonValue
	 * @throws: NA
	 */
	
	public String getJSONData(String jsonFileObj, String jsonKey) {
		try {
			
			// JSON Data
			InputStream inputStream = new FileInputStream(GlobalVariables.PATH_JSON_DATA + jsonFileObj + ".json");
			JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));
			
			// Get Data
			String jsonValue = (String) jsonObject.get(jsonKey);
			return jsonValue;
		} catch(FileNotFoundException e){
			Assert.fail("JSON not found");
			return null;
		}
		
	}
}
	


