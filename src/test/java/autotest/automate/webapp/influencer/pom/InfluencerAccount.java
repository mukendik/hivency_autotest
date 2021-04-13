package autotest.automate.webapp.influencer.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class InfluencerAccount extends StoreInfluencer{

	private static By editUser = By.cssSelector(".accountDropdown_textContent__3s26j:nth-child(1)");
	private static By profileLink = By.cssSelector("button:nth-child(2) > span");
	private static By fistName    = By.id("firstname");
	private static By authentInfo    = By.xpath("//a[@href ='/profile/user']");
	

	private static By selectLanguage  = By.cssSelector(".render_providerContainer__8Kjsu > svg > path:nth-child(1)");
	private static By ArrowSelect     = By.cssSelector(".dropdown_arrowContainer__Wetqq svg");
	private static By frenchFlag      = By.cssSelector("button:nth-child(2) path:nth-child(2)");
	private static By germanFlag      = By.cssSelector(".dropdown_listItem__TESSQ:nth-child(3) path:nth-child(1)");
	private static By retailFlag      = By.cssSelector(".dropdown_listItem__TESSQ:nth-child(5) path:nth-child(1)");
	private static By spanishFlag     = By.cssSelector(".dropdown_listItem__TESSQ:nth-child(4) path:nth-child(2)");
	private static By britishFlag     = By.cssSelector(".dropdown_listItem__TESSQ:nth-child(2) path:nth-child(4)");
	
	
	private static By shippingLink = By.xpath("//*[contains(text(),'information')]");
	private static By changeAddressBtn = By.xpath("//*[contains(text(),'modifier')]");
	private static By linkByPartialText = By.linkText("Type your address");
	private static By newAddress = By.id("react-google-places-autocomplete-input");
	private static By saveBtn = By.xpath("//span[contains(text(),'Save')]");
	
	
	
	public InfluencerAccount(WebDriver driver) {
		super(driver);
	}
	
	public static void myProfile() {
		driver.findElement(editUser).click();
		driver.findElement(profileLink).click();
	}
	
	public static void changePassword() {
		myProfile();
		driver.findElement(authentInfo).click();
	}

	public  static void editInfluencerProfile() throws InterruptedException {
		myProfile();
		driver.findElement(fistName).clear();
		driver.findElement(fistName).sendKeys("MUKENDI");
		driver.findElement(saveBtn).click();
		Thread.sleep(1000);
	}
	
	public static void changeLanguage() throws InterruptedException {
 
        WebElement element = driver.findElement(ArrowSelect); 
        element.click();
        WebElement element2 = driver.findElement(germanFlag);
        Thread.sleep(600);
        element2.click();
        Thread.sleep(600);
        element.click();
        WebElement element4 = driver.findElement(britishFlag);
        element4.click();
        
	}
	
	public  static void editShippingInfo() throws InterruptedException {
		editInfluencerProfile();
		driver.findElement(shippingLink).click();
		driver.findElement(changeAddressBtn).click();
		driver.findElement(newAddress).clear();
		driver.findElement(newAddress).sendKeys("60 Rue Victor Hugo, Maisons-Alfort, France");
		driver.findElement(newAddress).submit();
		Thread.sleep(9000);
		driver.findElement(saveBtn).click();
     // driver.findElement(linkByPartialText).click();
	}
	
	public  static void addSocialNetword() {
	
	}



}
