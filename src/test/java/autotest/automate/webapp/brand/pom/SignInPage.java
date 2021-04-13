package autotest.automate.webapp.brand.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import autotest.automate.PomBrand;

public class SignInPage extends PomBrand{
	
	protected WebDriver driver;
	
	private By username = By.id("email");
	private By passWord = By.id("password");
	private By connectButton = By.className("wrapper-input-submit");
	
	public SignInPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public BrandAppPage loginValidBrand(String email, String pass) {
		
		driver.findElement(username).sendKeys(email);
		driver.findElement(passWord).sendKeys(pass);
		driver.findElement(connectButton).click();
		
		return new BrandAppPage(driver);
	}
	
	public BrandAppPage loginValidBrand(int id) throws InterruptedException {
		driver.manage().deleteAllCookies();
		loginValidBrand("ghislain.mukendi@hivency.com", "Hivency01");
		 Thread.sleep(1000);
		driver.get("https://app.hivency-release.com/?fake_user_id=" + id);
		 Thread.sleep(1000);
		return new BrandAppPage(driver);
	}

	public void initiatePassword(){
		
	}

}
