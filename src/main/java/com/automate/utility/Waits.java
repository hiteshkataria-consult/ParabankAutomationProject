package com.automate.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

    public static WebDriverWait getExplicitWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void waitForTextToBePresentInElementValue(WebDriver driver, WebElement element, String text, int timeoutInSeconds) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
//        wait.until(new ExpectedCondition<Boolean>() {
//			@SuppressWarnings("deprecation")
//			public Boolean apply(WebDriver driver) {
//               return element.getAttribute("value").contains(text);
//            }
//        });
    	
    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    	    wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
    	
    }
}
