package autotest.automate.webapp.brand.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfileMenu extends BrandAppPage{
	
	private static By brandProfile = By.xpath("//div[contains(text(),'brand')]");
	private static By userProfile = By.xpath("//div[contains(text(),'brand')]");
	private static By language = By.xpath("//div[contains(text(),'brand')]");
    private static By testBrand3 = By.xpath("//*[contains(text(),'Test brand 3')]");
    private static By lalalab = By.cssSelector(".dropdown-item:nth-child(4) .brand-name");
    private static By profileSelector = By.cssSelector(".ml-2 > .d-flex");
    private static By languageSelector = By.cssSelector(".dropdown-title-language");
   
    private static By frenchFlag  = By.cssSelector(".dropdown-item:nth-child(2) > .language-item");
    private static By britishFlag = By.cssSelector(".dropdown-item:nth-child(3) > .language-item");
    private static By spanishFlag = By.cssSelector(".dropdown-item:nth-child(6) > .language-item");
    private static By germanFlag =  By.cssSelector(".dropdown-item:nth-child(7) > .language-item");
    
 //   private static By testBrand3 = By.xpath("//*[contains(text(),'Test brand 3')]");
	
  
	
	public ProfileMenu(WebDriver driver) {
		super(driver);
	}

	public static void goBrandProfile() {
		driver.findElement(profileSelector).click();
	}
	
	public static void goUserProfile() {
		List<WebElement> profileElements = driver.findElements(profileElementsBy);
		WebElement userProfile = profileElements.get(2);
		userProfile.click();
	}
	
	public static void selectBrand() {
	     goBrandProfile();
	     driver.findElement(lalalab).click();
	}
	
	public static void goLangague() {
		driver.findElement(languageSelector).click();
	}

	public static void changeLanguage() {
		goLangague();
		driver.findElement(britishFlag).click();
		
	}
}
