package autotest.automate.webapp.influencer.testcases;

import org.testng.annotations.Test;

import autotest.automate.PomInfluencer;
import autotest.automate.webapp.influencer.pom.InfluencerAccount;
import autotest.automate.webapp.influencer.pom.SignInPage;

public class InfluencerProfileManagement extends PomInfluencer{

	@Test 
	public void editUser() throws InterruptedException {
		SignInPage signIn = new SignInPage(driver);
		signIn.loginValidUser(130039);   //   198493
		InfluencerAccount.editInfluencerProfile();
		Thread.sleep(6000);
	}
	
    // @Test 
	public void changeLanguage() throws InterruptedException {
		SignInPage signIn = new SignInPage(driver);
		signIn.loginValidUser(198493);
		Thread.sleep(600);
		InfluencerAccount.changeLanguage();
		Thread.sleep(6000);
	}
	
    @Test
	public void changeShipingInfo() throws InterruptedException {
		SignInPage signIn = new SignInPage(driver);
		signIn.loginValidUser(130039);
		Thread.sleep(4000);
		InfluencerAccount.editShippingInfo();
		Thread.sleep(6000);
		
		
	}
	
	// @Test
	public void addNetwork() throws InterruptedException {
		SignInPage signIn = new SignInPage(driver);
		signIn.loginValidUser(130039);
		Thread.sleep(4000);
	//	InfluencerAccount.
		
	}
	
	// @Test
	public void changePassword() throws InterruptedException {
		SignInPage signIn = new SignInPage(driver);
		signIn.loginValidUser(130039);   //   198493
		InfluencerAccount.myProfile();
		InfluencerAccount.changePassword();
		Thread.sleep(8000);
	}
	
	// @Test
	public void forgotPassword() {
		SignInPage signIn = new SignInPage(driver);
		signIn.initiatePassword();
	}
	
	// @Test
	public void editSettings() {
		
	}
}
