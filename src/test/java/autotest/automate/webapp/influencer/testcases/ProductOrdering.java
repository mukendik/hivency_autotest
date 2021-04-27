package autotest.automate.webapp.influencer.testcases;

import org.testng.annotations.Test;

import autotest.automate.PomInfluencer;
import autotest.automate.webapp.influencer.pom.SignInPage;
import autotest.automate.webapp.influencer.pom.StoreInfluencer;

public class ProductOrdering extends PomInfluencer{
	
	@Test
	public void orderProduct() throws InterruptedException {
		
		SignInPage signIn = new SignInPage(driver);
		signIn.loginValidUser(197908);
		
		Thread.sleep(3000);
		// click on networks logo
  		StoreInfluencer.selectNetwork();

  		// check the CGU radio 
  		StoreInfluencer.acceptCgu();
		  
  		// click on continue
  		StoreInfluencer.clickOnContinueButton(); 
		  
  		// click on order button
  		StoreInfluencer.clickOnOrder(); 
		Thread.sleep(6000);
	}
	
	// @Test
	public void OrderReviewProduct() throws InterruptedException {
		
		SignInPage signIn = new SignInPage(driver);
		signIn.loginValidUser(197908);
		Thread.sleep(5000);
		
		// click on networks logo
  		StoreInfluencer.selectNetwork();

  		// check the CGU radio 
  		StoreInfluencer.acceptCgu();
		  
  		// click on continue
  		StoreInfluencer.clickOnContinueButton(); 
		  
  		// click on order button
  		StoreInfluencer.clickOnOrder(); 
	}

}
