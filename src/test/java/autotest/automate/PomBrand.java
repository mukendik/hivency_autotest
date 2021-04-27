package autotest.automate;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import org.openqa.selenium.logging.Logs;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import autotest.automate.BaseTest;


public abstract class PomBrand extends BaseTest{
	
	
	public  void connectAsBrand() throws InterruptedException{
		
		 connection("ghislain.mukendi@hivency.com", "Hivency01");
		
	}
	
	public static void selectBrandName() throws InterruptedException{
		
		// click on brand's name
		driver.findElement(By.className("selected-brand-name")).click();
		{
			  Thread.sleep(1400); 
				Actions keyDown = new Actions(driver); 
				// keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
				keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).click();
				driver
				.findElement(By.xpath("//*[contains(text(),'Test brand 3')]")).click();
		} 
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException{
		 init();
		loadWebBrowser();
		
		//To navigate to URL.
		driver.get(Param.getProperty("appURL"));
		
	//	System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Webdrivers\\Windows\\chrome\\chromedriver.exe");
	//	driver = new ChromeDriver();
	}
	
//	@AfterTest
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
