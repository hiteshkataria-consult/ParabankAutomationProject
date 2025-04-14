package com.automate.base;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.automate.dataprovider.TestParameters;
import com.automate.utility.Config;

public class BaseClass {
	
	public Properties prop;
    private List<TestParameters> testParametersList;
    public static WebDriver driver;
    private TestParameters testParameters;

    @BeforeClass
  //  @Parameters({"dataSet","dataSourceType"})
    @Parameters("dataSet")
    public void setUp(int dataSet) throws IOException {
        String filePath;
       // dataSet = Config.get("dataSet");
        String dataSourceType = Config.get("dataSourceType");
        if (dataSourceType.equalsIgnoreCase("csv"))
        {
        	 filePath = Paths.get("resources\\TestData", "userData.csv").toString();
             testParametersList = TestParameters.loadFromCSV(filePath);
        }
        
        else {
        	 filePath = Paths.get("resources", "parameters.json").toString();
             testParametersList = TestParameters.loadFromFile(filePath);
        }
       
        if (dataSet < testParametersList.size()) {
            testParameters = testParametersList.get(dataSet);
        } else {
            throw new IndexOutOfBoundsException("Invalid data set index");
        }
    }

     
    public TestParameters getTestParameters() {
        return testParameters;
    }

    @BeforeSuite
    @Parameters("browser")
    public void openBrowser(@Optional("chrome") String browser) throws IOException {
//    	if (prop==null) {
//    		propertiesFile();
//    	}
    	driver = BrowserFactory.getDriver(browser);
        driver.get(Config.get("Url"));
    }

    @AfterSuite

    public void closeBrowser() {
        BrowserFactory.tearDownBrowser();
    }
    

//  private Properties propertiesFile() throws IOException
//  {
//		prop = new Properties();
//		String propPath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "config.properties").toString();
//		FileInputStream fis = new FileInputStream(propPath);
//		prop.load(fis);
//		return prop;
//  }
}


