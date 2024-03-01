package com.orangeHR;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	@BeforeTest
	public void beforeTest() {
	}

	@Test
	public void T001() {

		// Step 1: Launch browser application, get URL & maximize screen
		ChromeOptions chromeOpt = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		// Step 2: Enter valid username and valid password
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");

		// Step 3: Click on Login button.
		driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();

		// Step 4: Validate user is logged in successfully
		boolean isLoggedIn = driver.findElement(By.xpath("//span[contains(@class, 'oxd-main-menu-item--name')]")).isDisplayed();
		Assert.assertTrue(isLoggedIn);
		

		driver.close();
	}

	@Test
	public void T002() {
		
		// Step 1: Launch browser application, get URL & maximize screen.
		ChromeOptions chromeOpt = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		// Step 2: Enter valid username and invalid password.
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("xyz123");

		// Step 3: Click on Login button.
		driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();

		// Step 4: Validate user submitted incorrect credentials (Incorrect Pass).
		String actualInvalidMsg = driver.findElement(By.xpath("//p[contains(@class, 'oxd-alert-content-text')]")).getText();
		Assert.assertEquals(actualInvalidMsg, "Invalid credentials");
	}

	@Test
	public void T003() {

	}

	@AfterTest
	public void afterTest() {
	}

}
