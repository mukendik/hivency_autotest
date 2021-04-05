package autotest.automate.webapp.influencer.pom;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import autotest.automate.PomInfluencer;


public class StoreInfluencer{

	protected static WebDriver driver;
	
	private static By menuItems = By.tagName("button");
//	private By orders = By.xpath("//p[contains(text(),'Orders')]");
//	private RelativeBy order = RelativeLocator.withTagName("").below(orders);
//	private By orders1 = By.xpath("//a[@href ='orders']");
	private static By profilePicture = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div[2]/div/button/div[1]/img");
	private static By language = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div[4]/div/button/div[1]/span/div/svg");
	private static By filterSearch = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div[1]/div/div/div/div/svg");
	private static By profile = By.xpath("//div[contains(text(),'My profile')]");
	private static By brandsProduct = By.xpath("//div[contains(text(),'Test brand 3')]");

	//  private By messageBy = By.tagName("h1");

	public StoreInfluencer(WebDriver driver) {
		super();
		this.driver = driver;	  
	}  
	
	  public static Orders orderLinkPage() {
			List<WebElement> menuElements = driver.findElements(menuItems);
			WebElement OrderLink = menuElements.get(2);
			OrderLink.click();
		  return new Orders(driver); 
	  }
	  
	  public static Publications publicationLinkPage() {
			List<WebElement> menuElements = driver.findElements(menuItems);
			WebElement publicationLink = menuElements.get(1);
			publicationLink.click();
		  return new Publications(driver); 
	  }
	  
	  public static Credits creditLinkPage() {
			List<WebElement> menuElements = driver.findElements(menuItems);
			WebElement creditLink = menuElements.get(4);
			creditLink.click();
		  return new Credits(driver); 
	  }
	  
	  public static Messaging messagingPage() {
			List<WebElement> menuElements = driver.findElements(menuItems);
			WebElement messagingLink = menuElements.get(5);
			messagingLink.click();
		  return new Messaging(driver); 
	  }
	
	  public StoreInfluencer selectLangage() {
		  driver.findElement(language).click();
		return new StoreInfluencer(driver);  
	  }
	  
	  public StoreInfluencer filterSerch() {
		  driver.findElement(filterSearch).click();
		  return new StoreInfluencer(driver); 
	  }
	  
	  public static ManageProfile manageProfile() {
		    // Page encapsulation to manage profile functionality
		  	driver.findElement(profilePicture).click();
		    driver.findElement(profile).click();
		    return new ManageProfile(driver);
		  }
	  public static void goBrandsProduct() throws InterruptedException {
		  driver.findElement(brandsProduct);
		  driver.findElement(By.xpath("//div[contains(text(),'Test brand 3')]")).click();
		  Thread.sleep(600);
		  WebElement YoutubeLogo = driver.findElement(By.id("prefix__Layer_1")); 
		  Thread.sleep(2000);
		  YoutubeLogo.click();
		  Thread.sleep(2000);
			 try {			
					WebElement continueButton=
					driver.findElement(By.xpath("//span[contains(text(),'continue')]"));
					continueButton.click(); 
			  }	 
			  catch(Exception e) {
				  {  	 
					List<WebElement> OrderElements = driver.findElements(By.tagName("button"));
					OrderElements.get(13).click();
				  }
			 }

				  // check the CGU radio check : "I have read and understand the conditions*"  and click on continue
				  
				  try {
				  WebElement CguRadioCheck = driver.findElement(By.
				  xpath("//div[contains(text(),'bien pris connaissance des conditions et des')]"  ));
				  CguRadioCheck.click();
				  } 
				  catch (Exception e) { 
				  Thread.sleep(1000);
				  WebElement CguRadioCheck = driver.findElement(By.
				  id("conditions" )); 
				  if (CguRadioCheck.isDisplayed()) { CguRadioCheck.click(); } }
				  
				  // click on continue
				  
				  Thread.sleep(600);
				  if(driver.findElement(By.xpath("//span[contains(text(),'continue')]")).
				  isDisplayed()) { WebElement continueButton=
				  driver.findElement(By.xpath("//span[contains(text(),'continuer')]"));
				  continueButton.click(); } 
				  else {
				  
				  Thread.sleep(2000); WebElement continueButton=
				  driver.findElement(By.xpath("//span[contains(text(),'continuer')]"));
				  continueButton.click(); }
				  
				  // click on order button
				  
				  WebElement OrderButton=
				  driver.findElement(By.xpath("//span[contains(text(),'commander')]"));
				  
				  // Si boutton commander pas visible, remplir l'adresse
				  
				  if(!OrderButton.isEnabled()) { 
				 completeAddress();
				  
				  } 
				 
				//  click on order
				  OrderButton.click();
				  Thread.sleep(1000);
				  driver.findElement(By.xpath("//span[contains(text(),'simple')]")).click();
				  
				  Thread.sleep(5000);
	  }
	  
	  private static void completeAddress() {
 		  WebElement address =
		  driver.findElement(By.id("react-google-places-autocomplete-input"));
		  address.sendKeys("5 Rue Pernelle, 75004 Paris");
		  
		  WebElement CountrySelectIndex=
		  driver.findElement(By.xpath("//span[contains(text(),'sélectionnez')]"));
		  
		  Actions builder = new Actions(driver);
		  builder.moveToElement(CountrySelectIndex).clickAndHold().perform();
		  
		  Actions keyDown2 = new Actions(driver);
		  keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN,
		  Keys.DOWN,Keys.DOWN,Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
		  Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,Keys.DOWN, Keys.DOWN, Keys.DOWN,
		  Keys.DOWN,Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
		  Keys.DOWN, Keys.DOWN,Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,Keys.DOWN,
		  Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
		  Keys.DOWN,Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,Keys.DOWN, Keys.DOWN,
		  Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,Keys.DOWN,
		  Keys.DOWN, Keys.DOWN, Keys.DOWN,Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
		  Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,Keys.DOWN, Keys.DOWN, Keys.DOWN,
		  Keys.DOWN,Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
		  Keys.DOWN,Keys.DOWN, Keys.ENTER)).perform();
		  
		  WebElement phoneNumber= driver.findElement(By.id("phone_number"));
		  phoneNumber.sendKeys("0610101010");
		  
		  WebElement saveButton=
		  driver.findElement(By.xpath("//span[contains(text(),'Enregistrer')]"));
		  saveButton.click();

}

}
