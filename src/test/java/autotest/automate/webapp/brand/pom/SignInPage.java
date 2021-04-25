package autotest.automate.webapp.brand.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import autotest.automate.PomBrand;

public class SignInPage extends PomBrand{
	
	protected WebDriver driver;
	
	static String username = "brand_email";
	static String passWord = "brand_password";
	static String connectButton = "wrapper_input_submit";
	
	public SignInPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public BrandAppPage loginValidBrand(String email, String pass) {
		
		getElementByID(username).sendKeys(email);
		getElementByID(passWord).sendKeys(pass);
		getElementByClass(connectButton).click();
		
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
