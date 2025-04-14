package com.automate.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static WebDriver driver;

    public static WebDriver CreateDriver(String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
           System.setProperty("webdriver.chrome.driver", "D:\\WorkSpaces\\Drivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("mozilla")) {
        	System.setProperty("webdriver.gecko.driver", "D:\\WorkSpaces\\Drivers\\geckodriver.exe");
        	driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
        	System.setProperty("webdriver.edge.driver", "D:\\WorkSpaces\\Drivers\\msedgedriver.exe");
        	driver = new EdgeDriver();
        } else {
            System.out.println("Invalid browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static WebDriver getDriver(String browserName) {
        if (driver == null) {
            driver = CreateDriver(browserName);
        }  
        return driver;
    }

    public static void tearDownBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
