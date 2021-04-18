package autotest.automate.webapp.influencer.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import autotest.automate.PomInfluencer;


public class SignInPage extends PomInfluencer{
	
	  protected  WebDriver driver;

	  private By username = By.id(Object.getProperty("influencer_email"));
	  String user_name = "influencer_email";
	  private By password = By.id("password");
	  String passwd = "influencer_password";
	  private By signinbtn = By.xpath(Object.getProperty("btn_se_connecter"));
	  String signin_btn = "btn_se_connecter";
	 // private By forgotPassword = By.xpath("//*[contains(text(),'mot de passe oublié')]");
	  private By forgotPassword = By.xpath(Object.getProperty("btn_forgot_password"));
	  private By createAccountbtn = By.xpath("//*[contains(text(),'créer un compte')]");
	  String createAccount_btn = Object.getProperty("btn_forgot_password");
	//  private By initiatePasswordLink = RelativeLocator.withTagName("button").below(signinbtn);
	//  private By createAccountbtn = RelativeLocator.withTagName("button").below(initiatePasswordLink);
	 
	  
	  public SignInPage(WebDriver driver){
		    this.driver = driver;
		  }
	  
	  /**
	    * Login as valid user
	    *
	    * @param userName
	    * @param password
	    * @return HomePage object
	    */
	  public StoreInfluencer loginValidUser(String userName, String passWord) {
		//  driver.findElement(username).sendKeys(userName);
	    getElementByID(user_name).sendKeys(userName);
	  //  driver.findElement(password).sendKeys(passWord);
	    getElementByID(passwd).sendKeys(passWord);
	    getElementByXPath(signin_btn).click();
	    return new StoreInfluencer (driver);
	  }
	  
	  public StoreInfluencer loginValidUser(int id) throws InterruptedException {
		     driver.manage().deleteAllCookies();
		     loginValidUser("ghislain.mukendi@hivency.com", "Hivency01");
			 Thread.sleep(1000);
			 driver.get("https://store.hivency-release.com/?fake_user_id=" + id);
			 Thread.sleep(1000);
			 return new StoreInfluencer (driver);
		}
	  
	  public Initiatepassword forgotPassword (String email) {
		  return new Initiatepassword(driver);  
	  }
	  
	  public SignUp initiatePassword() {
		  driver.findElement(forgotPassword).click();
		  return new SignUp(driver);
	  }
	  
	  public SignUp createAccount() {
		  driver.findElement(createAccountbtn).click();
		  return new SignUp(driver);
	  }
}
