package com.automate.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
		@FindBy(xpath="//p[@class='error']")
		private WebElement errorMsg;

	    @FindBy(name = "username")
	    private WebElement usernameField;

	    @FindBy(name = "password")
	    private WebElement passwordField;

	    @FindBy(xpath = "//input[@value='Log In']")
	    private WebElement loginButton;


	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void fillInCredentials(String username, String password) {
	        usernameField.sendKeys(username);
	        passwordField.sendKeys(password);
	    }

	    public void clickLogIn() {
	        loginButton.click();
	    }

}
