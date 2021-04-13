package autotest.automate.webapp.influencer.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;


import autotest.automate.PomInfluencer;
import autotest.automate.webapp.influencer.pom.SignInPage;


public class InfluencerLogin extends PomInfluencer{
	
	@Test
	  public void testLogin() throws InterruptedException {
	    SignInPage signInPage = new SignInPage(driver);
	//    StoreInfluencer homePage = signInPage.loginValidUser("userName", "password");
	    signInPage.loginValidUser("ghislain.mukendi@hivency.com", "Hivency01");
	    Thread.sleep(600);
	  Assert.assertEquals("https://store.hivency-release.com/", driver.getCurrentUrl());
	  Thread.sleep(4600);

	  }
	
}
