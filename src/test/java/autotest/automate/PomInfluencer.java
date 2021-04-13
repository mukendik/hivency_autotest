package autotest.automate;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import org.openqa.selenium.logging.Logs;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public abstract class PomInfluencer extends BaseTest{

	
	public void connectAsInfluencer(int id) throws InterruptedException {
	
		 Thread.sleep(3000);
		 connection("ghislain.mukendi@hivency.com", "Hivency01");
		 Thread.sleep(1000);
		 driver.get("https://store.hivency-release.com/?fake_user_id=" + id);
		 Thread.sleep(1000);
	}
	
		
	// @BeforeTest
	@BeforeMethod
	public void setUp() throws IOException{
		 init();
		loadWebBrowser();
		
		//To navigate to URL.
         driver.get(Param.getProperty("storeURL"));
		
	//	System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Webdrivers\\Windows\\chrome\\chromedriver.exe");
	//	driver = new ChromeDriver();
	}
	
	//@AfterTest
	@AfterMethod
	public void tearDown(){

		Logs logs = driver.manage().logs();
		LogEntries logEntries = logs.get(LogType.DRIVER);

		for (LogEntry logEntry : logEntries) {
		    System.out.println(logEntry.getMessage());
		}
	 closeWebBrowser();
	}

}
