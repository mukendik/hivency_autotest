package autotest.automate.webapp.brand.pom;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CampaignsPage extends BrandAppPage{


	static String allCampaigns =  "all_campaigns_page"; 
	static String draft = "draft_page";
	static String published = "published_page";
	static String awaitingPublication = "awaitingPublication_tab";
	static String completed = "completed_tab";
	static String createCampaign = "createCampaign_btn";
	
	static String campaignName = "campaign_name";
	static String catchPhrase = "catch_phrase";
	static String addPicture = "add_picture";
	static String DayPicker = "Day_picker";
	static String DayPickerCh1 = "Day_pickerCh1";
	static String DayPickerCh2 = "Day_pickerCh2";
	static String selector = "selector";
//	private static By offerSchokolade = By.xpath("//div[contains(text(),'Schokolade')]");
	static String offerPoster = "offer_poster";
	static String buttonWrapper = "button_wrapper";
	static String validateBtn = "validate_button";
	static String collaborationNumber = "quantity";

	
	static String notDeleteInstr = "notDelete_instr";
	static String selectInstructions = "select_instructions";

	public CampaignsPage(WebDriver driver) {
		super(driver);
	}
	
	
	public static void publishedTab() throws InterruptedException {	
		getElementByXPath("published").click();
	}
	
	public static void awaitingPubTab() throws InterruptedException {
		getElementByXPath("awaitingPublication").click();
	}
	
	public static void completedTab() throws InterruptedException {
		getElementByXPath("completed").click();
	}
 
	public static void allCampaignsTab() throws InterruptedException {
		getElementByXPath("allCampaigns").click();
	}
	
	public static void draftTab() throws InterruptedException {
		getElementByXPath("draft").click();
	}
	
	public static void goCampaignCreation() {
		getElementByClass(createCampaign).click();
	}
	
public static void fillStepOne() throws InterruptedException {
		
		Thread.sleep(1200); 
		getElementByID(campaignName).sendKeys("TNR 23/04/2021");
		getElementByID(catchPhrase).sendKeys("TNR autotest revisited");
		getElementByID(addPicture).sendKeys("C:\\Users\\muken\\Desktop\\images for tests\\test.png");
		
		getElementByCSS(DayPicker).click();
		getElementByCSS(DayPickerCh1).click();
	//	getElementByCSS(DayPickerCh2).click();

		 
		 JavascriptExecutor javascript = (JavascriptExecutor) driver;
		 javascript.executeScript("window.scrollBy(0,600)", "");
			   
				//	 type number of Collaboration :: 21
					 getElementByID(collaborationNumber).sendKeys("21");
			 
			   //    Select an offer :: Schokolade
					 selectOffer();
					 
			   //	select ACTIVITY SECTOR category :: 
				    selectCategory();
		 
							
				// validate and continue
               List<WebElement> buttons = getElementsByClass(buttonWrapper);
               
		 		WebElement validateButton = buttons.get(buttons.size()-1);
	  
				try {
					validateButton.click();
					Add_Log.debug("click on validate done");
					/*
					 * try { WebElement element = getElementByXPath(validateBtn); JavascriptExecutor
					 * executor = (JavascriptExecutor)driver;
					 * executor.executeScript("arguments[0].click();", element);
					 * Add_Log.debug("click on validate done"); }
					 */
				}
				catch (Exception e2) {
					Add_Log.debug("click on validate not done !!");
				}
					Thread.sleep(1000);
	}


	public static void fillStepTwo() throws InterruptedException {
		//	  select network :: youtube

			  WebElement youtubeNetwork = driver.findElement(By.id("selectProvider0"));
			  JavascriptExecutor executor = (JavascriptExecutor)driver;
			  executor.executeScript("arguments[0].click();", youtubeNetwork);
  
			  JavascriptExecutor javascript3 = (JavascriptExecutor) driver;
			  javascript3.executeScript("window.scrollBy(0,500)", "");
		  
		//	 select country
				
				Thread.sleep(1000);
						  
				 WebElement Countryselection = driver.findElement(By.className("Select-multi-value-wrapper"));
					
				 Actions builder2 = new Actions(driver);
				 builder2.moveToElement(Countryselection).clickAndHold().perform();
						      
				 Actions keyDown2 = new Actions(driver); 
					keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,Keys.DOWN,Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
							Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
							Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
							Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
							Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
							Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
							Keys.DOWN, Keys.DOWN, Keys.DOWN,Keys.DOWN,  Keys.ENTER)).perform();
	
  	//	 select universe
			  
			  Thread.sleep(2000); 
			  
			  WebElement beauty = driver.findElement(By.id("4"));
			  WebElement Fashion = driver.findElement(By.id("5"));
			  WebElement LifeStyle = driver.findElement(By.id("7"));
				/*
				 * WebElement food = driver.findElement(By.id("2")); WebElement sport =
				 * driver.findElement(By.id("3")); WebElement travel =
				 * driver.findElement(By.id("9")); WebElement deco =
				 * driver.findElement(By.id("1")); WebElement photo =
				 * driver.findElement(By.id("10")); WebElement childen =
				 * driver.findElement(By.id("6")); WebElement hightech =
				 * driver.findElement(By.id("8")); WebElement Art =
				 * driver.findElement(By.id("11"));
				 */
			  
			 
	//	 Select univers :: Beauté, mode, lifestyle
			  
			  executor.executeScript("arguments[0].click();", beauty);
			  executor.executeScript("arguments[0].click();", Fashion);
			  executor.executeScript("arguments[0].click();", LifeStyle);
			  

		// validate and continue
              List<WebElement> buttons = getElementsByClass(buttonWrapper);
              
		 		WebElement validateButton = buttons.get(buttons.size()-1);
      
		 		validateButton.click();
	    		
				System.out.println("click on validate done ... 1");
					  
				try {
					
					WebElement element = getElementByXPath("validateButton");
					JavascriptExecutor executor2 = (JavascriptExecutor)driver;
					executor2.executeScript("arguments[0].click();", element);	
					System.out.println("click on validate done ... 2");
				}
				catch (Exception e2) {
					System.out.println("click on validate not done !!");
				}
					Thread.sleep(1000);
	}
	
	public static void stepReview() throws InterruptedException {
		// select network :: Review

		WebElement ReviewNetwork = driver.findElement(By.id("selectProvider4"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ReviewNetwork);

		JavascriptExecutor javascript3 = (JavascriptExecutor) driver;
		javascript3.executeScript("window.scrollBy(0,500)", "");

		// select country

		Thread.sleep(1000);

		WebElement Countryselection = driver.findElement(By.className("Select-multi-value-wrapper"));

		Actions builder2 = new Actions(driver);
		builder2.moveToElement(Countryselection).clickAndHold().perform();

		Actions keyDown2 = new Actions(driver);
		keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
				Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
				Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
				Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
				Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
				Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
				Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
				Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
				Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();

		// select universe

		Thread.sleep(2000);

		WebElement beauty = driver.findElement(By.id("4"));
		WebElement Fashion = driver.findElement(By.id("5"));
		WebElement LifeStyle = driver.findElement(By.id("7"));
		WebElement deco = driver.findElement(By.id("1"));
		WebElement food = driver.findElement(By.id("2"));
		/*
		 * WebElement sport = driver.findElement(By.id("3")); WebElement travel =
		 * driver.findElement(By.id("9")); WebElement photo =
		 * driver.findElement(By.id("10")); WebElement childen =
		 * driver.findElement(By.id("6")); WebElement hightech =
		 * driver.findElement(By.id("8")); WebElement Art =
		 * driver.findElement(By.id("11"));
		 */

		// Select univers :: Beauté, mode, lifestyle

		executor.executeScript("arguments[0].click();", beauty);
		executor.executeScript("arguments[0].click();", Fashion);
		executor.executeScript("arguments[0].click();", LifeStyle);
		executor.executeScript("arguments[0].click();", deco);
		executor.executeScript("arguments[0].click();", food);

		// validate and continue
		List<WebElement> buttons = getElementsByClass(buttonWrapper);
		WebElement validateButton2 = buttons.get(buttons.size() - 1);
		validateButton2.click();

		Thread.sleep(6000);

		// POST INSTRUCTIONS

		WebElement postInstruction = driver.findElement(By.className("Select-placeholder"));

		postInstruction.click();
		Thread.sleep(4000);
		Actions EnterKey = new Actions(driver);
		EnterKey.sendKeys(Keys.chord(Keys.UP, Keys.UP, Keys.ENTER)).perform();
		//EnterKey.sendKeys(Keys.chord(Keys.DOWN, Keys.UP, Keys.UP, Keys.UP, Keys.ENTER)).perform();
		
		// Add Website and page url
		WebElement reviewName = driver.findElement(By.id("Review"));
		reviewName.sendKeys("AUTO Tests Review");
		Thread.sleep(600);

		WebElement reviewUrl = driver.findElement(withTagName("input").toRightOf(reviewName));

		reviewUrl.sendKeys("http://www.sephora.fr");

		Thread.sleep(600);
		// driver.findElement(By.className("review-url")).sendKeys("www.AutotestReview.com");
		driver.findElement(By.className("review-url")).click();
		Thread.sleep(600);

		// Add
		driver.findElement(By.className("success")).click();

		// validate and continue

		// WebElement validateButton3 = buttons.get(buttons.size()-1);

		JavascriptExecutor javascript1 = (JavascriptExecutor) driver;
		javascript1.executeScript("window.scrollBy(0,700)", "");

		Thread.sleep(4000);

		// validate and publish
		WebElement validateButton4 = buttons.get(buttons.size() - 1);
		validateButton4.click();
	}

	public static void fillStepThree() throws InterruptedException {
		// select an instruction 
		getElementByXPath(selectInstructions).click();
		Thread.sleep(200);
		getElementByXPath(notDeleteInstr).click();
		// validate and continue
	   	List<WebElement> buttons = getElementsByClass(buttonWrapper);
		   WebElement validateButton = buttons.get(buttons.size()-1);
	       validateButton.click();
	    		
	       Thread.sleep(4000);
	}

	public static void fillFinalStep() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		
		Thread.sleep(2000);
		
		 // validate and publish
			List<WebElement> buttons = getElementsByClass(buttonWrapper);
		    WebElement validateButton = buttons.get(buttons.size()-1);
			validateButton.click();
			 		
		Thread.sleep(4000);
	}
	
	private static void selectCategory() throws InterruptedException  {
		
		List<WebElement> select =  getElementsByClass(selector);
		WebElement activitySector = select.get(0);
		    Thread.sleep(1500);	
		    
		    Actions builder = new Actions(driver);
		    builder.moveToElement(activitySector).clickAndHold().perform();
		    Add_Log.debug("Selecting Category sector ... ");	
		  	{
				  try {
					Thread.sleep(2000);  

					Actions keyDown = new Actions(driver); 
					keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
							Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
					
					Add_Log.debug("Category sector selected");	
		
				} catch (InterruptedException e) {
					Add_Log.debug("failed to select activity sector");					
				}
			} 
}
	
	public static void selectOffer() throws InterruptedException {
		List<WebElement> select =  getElementsByClass(selector);
		WebElement offer = select.get(1);
		
		{
	   
			  Actions builder0 = new Actions(driver);
			  builder0.moveToElement(offer).clickAndHold().perform(); 
		} 
		{
			  Thread.sleep(1000); 
			  WebElement OfferValue =
			  getElementByXPath(offerPoster);
			  OfferValue.click();
			  Add_Log.debug("Offer selected");
		} 
	
}


}
