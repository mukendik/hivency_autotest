package autotest.automate.webapp.brand.testcases;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import autotest.automate.PomBrand;
import autotest.automate.webapp.brand.pom.CampaignsPage;
import autotest.automate.webapp.brand.pom.FollowUpPage;
import autotest.automate.webapp.brand.pom.ProfileMenu;
import autotest.automate.webapp.brand.pom.SignInPage;

public class InfluencerValidation extends PomBrand{
	
	// @Test
	public void validateAllInfluencer() throws InterruptedException{
		SignInPage signIn = new SignInPage(driver);
		signIn.loginValidBrand(51400);  //   183382
		Thread.sleep(3000);
		ProfileMenu.changeLanguage();
		Thread.sleep(3000);
		ProfileMenu.selectBrand();
		Thread.sleep(3000);
		CampaignsPage.goCampaigns();
		CampaignsPage.goFollowUp();
		Thread.sleep(300);
		FollowUpPage.goPendingInfluencer();
		Thread.sleep(6000);
		FollowUpPage.acceptAllInfluencers();
		Thread.sleep(3000);
	}
	
	@Test
	public void refuseAllInfluencer() throws InterruptedException{
		SignInPage signIn = new SignInPage(driver);
		signIn.loginValidBrand(51400);  //   183382
		Thread.sleep(3000);
		ProfileMenu.changeLanguage();
		Thread.sleep(3000);
		ProfileMenu.selectBrand();
		Thread.sleep(3000);
		CampaignsPage.goCampaigns();
		CampaignsPage.goFollowUp();
		Thread.sleep(300);
		FollowUpPage.goPendingInfluencer();
		Thread.sleep(6000);
		FollowUpPage.refuseAllInfluencers();
		Thread.sleep(3000);
		// implement in accept this on confirmation message
	}
	
	// @Test
	public void validateOneInfluencer() throws InterruptedException, NoSuchElementException {
		SignInPage signIn = new SignInPage(driver);
		signIn.loginValidBrand(51400);  // 51400
		Thread.sleep(3000);
		ProfileMenu.changeLanguage();
		Thread.sleep(3000);
		ProfileMenu.selectBrand();
		Thread.sleep(3000);
		CampaignsPage.goCampaigns();
		CampaignsPage.goFollowUp();
		Thread.sleep(300);
		FollowUpPage.goPendingInfluencer();
	
		// implement accept one influencer workflow
		FollowUpPage.selectCampaign("Mini Box");
		Thread.sleep(12000);
		
	}
	
	// @Test
	public void refuseOneInfluencer() throws InterruptedException {
		SignInPage signIn = new SignInPage(driver);
		signIn.loginValidBrand(183382);  // 51400
		Thread.sleep(3000);
		ProfileMenu.changeLanguage();
		Thread.sleep(3000);
		ProfileMenu.selectBrand();
		Thread.sleep(3000);
		CampaignsPage.goFollowUp();
		Thread.sleep(300);
		FollowUpPage.goPendingInfluencer();
		Thread.sleep(6000);
		// implement refuse one influencer workflow
		
	}

}
