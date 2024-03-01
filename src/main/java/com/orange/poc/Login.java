package com.orange.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.Base;
import com.base.GlobalVariables;

public class Login extends Base {

	public Login(WebDriver driver) {
		super(driver);
	}

	// Objects
	By txtUsername = By.name("username");
	By txtPassword = By.name("password");
	By loginBtn = By.xpath("//button[contains(@class, 'orangehrm-login-button')]");
	By adminBtn = By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(1) > a");
	By lblInvalidCredentials = By.xpath("//p[contains(@class, 'oxd-alert-content-text')]");

	// Custom Methods

	// Login
	public void loginOrange(String username, String password) {
		type(txtUsername, username);
		type(txtPassword, password);
		click(loginBtn);
	}

	// Validate that user was logged in successfully.
	public boolean successfulLogin() {
		return isLoggedIn(adminBtn);

	}

	// Validate user inserted invalid credentials.
	public boolean actualInvalidMsg() {
		String actualMsg = getText(lblInvalidCredentials);
		if (actualMsg.equals(GlobalVariables.INVALID_CRED_MSG)) {
			return true;
		} else {
			return false;
		}
	}

}
