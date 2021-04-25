package autotest.automate.webapp.brand.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import autotest.automate.*;

public class BrandAppPage extends BaseTest{
	
	protected static WebDriver driver;

	private static By followUpLink =     By.xpath("//div[contains(text(),'Follow up')]");
	private static By campaignsLink =    By.xpath("//div[contains(text(),'Campaigns')]");
	private static By influencersLink =  By.xpath("//div[contains(text(),'Influencers')]");
	private static By messagingLink =    By.xpath("//div[contains(text(),'Campaigns')]");
	private static By offersLink =       By.xpath("//div[contains(text(),'Offers')]");
	private static By imagesLink =       By.xpath("//div[contains(text(),'Images')]");
	private static By statisticslink =   By.xpath("//div[contains(text(),'Statistics')]");
	
	protected static By publicationsLink = By.xpath("//div[contains(text(),'Publications')]");
 	protected static By profileElementsBy = By.className("custom-dropdown");
	
	// private static List<WebElement> profileElements = driver.findElements(profileElementsBy);
	
	public BrandAppPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public static FollowUpPage goFollowUp() {
		driver.findElement(followUpLink).click();
		return new FollowUpPage(driver);
	}
	
	public static CampaignsPage goCampaigns() {
		driver.findElement(campaignsLink).click();
		return new CampaignsPage(driver);
	}
	
	public static CampaignsPage goInfluencers() {
		driver.findElement(influencersLink).click();
		return new CampaignsPage(driver);
	}
	
	public static CampaignsPage goMessages() {
		driver.findElement(messagingLink).click();
		return new CampaignsPage(driver);
	}
	
	public static CampaignsPage goImages() {
		driver.findElement(imagesLink).click();
		return new CampaignsPage(driver);
	}
	
	public static CampaignsPage goOffers() {
		driver.findElement(offersLink).click();
		return new CampaignsPage(driver);
	}
	
	public static CampaignsPage goStatistics() {
		driver.findElement(statisticslink).click();
		return new CampaignsPage(driver);
	}
	

	
	public static void goLangague() {
		List<WebElement> profileElements = driver.findElements(profileElementsBy);
		WebElement language = profileElements.get(1);
		language.click();
	}


	

}
