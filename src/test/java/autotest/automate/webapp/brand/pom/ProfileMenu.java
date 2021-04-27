package autotest.automate.webapp.brand.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfileMenu extends BrandAppPage{
	
	static String brandProfile = "brand_profile";
	static String userProfile = "user_profile";
	static String language = "language";
    static String testBrand3 = "testBrand3";
    static String lalalab = "lalalab";
    static String profileSelector = "profile_selector";
    static String languageSelector = "language_selector";
   
    static String frenchFlag = "french_flag";
    static String britishFlag = "british_flag";
    static String spanishFlag = "spanish_flag";
    static String germanFlag = "german_flag";
    
 //   private static By testBrand3 = By.xpath("//*[contains(text(),'Test brand 3')]");

	public ProfileMenu(WebDriver driver) {
		super(driver);
	}

	public static void goBrandProfile() {
		getElementByCSS(profileSelector).click();
	}
	
	public static void goUserProfile() {
		List<WebElement> profile_Elements = getElementsByClass(profileElements);
		WebElement userProfile = profile_Elements.get(2);
		userProfile.click();
	}
	
	public static void selectBrand() {
	     goBrandProfile();
	     getElementByCSS(lalalab).click();
	}
	
	public static void goLangague() {
		getElementByCSS(languageSelector).click();
	}

	public static void changeLanguage() {
		goLangague();
		getElementByCSS(britishFlag).click();
		
	}
}
