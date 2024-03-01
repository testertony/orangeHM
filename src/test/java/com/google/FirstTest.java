package com.google;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
  @Test
  public void TC001() throws InterruptedException {
	  	
	  	// Step 1: Launching browser and maximizing the screen
	  	ChromeOptions chromeOpt = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOpt);

		driver.get("https://www.orangehrm.com/en/policies/orangehrm-privacy-policy//");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		// Implicit wait (DOM)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		// Clicking on Accept Cookies button
		driver.findElement(By.cssSelector("body > div.optanon-alert-box-wrapper > div.optanon-alert-box-bg > div.optanon-alert-box-button-container > div.optanon-alert-box-button.optanon-button-allow > div > a")).click();
		
		boolean cookiesIsDisplayed = driver.findElement(By.cssSelector("body > div.optanon-alert-box-wrapper > div.optanon-alert-box-bg > div.optanon-alert-box-button-container > div.optanon-alert-box-button.optanon-button-allow > div > a")).isDisplayed();
		Assert.assertTrue(cookiesIsDisplayed);
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cookiesIsDisplayed);
		
		softAssert.assertAll();
		driver.quit();
		
//		// Explicit wait
//		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, \"https://www.orangehrm.com/assets/Documents/OrangeHRM-Privacy-Policy.pdf\")]")));
//		
//		driver.findElement(By.xpath("//a[contains(@href, \"https://www.orangehrm.com/assets/Documents/OrangeHRM-Privacy-Policy.pdf\")]")).click();
//		
		
  
  }
  
}
