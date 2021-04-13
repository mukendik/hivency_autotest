package autotest.automate.webapp.influencer.testcases;

import org.testng.annotations.Test;

import autotest.automate.PomInfluencer;
import autotest.automate.webapp.influencer.pom.Orders;
import autotest.automate.webapp.influencer.pom.SignInPage;
import autotest.automate.webapp.influencer.pom.StoreInfluencer;

public class ContentPublication extends PomInfluencer{
	
	@Test  // prerequisite : we should have passed orders, and have approved ones in the brand side
	public void publishContent() throws InterruptedException{
		SignInPage signIn = new SignInPage(driver);
		signIn.loginValidUser(197908);  
		Thread.sleep(2000);
		StoreInfluencer.orderLinkPage();
		Thread.sleep(2500);
		Orders.publishContent();
		Thread.sleep(8000);
	}

}
