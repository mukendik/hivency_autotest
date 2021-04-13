package autotest.automate.webapp.influencer.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class SignUp {
	
	  protected static WebDriver driver;
	
	  private static By username = By.id("email");
	  private static By password = By.id("password");
	
	  protected static By confirmPassword = By.id("confirm_password");
	  private static By createButtonOne = RelativeLocator.withTagName("button").below(confirmPassword);
	  
	  

	public SignUp(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public static CompleteProfile accountCreation() throws InterruptedException{
	
		driver.findElement(username).sendKeys("testtnr04.09.21@yopmail.com");
		driver.findElement(password).sendKeys("Toto@lolo.net123456");
		driver.findElement(confirmPassword).sendKeys("Toto@lolo.net123456");
		driver.findElement(createButtonOne).click();
		 Thread.sleep(1000);
		 return new CompleteProfile(driver);
	}


}
