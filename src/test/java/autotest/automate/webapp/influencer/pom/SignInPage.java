package autotest.automate.webapp.influencer.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class SignInPage{
	
	  protected  WebDriver driver;

	  private By username = By.id("email");
	  private By password = By.id("password");
	  private By signinbtn = By.xpath("//span[contains(text(),'se connecter')]");
	  private By forgotPassword = By.xpath("//*[contains(text(),'mot de passe oublié')]");
	  private By createAccountbtn = By.xpath("//*[contains(text(),'créer un compte')]");
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
	    driver.findElement(username).sendKeys(userName);
	    driver.findElement(password).sendKeys(passWord);
	    driver.findElement(signinbtn).click();
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
