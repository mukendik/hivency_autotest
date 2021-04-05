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

	// protected static WebDriver driver;
	
	private static By allCampaigns = By.xpath("//div[contains(text(),'all campaigns']");
	private static By draft = By.xpath("//div[contains(text(),'draft']");
	private static By published = By.xpath("//div[contains(text(),'published']");
	private static By awaitingPublication = By.xpath("//div[contains(text(),'awaiting publication']");
	private static By completed = By.xpath("//div[contains(text(),'completed']");
	private static By createCampaign = By.className("success");
	
	private static By campaignName = By.id("campaignName");
	private static By catchPhrase = By.id("catchPhrase");
	private static By addPicture = By.id("addPicture");
	private static By DayPicker = By.cssSelector(".DayPickerInput > input");
	private static By DayPickerCh1 = By.cssSelector("#root > div.global-content-wrapper > div.content-container > div:nth-child(2) > div > div.mt-3.container-fluid.form > div > div > div.d-flex.flex-column.wrapper-form > div > div.section.d-flex.flex-column > div.d-flex.flex-column.form-group > div.d-flex.flex-row.align-items-center > div.mr-3 > div > div.day-picker-container > div > div > div.DayPicker-Months > div:nth-child(2) > div.DayPicker-Body > div:nth-child(2) > div:nth-child(2)");
	private static By DayPickerCh2 = By.cssSelector("#root > div.global-content-wrapper > div.content-container > div:nth-child(2) > div > div.mt-3.container-fluid.form > div > div > div.d-flex.flex-column.wrapper-form > div > div.section.d-flex.flex-column");
	private static By selector = By.className("Select-multi-value-wrapper");
//	private static By offerSchokolade = By.xpath("//div[contains(text(),'Schokolade')]");
	private static By offerPoster = By.xpath("//*[contains(text(),'hiver')]");
	private static By buttonWrapper = By.className("button-wrapper");
	private static By validateButtonBy = By.className("primary");

	
	private static By notDeleteInstr = By.xpath("//*[contains(text(),'delete')]");
	private static By selectInstructions = By.xpath("//*[contains(text(),'Select an instruction')]");
	
	

	public CampaignsPage(WebDriver driver) {
		super(driver);
	}
	
	public static void goCampaignCreation() {
		driver.findElement(createCampaign).click();
		// return new CampaignsPage(driver);
	}
	
public static void fillStepOne() throws InterruptedException {
		
		Thread.sleep(1200); 
		driver.findElement(campaignName).sendKeys("Autotest Campaign");
		driver.findElement(catchPhrase).sendKeys("Autotest is very fun");
		driver.findElement(addPicture).sendKeys("C:\\Users\\Utilisateur\\Desktop\\My Images\\Tests images\\images.jfif");
		
	//	 driver.findElement(By.cssSelector(".DayPickerInput > input")).click();
		 driver.findElement(DayPicker).click();
		 driver.findElement(DayPickerCh1).click();
		 driver.findElement(DayPickerCh2).click();

		 
		 JavascriptExecutor javascript = (JavascriptExecutor) driver;
		 javascript.executeScript("window.scrollBy(0,600)", "");
		
		  
			List<WebElement> select =  driver.findElements(selector);
			
			//	select ACTIVITY SECTOR category :: 

			    WebElement activitySector = select.get(0);
			    Thread.sleep(1000);	
			    
			    Actions builder = new Actions(driver);
			      builder.moveToElement(activitySector).clickAndHold().perform();
			      
			  	{
					  try {
						Thread.sleep(2000);  

						Actions keyDown = new Actions(driver); 
						keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
								Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
			
					} catch (InterruptedException e) {
						
						System.out.println("echec selection secteur d'activité");
											
					}
				} 
				 
				//	 Select nombre de collaboration :: 21
					 driver.findElement(By.id("quantity")).sendKeys("21");
			 
			   //    Select an offer :: Schokolade
		 
		 WebElement offer = select.get(1);
	
						{
					   
							  Actions builder0 = new Actions(driver);
							  builder0.moveToElement(offer).clickAndHold().perform(); 
						} 
						{
							  Thread.sleep(1000); 
							  WebElement OfferValue =
							  driver.findElement(offerPoster);
							  OfferValue.click();
						} 
							
				// validate and continue
               List<WebElement> buttons = driver.findElements(buttonWrapper);
               
		 		WebElement validateButton = buttons.get(buttons.size()-1);
				
	    		validateButton.click();
					  
				try {
					
					WebElement element = driver.findElement(validateButtonBy);
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", element);	
					System.out.println("click on validate done ... 2");
				}
				catch (Exception e2) {
					System.out.println("click on validate not done !!");
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
              List<WebElement> buttons = driver.findElements(buttonWrapper);
              
		 		WebElement validateButton = buttons.get(buttons.size()-1);
      
		 		validateButton.click();
	    		
				System.out.println("click on validate done ... 1");
					  
				try {
					
					WebElement element = driver.findElement(validateButtonBy);
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
		List<WebElement> buttons = driver.findElements(By.className("button-wrapper"));
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
		driver.findElement(selectInstructions).click();
		 Thread.sleep(200);
		driver.findElement(notDeleteInstr).click();
		// validate and continue
	   	List<WebElement> buttons = driver.findElements(By.className("button-wrapper"));
		   WebElement validateButton2 = buttons.get(buttons.size()-1);
	       validateButton2.click();
	    		
	       Thread.sleep(4000);
	}

	public static void fillFinalStep() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		
		Thread.sleep(2000);
		
		 // validate and publish
			List<WebElement> buttons = driver.findElements(By.className("button-wrapper"));
		    WebElement validateButton4 = buttons.get(buttons.size()-1);
			validateButton4.click();
			 		
		Thread.sleep(4000);
	}
	
	public static void publishedTab() throws InterruptedException {	
		driver.findElement(published).click();
	}
	
	public static void awaitingPubTab() throws InterruptedException {
		driver.findElement(awaitingPublication).click();
	}
	
	public static void completedTab() throws InterruptedException {
		driver.findElement(completed).click();
	}
 
	public static void allCampaignsTab() throws InterruptedException {
		driver.findElement(allCampaigns).click();
	}
	
	public static void draftTab() throws InterruptedException {
		driver.findElement(draft).click();
	}

}
