package autotest.automate.webapp.influencer.testcases;

import org.testng.annotations.Test;

import autotest.automate.PomInfluencer;
import autotest.automate.webapp.influencer.pom.CompleteProfile;
import autotest.automate.webapp.influencer.pom.SignInPage;
import autotest.automate.webapp.influencer.pom.SignUp;

public class Registration extends PomInfluencer{
	
	@Test
	public void inscription() throws InterruptedException {
		SignInPage signIn = new SignInPage(driver);
		signIn.createAccount();
		Thread.sleep(1000);
		SignUp.accountCreation();
		Thread.sleep(3000);
		CompleteProfile.completeProfile();
		Thread.sleep(1900);
		
	}

}
