package com.automate.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automate.utility.Waits;

import java.util.List;

public class AccountPage {

    WebDriver driver;

    @FindBy(linkText = "Log Out")
    private WebElement logoutLink;

    @FindBy (xpath = "//p[contains(text(),'Your account was created successfully. You are now logged in.')]")
    private WebElement successRegistrationMessage;

    @FindBy (linkText = "Accounts Overview")
    private WebElement accountsOverviewLink;

    @FindBy (xpath = "//h1[contains(text(),'Accounts Overview')]")
    private WebElement accountHeading;

    @FindBy (xpath = "//table[@id='accountTable']//thead//th")
    private List<WebElement> tableHeaders;

    @FindBy (xpath = "//tbody/tr[1]/td[1]/a")
    private WebElement initalAccountNumber;

    @FindBy (xpath = "//tbody/tr[1]/td[2]")
    private WebElement initialRowBalanceValue;

    @FindBy (xpath = "//tbody/tr[1]/td[3]")
    private WebElement initialRowAvailableAmountValue;

    @FindBy(xpath = "//table[@id='accountTable']//tbody//tr[1]//td")
    private List<WebElement> accountRowAllValues;

    public AccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean logOutLinkIsDisplayed(){
        Waits.getExplicitWait(driver).until(ExpectedConditions.visibilityOf(logoutLink));
        boolean logOut = logoutLink.isDisplayed();
        return logOut;
    }

    public boolean successRegMessage(){
       boolean messageIsDisplayed = successRegistrationMessage.isDisplayed();
       return messageIsDisplayed;
    }

    public void clickAccountsOverview(){
        accountsOverviewLink.click();
    }

    public boolean accountOverviewHeading(){
        boolean accountOverviewHeadingIsDisplayed = accountHeading.isDisplayed();
        return accountOverviewHeadingIsDisplayed;
    }

    public List<String> getAccountOverviewTableHeaders(){
    return tableHeaders.stream().map(WebElement::getText).toList();
    }

    public String getInitialAccountNumber(){
        String firstAccountNumber = initalAccountNumber.getText();
        return firstAccountNumber;
    }

    public String getInitialRowBalanceValue(){
    String balanceOneValue = initialRowBalanceValue.getText();
    return balanceOneValue;
    }

    public String getInitialRowAvailableAmount(){
        String availableAmountOne = initialRowAvailableAmountValue.getText();
        return availableAmountOne;
    }

   public List<String> getAllRowValuesAfterFirstPayRequest(){
        return accountRowAllValues.stream().map(WebElement::getText).toList();
    }
}
