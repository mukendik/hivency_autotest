package autotest.automate.webapp.influencer.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



import autotest.automate.PomInfluencer;


public class SignInPage extends PomInfluencer{
	
	  protected  WebDriver driver;

	  String user_name = "influencer_email";
	  String passwd = "influencer_password";
	  String signin_btn = "btn_se_connecter";
	  String forgotPassword = "btn_forgot_password";
	  String createAccountbtn = "btn_create_account";
	//  private By initiatePasswordLink = RelativeLocator.withTagName("button").below(signinbtn);
	  String initiatePasswordLinkTag = "button";
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
	    getElementByID(user_name).sendKeys(userName);
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
		  getElementByXPath(forgotPassword).click();
		  return new SignUp(driver);
	  }
	  
	  public SignUp createAccount() {
		  getElementByXPath(createAccountbtn).click();
		  return new SignUp(driver);
	  }
}
