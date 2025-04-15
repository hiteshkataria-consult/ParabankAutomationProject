package com.automate.testcases.api;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automate.base.BaseClass;
import com.automate.dataprovider.TestParameters;
import com.automate.pageobjects.BillPayApi;
import com.automate.testcases.ui.AccountPageTests;
import com.automate.utility.Config;

public class BillPayApiTest extends BaseClass {

    String accountId;

    @Test (dataProvider = "testParams")

    public void billPay() {
//        String username = "john";
//        String password = "demo";
//    	String accountId = "12345";

    	TestParameters testParameters = getTestParameters();
        accountId = AccountPageTests.accountId;
        System.out.println("Initial accountId: " + accountId);
        RestAssured.baseURI = Config.get("baseURI");

        Response response = new BillPayApi().executeBillPay(testParameters.username, testParameters.password, accountId);
        //Response response = new BillPayApi().executeBillPay(username, password, accountId);
        String payeeName = response.path("payeeName");
        int amount = response.path("amount");
        int accountIdAfterResponse = response.path("accountId");

        System.out.println("Extracted accountId: " + accountIdAfterResponse);
        System.out.println("Initial accountId: " + accountId);

        Assert.assertEquals(String.valueOf(accountIdAfterResponse), accountId, "The accountId in the response does not match the one used in the query parameter");
        Assert.assertEquals(payeeName, "Testname", "The payeeName in the response does not match the expected value");
        Assert.assertEquals(amount, 5, "The amount in the response does not match the expected value");
    }
}
