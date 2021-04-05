package autotest.automate.webapp.influencer.pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;

public class Initiatepassword {
	
	protected WebDriver driver;
	
	private By email = By.id("email");
	private By confirmEmail = By.id("confirm_email");
	private RelativeBy btnSend = RelativeLocator.withTagName("button").below(confirmEmail);
	private RelativeBy backSignIn = RelativeLocator.withTagName("button").below(btnSend);


	public Initiatepassword(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
}
