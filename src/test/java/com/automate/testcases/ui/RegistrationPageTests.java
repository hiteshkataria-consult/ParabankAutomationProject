package com.automate.testcases.ui;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.automate.base.BaseClass;
import com.automate.dataprovider.TestParameters;
import com.automate.pageobjects.AccountPage;
import com.automate.pageobjects.RegistrationPage;

public class RegistrationPageTests extends BaseClass {

    RegistrationPage registrationPage;
    AccountPage accountPage;
    TestParameters testParameters;
    
    
    @Test(priority = 1, groups = {"Smoke","Functional"})

    public void clickRegistrationLink() {
        registrationPage = new RegistrationPage(driver);
        registrationPage.clickRegister();
    }

    @Test(priority = 2, groups = {"Smoke","Functional"})

    public void testFillInForm() {

        testParameters = getTestParameters();
        registrationPage.fillFirstName(testParameters.firstName);
        registrationPage.fillLastName(testParameters.lastName);
        registrationPage.fillAddress(testParameters.address);
        registrationPage.fillCity(testParameters.city);
        registrationPage.fillState(testParameters.state);
        registrationPage.fillzipCode(testParameters.zipCode);
        registrationPage.fillPhone(Integer.parseInt(testParameters.phone));
        registrationPage.fillSsn(testParameters.ssn);
    }

    @Test(priority = 3, groups = {"Smoke","Functional"})
    public void fillNotMatchingPasswordsAndRegister() {

        registrationPage.fillUsername(testParameters.username);
        registrationPage.fillPassword(testParameters.password);
        registrationPage.fillConfirm(testParameters.confirmPasswordOne);
        registrationPage.clickRegisterButton();
        Assert.assertEquals(registrationPage.verifyErrorPassMessage(), true, "Error message is not displayed");
    }

    @Test(priority = 4, groups = {"Smoke","Functional"})

    public void fillMatchingPasswordsAndRegister() {

        accountPage = new AccountPage(driver);
        registrationPage.fillPassword(testParameters.password);
        registrationPage.fillConfirm(testParameters.confirmPasswordTwo);
        registrationPage.clickRegisterButton();
        Assert.assertEquals(accountPage.logOutLinkIsDisplayed(), true, "logout link is not displayed");
        Assert.assertEquals(accountPage.successRegMessage(), true, "Success registration message is not displayed");
    }
}
