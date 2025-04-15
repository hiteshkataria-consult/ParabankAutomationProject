package com.automate.testcases.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automate.base.BaseClass;
import com.automate.pageobjects.AccountPage;

import java.util.List;

public class AccountPageTests extends BaseClass {

    AccountPage accountPage;
    public static String accountId;

    @Test
    public void clickAccountManagerLink() {

        accountPage = new AccountPage(driver);
        accountPage.clickAccountsOverview();
        Assert.assertEquals(accountPage.accountOverviewHeading(), true, "Account overview heading is not displayed");
    }

    @Test
    public void verifyAccountManagerTableHeaders() {
        List<String> actualHeaders = accountPage.getAccountOverviewTableHeaders();
        List<String> expectedHeaders = List.of("Account", "Balance*", "Available Amount");
        Assert.assertEquals(actualHeaders, expectedHeaders, "Header names in Account Manager table are not the expected ones");
    }

    @Test
    public void getFirstAccountId() {
        System.out.println("getFirstAccountId is running");
        accountId = accountPage.getInitialAccountNumber();
    }

    @Test
    public void testInitialRowBalanceValue() {
        Assert.assertEquals(accountPage.getInitialRowBalanceValue(), "$515.50", "Initial row with balance amount is not correct");
    }

    @Test
    public void testInitialAvailableAmountValue() {
        Assert.assertEquals(accountPage.getInitialRowAvailableAmount(), "$515.50", "Initial row with balance amount is not correct");
    }

    @Test
    public void verifyTableRowsAfterFirstPayBillRequest() {
        List<String> actualValues = accountPage.getAllRowValuesAfterFirstPayRequest();
        List<String> expectedValues = List.of(accountId, "$510.50", "$510.50");
        System.out.println(actualValues);
        System.out.println(expectedValues);
        Assert.assertEquals(actualValues, expectedValues, "Table row values after first billpay are not correct");
    }

}
