package autotest.automate.webapp.brand.testcases;

import org.testng.annotations.Test;

import autotest.automate.PomBrand;
import autotest.automate.webapp.brand.pom.BrandAppPage;
import autotest.automate.webapp.brand.pom.FollowUpPage;
import autotest.automate.webapp.brand.pom.SignInPage;

public class BrandLogin extends PomBrand{
	
//	@Test
	public void login() {
		 SignInPage signInPage = new SignInPage(driver);
		 signInPage.loginValidBrand("ghislain.mukendi@hivency.com", "Hivency01");
	}
	
	// @Test
	public void pendingInf() throws InterruptedException {
		 SignInPage signInPage = new SignInPage(driver);
		 signInPage.loginValidBrand("ghislain.mukendi@hivency.com", "Hivency01");
		 BrandAppPage.goCampaigns();
		 Thread.sleep(1000);
		 BrandAppPage.goFollowUp();
		 Thread.sleep(1000);
		 FollowUpPage.goPendingInfluencer();
		 FollowUpPage.goPendingshipement();
		 Thread.sleep(12000);
	}
	
	@Test
	public void createCampaign() throws InterruptedException {
		
		 SignInPage signInPage = new SignInPage(driver);
		 signInPage.loginValidBrand("ghislain.mukendi@hivency.com", "Hivency01");
		
	}
	

}
