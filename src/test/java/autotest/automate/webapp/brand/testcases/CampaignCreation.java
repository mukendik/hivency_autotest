package autotest.automate.webapp.brand.testcases;

import static org.testng.Assert.assertEquals;


import org.testng.annotations.Test;

import autotest.automate.PomBrand;
import autotest.automate.webapp.brand.pom.BrandAppPage;
import autotest.automate.webapp.brand.pom.CampaignsPage;
import autotest.automate.webapp.brand.pom.ProfileMenu;
import autotest.automate.webapp.brand.pom.SignInPage;

public class CampaignCreation extends PomBrand{
	
	// @Test
	public void createCampaign() throws InterruptedException {
		SignInPage brandSignIn = new SignInPage(driver);
		brandSignIn.loginValidBrand(51400);   // 51400 = Annaelle de Lalalab  // 191571 Carmen Hernández
		Thread.sleep(1200);
		BrandAppPage.goLangague();
		ProfileMenu.selectBrand();
		Thread.sleep(800);
		ProfileMenu.changeLanguage();
		BrandAppPage.goCampaigns();
		Thread.sleep(1200);
		CampaignsPage.goCampaignCreation();
		Thread.sleep(1200);
		CampaignsPage.fillStepOne();
		CampaignsPage.fillStepTwo();
		CampaignsPage.fillStepThree();
		CampaignsPage.fillFinalStep();
		Thread.sleep(3200);
        assertEquals(driver.getCurrentUrl(), "https://app.hivency-release.com/campaigns");
    	// toast message "Your campaigns was successfully published
	}
	
	// @Test
	public void createReviewCampaign() throws InterruptedException {
		SignInPage brandSignIn = new SignInPage(driver);
		brandSignIn.loginValidBrand(51400);   // 51400 = Annaelle de Lalalab
		Thread.sleep(1200);
		BrandAppPage.goLangague();
		ProfileMenu.selectBrand();
		Thread.sleep(800);
		ProfileMenu.changeLanguage();
		BrandAppPage.goCampaigns();
		Thread.sleep(1200);
		CampaignsPage.goCampaignCreation();
		Thread.sleep(1200);
		CampaignsPage.fillStepOne(); 
		CampaignsPage.stepReview();
		CampaignsPage.fillFinalStep();
		Thread.sleep(3200);
		assertEquals(driver.getCurrentUrl(), "https://app.hivency-release.com/campaigns");
		// toast message "your campaigns is successfully published
	}
	
	@Test
	public void closeCampaign() throws InterruptedException {
		SignInPage brandSignIn = new SignInPage(driver);
		brandSignIn.loginValidBrand(51400);   // 51400 = Annaelle de Lalalab
		Thread.sleep(1200);
		BrandAppPage.goLangague();
		ProfileMenu.selectBrand();
		Thread.sleep(800);
		ProfileMenu.changeLanguage();
		BrandAppPage.goCampaigns();
		Thread.sleep(1200);
		CampaignsPage.publishedTab();
		CampaignsPage.closeCampaign("Autotest Campaign");
		assertEquals(driver.getCurrentUrl(), "https://app.hivency-release.com/campaigns/published");
	}
	
	// @Test
	public void duplicateCampaign() throws InterruptedException {
		SignInPage brandSignIn = new SignInPage(driver);
		brandSignIn.loginValidBrand(51400);   // 51400 = Annaelle de Lalalab
		Thread.sleep(1200);
		BrandAppPage.goLangague();
		ProfileMenu.selectBrand();
		Thread.sleep(800);
		ProfileMenu.changeLanguage();
		BrandAppPage.goCampaigns();
		Thread.sleep(1200);
		CampaignsPage.draftTab();
		CampaignsPage.duplicateCampaign("okkkkkk");
		assertEquals(driver.getCurrentUrl(), "https://app.hivency-release.com/campaigns/draft");
	}
	
	// @Test
	public void deleteCampaign() throws InterruptedException {
		
		SignInPage brandSignIn = new SignInPage(driver);
		brandSignIn.loginValidBrand(51400);   // 51400 = Annaelle de Lalalab
		
		Thread.sleep(1200);
		BrandAppPage.goLangague();
		ProfileMenu.selectBrand();
		Thread.sleep(800);
		ProfileMenu.changeLanguage();
		BrandAppPage.goCampaigns();
		Thread.sleep(1000);
		CampaignsPage.draftTab();
		Thread.sleep(4200);
		CampaignsPage.deleteCampaign("Test review campaign instagram");
		assertEquals(driver.getCurrentUrl(), "https://app.hivency-release.com/campaigns/draft");	
	}

}
