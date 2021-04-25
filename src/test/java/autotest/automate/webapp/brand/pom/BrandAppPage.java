package autotest.automate.webapp.brand.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import autotest.automate.*;

public class BrandAppPage extends BaseTest{
	
	// protected static WebDriver driver;

	static String followUpLink = "followUp_link";
	static String campaignsLink = "campaigns_link";
	static String influencersLink = "influencers_link";
	static String messagingLink = "messaging_link";
	static String offersLink = "offers_link";
	static String imagesLink = "images_link";
	static String statisticslink = "statistics_link";
	
	static String publicationsLink = "publications_link";
 	static String profileElements = "profile_elements";
 	
	// private static List<WebElement> profileElements = driver.findElements(profileElementsBy);
	
	public BrandAppPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public static FollowUpPage goFollowUp() {
		getElementByXPath(followUpLink).click();
		return new FollowUpPage(driver);
	}
	
	public static CampaignsPage goCampaigns() {
		getElementByXPath(campaignsLink).click();
		return new CampaignsPage(driver);
	}
	
	public static CampaignsPage goInfluencers() {
		getElementByXPath(influencersLink).click();
		return new CampaignsPage(driver);
	}
	
	public static CampaignsPage goMessages() {
		getElementByXPath(messagingLink).click();
		return new CampaignsPage(driver);
	}
	
	public static CampaignsPage goImages() {
		getElementByXPath(imagesLink).click();
		return new CampaignsPage(driver);
	}
	
	public static CampaignsPage goOffers() {
		getElementByXPath(offersLink).click();
		return new CampaignsPage(driver);
	}
	
	public static CampaignsPage goStatistics() {
		getElementByXPath(statisticslink).click();
		return new CampaignsPage(driver);
	}
	

	
	public static void goLangague() {
		List<WebElement> profile_Elements = getElementsByXPath(profileElements);
		WebElement language = profile_Elements.get(1);
		language.click();
	}


	

}
