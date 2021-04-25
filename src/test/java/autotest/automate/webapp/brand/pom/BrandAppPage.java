package autotest.automate.webapp.brand.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import autotest.automate.*;

public class BrandAppPage extends BaseTest{
	
	// protected static WebDriver driver;

	// private static By followUpLink =     By.xpath("//div[contains(text(),'Follow up')]");
	static String followUpLink = "followUp_link";
	//private static By campaignsLink =    By.xpath("//div[contains(text(),'Campaigns')]");
	static String campaignsLink = "campaigns_link";
	//private static By influencersLink =  By.xpath("//div[contains(text(),'Influencers')]");
	static String influencersLink = "influencers_link";
	//private static By messagingLink =    By.xpath("//div[contains(text(),'Campaigns')]");
	static String messagingLink = "messaging_link";
	// private static By offersLink =       By.xpath("//div[contains(text(),'Offers')]");
	static String offersLink = "offers_link";
	// private static By imagesLink =       By.xpath("//div[contains(text(),'Images')]");
	static String imagesLink = "images_link";
	//private static By statisticslink =   By.xpath("//div[contains(text(),'Statistics')]");
	static String statisticslink = "statistics_link";
	
	// protected static By publicationsLink = By.xpath("//div[contains(text(),'Publications')]");
	static String publicationsLink = "publications_link";
 	// protected static By profileElements = By.className("custom-dropdown");
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
