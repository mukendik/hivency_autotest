package autotest.automate.webapp.brand.testcases;

import org.testng.annotations.Test;

import autotest.automate.PomBrand;
import autotest.automate.webapp.brand.pom.CampaignsPage;
import autotest.automate.webapp.brand.pom.FollowUpPage;
import autotest.automate.webapp.brand.pom.ProfileMenu;
import autotest.automate.webapp.brand.pom.SignInPage;

public class Shipment extends PomBrand{
	
	// @Test
	public void shipAllProducts() throws InterruptedException{
		SignInPage signIn = new SignInPage(driver);
		signIn.loginValidBrand(51400);
		Thread.sleep(3000);
		ProfileMenu.changeLanguage();
		Thread.sleep(3000);
		ProfileMenu.selectBrand();
		Thread.sleep(3000);
		CampaignsPage.goFollowUp();
		Thread.sleep(300);
		FollowUpPage.goPendingshipement();
		Thread.sleep(300);
		FollowUpPage.shipAll();
		Thread.sleep(7000);
	}
	
	@Test
	public void shipOneProduct() throws InterruptedException{
		SignInPage signIn = new SignInPage(driver);
		signIn.loginValidBrand(51400);
		Thread.sleep(3000);
		ProfileMenu.changeLanguage();
		Thread.sleep(3000);
		ProfileMenu.selectBrand();
		Thread.sleep(3000);
		CampaignsPage.goFollowUp();
		Thread.sleep(300);
		FollowUpPage.goPendingshipement();
		Thread.sleep(300);
		FollowUpPage.shipOne();
		Thread.sleep(7000);
	}

}
