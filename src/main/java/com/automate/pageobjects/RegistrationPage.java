package com.automate.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automate.utility.Waits;

public class RegistrationPage {

    WebDriver driver;

    @FindBy(linkText = "Register")
    private WebElement registerLink;

    @FindBy(id = "customer.firstName")
    private WebElement firstNameField;

    @FindBy(id = "customer.lastName")
    private WebElement lastNameField;

    @FindBy(id = "customer.address.street")
    private WebElement addressField;

    @FindBy(id = "customer.address.city")
    private WebElement cityField;

    @FindBy(id = "customer.address.state")
    private WebElement stateField;

    @FindBy(id = "customer.address.zipCode")
    private WebElement zipCodeField;

    @FindBy(id = "customer.phoneNumber")
    private WebElement phoneField;

    @FindBy(id = "customer.ssn")
    private WebElement snnField;

    @FindBy(id = "customer.username")
    private WebElement userNameField;

    @FindBy(id = "customer.password")
    private WebElement passwordField;

    @FindBy(id = "repeatedPassword")
    private WebElement confirmPassField;

    @FindBy(xpath = "//input[@value='Register']")
    private WebElement registerButton;

    @FindBy(id = "repeatedPassword.errors")
    private WebElement passErrorMessage;
    
    @FindBy(id = "customer.username.errors")
    private WebElement userNameError;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickRegister() {
        registerLink.click();
    }

    public void fillFirstName(String fName) {
        Waits.getExplicitWait(driver).until(ExpectedConditions.elementToBeClickable(firstNameField));
        firstNameField.sendKeys(fName);
        Waits.waitForTextToBePresentInElementValue(driver, firstNameField, fName, 10);
    }

    public void fillLastName(String lName) {
        lastNameField.sendKeys(lName);
        Waits.waitForTextToBePresentInElementValue(driver, lastNameField, lName, 10);
    }

    public void fillAddress(String address) {
        addressField.sendKeys(address);
        Waits.waitForTextToBePresentInElementValue(driver, addressField, address, 10);
    }

    public void fillCity(String city) {
        cityField.sendKeys(city);
        Waits.waitForTextToBePresentInElementValue(driver, cityField, city, 10);
    }

    public void fillState(String state) {
        stateField.sendKeys(state);
        Waits.waitForTextToBePresentInElementValue(driver, stateField, state, 10);
    }

    public void fillzipCode(String zCode) {
        zipCodeField.sendKeys(zCode);
        Waits.waitForTextToBePresentInElementValue(driver, zipCodeField, zCode, 10);
    }

    public void fillPhone(int phone) {
        phoneField.sendKeys(String.valueOf(phone));
        Waits.waitForTextToBePresentInElementValue(driver, phoneField, String.valueOf(phone), 10);
    }

    public void fillSsn(String snn) {
        snnField.sendKeys(snn);
        Waits.waitForTextToBePresentInElementValue(driver, snnField, snn, 10);
    }

    public void fillUsername(String username) {
        userNameField.sendKeys(username);
        Waits.waitForTextToBePresentInElementValue(driver, userNameField, username, 10);
    }

    public void fillPassword(String password) {
        passwordField.sendKeys(password);
        Waits.waitForTextToBePresentInElementValue(driver, passwordField, password, 10);
    }

    public void fillConfirm(String confirm) {
        confirmPassField.sendKeys(confirm);
        Waits.waitForTextToBePresentInElementValue(driver, confirmPassField, confirm, 10);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public boolean verifyErrorPassMessage() {
        Waits.getExplicitWait(driver).until(ExpectedConditions.visibilityOf(passErrorMessage));
        boolean passwordConfirmError = passErrorMessage.isDisplayed();
        return passwordConfirmError;
    }
    
    public boolean verifyUserNameErrorMessage() {
        Waits.getExplicitWait(driver).until(ExpectedConditions.visibilityOf(userNameError));
        boolean userNameConfirmationError = userNameError.isDisplayed();
        return userNameConfirmationError;
    }
    
}




