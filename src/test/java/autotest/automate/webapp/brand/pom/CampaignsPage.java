package autotest.automate.webapp.brand.pom;


import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class CampaignsPage extends BrandAppPage {

	static String allCampaigns = "all_campaigns_page";
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
	static String closebtn = "close_btn";

	// selectUniverse
	static String beautyUniverse = "beauty";
	static String FashionUniverse = "Fashion";
	static String LifeStyleUniverse = "LifeStyle";
	static String foodUniverse = "food";
	static String sportUniverse = "sport";
	static String travelUniverse = "travel";
	static String decoUniverse = "deco";
	static String childenUniverse = "childen";
	static String hightechUniverse = "hightech";
	static String ArtUniverse = "Art";

	static String notDeleteInstr = "notDelete_instr";
	static String selectInstructions = "select_instructions";
	static String postInstruction = "post_instruction";
	static String reviewName = "review_name";
	static String reviewUrlbtn = "review_url";
	static String addReviewbtn = "add_review";

	static String imagesPath = "\\src\\test\\resources\\images\\";

	public CampaignsPage(WebDriver driver) {
		super(driver);
	}

	public static void publishedTab() throws InterruptedException {
		WebElement publishedElement = getElementByXPath(published);
		javascript.executeScript("arguments[0].setAttribute('display', 'none')", publishedElement);
		javascript.executeScript("arguments[0].click();", publishedElement);
	}

	public static void awaitingPubTab() throws InterruptedException {
		WebElement awaitingPublicationElement = getElementByXPath(awaitingPublication);
		javascript.executeScript("arguments[0].setAttribute('display', 'none')", awaitingPublicationElement);
		javascript.executeScript("arguments[0].click();", awaitingPublicationElement);
	}

	public static void completedTab() throws InterruptedException {
		WebElement completedElement = getElementByXPath(completed);
		javascript.executeScript("arguments[0].setAttribute('display', 'none')", completedElement);
		javascript.executeScript("arguments[0].click();", completedElement);
	}

	public static void allCampaignsTab() throws InterruptedException {
		WebElement allCampaignsElement = getElementByXPath(allCampaigns);
		javascript.executeScript("arguments[0].setAttribute('display', 'none')", allCampaignsElement);
		javascript.executeScript("arguments[0].click();", allCampaignsElement);
	}

	public static void draftTab() throws InterruptedException {
		WebElement draftElement = getElementByXPath(draft);
		javascript.executeScript("arguments[0].setAttribute('display', 'none')", draftElement);
		javascript.executeScript("arguments[0].click();", draftElement);
	}

	public static void goCampaignCreation() {
		getElementByClass(createCampaign).click();
	}

	public static void fillStepOne() throws InterruptedException {

		Thread.sleep(1200);
		getElementByID(campaignName).sendKeys("Regression 07/05 campaign");
		getElementByID(catchPhrase).sendKeys("autotest regression revisited");
		getElementByID(addPicture).sendKeys(System.getProperty("user.dir") + imagesPath + "pexels-photo-230544.jpeg");

		getElementByCSS(DayPicker).click();
		getElementByCSS(DayPickerCh1).click();

		javascript.executeScript("window.scrollBy(0,600)", "");

		// type number of Collaboration :: 21
		getElementByID(collaborationNumber).sendKeys("12");

		// Select an offer :: Schokolade
		selectOffer();

		// select ACTIVITY SECTOR category ::
		selectCategories();

		// validate and continue
		validateAndContinue();

		Thread.sleep(1000);
	}

	public static void fillStepTwo() throws InterruptedException {
		// select network :: instagram
		selectNetwork(Network.instagram);

		// select country
		selectCountry();

		// select universe
		selectUniverse();

		// validate and continue
		validateAndContinue();
	}

	public static void stepReview() throws InterruptedException {
		// select network :: Review
		selectNetwork(Network.review);

		// select country
		selectCountry();

		// select universe
		selectUniverse();

		// validate and continue
		validateAndContinue();

		// POST INSTRUCTIONS
		postInstructions();

		// validate and continue
		validateAndContinue();

		// validate and publish
		validateAndPublish();

	}

	private static void postInstructions() throws InterruptedException {

		getElementByClass(postInstruction).click();

		Thread.sleep(4000);

		// select an instruction :: post a consumer review on a website
		Actions EnterKey = new Actions(driver);
		EnterKey.sendKeys(Keys.chord(Keys.UP, Keys.UP, Keys.ENTER)).perform();

		// Add Website and page url
		WebElement setReviewName = getElementByID(reviewName);

		setReviewName.sendKeys("AUTO Tests Review");
		Thread.sleep(600);

		WebElement reviewUrl = driver.findElement(withTagName("input").toRightOf(setReviewName));

		reviewUrl.sendKeys("http://www.sephora.fr");

		Thread.sleep(600);

		getElementByClass(reviewUrlbtn).click();
		Thread.sleep(600);

		// Add
		getElementByClass(addReviewbtn).click();

	}

	private static void validateAndContinue() throws InterruptedException {
		List<WebElement> buttons = getElementsByClass(buttonWrapper);

		WebElement validateButton = buttons.get(buttons.size() - 1);

		validateButton.click();

		Thread.sleep(1000);
	}

	private static void validateAndPublish() throws InterruptedException {

		List<WebElement> buttons = getElementsByClass(buttonWrapper);
		WebElement validateButton = buttons.get(buttons.size() - 1);

		validateButton.click();

		Thread.sleep(6000);

		javascript.executeScript("window.scrollBy(0,700)", "");
	}

	private static void selectUniverse() throws InterruptedException {
		Thread.sleep(2000);

		WebElement beauty = getElementByID(beautyUniverse);
		WebElement fashion = getElementByID(FashionUniverse);
		WebElement lifeStyle = getElementByID(LifeStyleUniverse);
		WebElement food = getElementByID(foodUniverse);
		WebElement sport = getElementByID(sportUniverse);
		WebElement travel = getElementByID(travelUniverse);
		WebElement deco = getElementByID(decoUniverse);
		WebElement photo = getElementByID(decoUniverse);
		WebElement childen = getElementByID(childenUniverse);
		WebElement hightech = getElementByID(hightechUniverse);
		WebElement Art = getElementByID(ArtUniverse);

		// Select univers :: Beauté, mode, lifestyle

		javascript.executeScript("arguments[0].click();", beauty);
		javascript.executeScript("arguments[0].click();", fashion);
		javascript.executeScript("arguments[0].click();", lifeStyle);
		javascript.executeScript("arguments[0].click();", deco);
		javascript.executeScript("arguments[0].click();", food);
	}

	private static void selectCountry() throws InterruptedException {

		Thread.sleep(1000);

		WebElement Countryselection = driver.findElement(By.className("Select-multi-value-wrapper"));

		Actions builder = new Actions(driver);
		builder.moveToElement(Countryselection).clickAndHold().perform();

		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
				Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
				Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
				Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
				Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
				Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
				Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
				Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
				Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
	}

	private static void selectNetwork(Network network) {
		int i = 0;

		switch (network) {
		case youtube:
			i = 0;
			break;
		case instagram:
			i = 1;
			break;
		case blog:
			i = 2;
			break;
		case pinterest:
			i = 3;
			break;
		case review:
			i = 4;
			break;
		}

		WebElement networkElement = driver.findElement(By.id("selectProvider" + i));

		javascript.executeScript("arguments[0].click();", networkElement);
		javascript.executeScript("window.scrollBy(0,500)", "");

	}

	public static void fillStepThree() throws InterruptedException {
		// select an instruction
		getElementByXPath(selectInstructions).click();
		Thread.sleep(200);
		getElementByXPath(notDeleteInstr).click();

		// validate and continue
		validateAndContinue();

		Thread.sleep(4000);
	}

	public static void fillFinalStep() throws InterruptedException {

		javascript.executeScript("window.scrollBy(0,700)", "");

		Thread.sleep(2000);

		// validate and publish
		validateAndPublish();

	}

	private static void selectCategories() throws InterruptedException {

		List<WebElement> select = getElementsByClass(selector);
		WebElement activitySector = select.get(0);
		Thread.sleep(1500);

		Actions builder = new Actions(driver);
		builder.moveToElement(activitySector).clickAndHold().perform();
		Add_Log.debug("Selecting Category sector ... ");
		{
			try {
				Thread.sleep(2000);

				Actions keyDown = new Actions(driver);
				keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,
						Keys.DOWN, Keys.ENTER)).perform();

				Add_Log.info("Category sector selected");

			} catch (InterruptedException e) {
				Add_Log.info("failed to select activity sector");
			}
		}
	}

	public static void selectOffer() throws InterruptedException {
		List<WebElement> select = getElementsByClass(selector);
		WebElement offer = select.get(1);

		{

			Actions builder = new Actions(driver);
			builder.moveToElement(offer).clickAndHold().perform();
		}
		{
			Thread.sleep(1000);
			WebElement OfferValue = getElementByXPath(offerPoster);
			OfferValue.click();
			Add_Log.debug("Offer selected");
		}

	}

	public static void selectCampaign(String campaignName) throws InterruptedException {

		List<WebElement> campaignList = driver.findElements(By.className("campaign-name"));
		for (WebElement campaign : campaignList) {
			try {
				if (campaign.getText().toLowerCase().equals(campaignName.toLowerCase())) {
					System.out.println("Campaign " + campaignName + " found");
					javascript.executeScript("arguments[0].click();", campaign);
				}
			} catch (Exception StaleElementReferenceException) {
				StaleElementReferenceException.getMessage();
			}
		}

		Thread.sleep(1000);
	}

	public static void deleteCampaign(String campaignName) throws InterruptedException {
		Thread.sleep(1600);
		List<WebElement> campaignList = driver.findElements(By.className("campaign-name"));
		System.out.println("There are : " + campaignList.size() + " campaigns available");
		
		for (WebElement campaign : campaignList) {

				int i = campaignList.indexOf(campaign)+1;

				if(campaign.getText().toLowerCase().equals(campaignName.toLowerCase())) {
					Add_Log.info("Campaign "+campaignName+" found");
					Thread.sleep(200);
					WebElement deletebtn = driver.findElement(By.cssSelector(".mb-3:nth-child("+i+") .delete-campaign-button .d-flex"));
					 deletebtn.click(); 
					// assertThat(driver.switchTo().alert().getText(), is("Are you sure you want to delete the "+campaignName+" campaign?"));
					driver.switchTo().alert().accept();
					Add_Log.info("campaign "+campaignName+" deleted successfully !");
				}
			}
	}

	public static void duplicateCampaign(String campaignName) throws InterruptedException {
		Thread.sleep(1600);
		List<WebElement> campaignList = driver.findElements(By.className("campaign-name"));
		System.out.println("There are : " + campaignList.size() + " campaigns available");
		
		for (WebElement campaign : campaignList) {

				int i = campaignList.indexOf(campaign)+1;
		try {
			if(campaign.getText().toLowerCase().equals(campaignName.toLowerCase())) {
				Add_Log.info("Campaign "+campaignName+" found");
				Add_Log.info("Duplicating campaign "+campaignName+"  ...");
				Thread.sleep(200);
				WebElement duplicatebtn = driver.findElement(By.cssSelector(".mb-3:nth-child("+i+") .inline-buttons > .button-wrapper .d-flex"));	
				duplicatebtn.click(); 
				Add_Log.info("campaign "+campaignName+" duplicated successfully !");
			}
		}catch(StaleElementReferenceException e) {
			e.printStackTrace();
		}
		
	  }
	}
	
	public static void closeCampaign(String campaignName) throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> campaignList = driver.findElements(By.className("campaign-name"));
		System.out.println("There are : " + campaignList.size() + " campaigns available");
		
		for (WebElement campaign : campaignList) {

				int i = campaignList.indexOf(campaign)+1;
		try {
			if(campaign.getText().toLowerCase().equals(campaignName.toLowerCase())) {
				Add_Log.info("Campaign "+campaignName+" found");
				Add_Log.info("Closing campaign "+campaignName+"  ...");
				Thread.sleep(200);	
				WebElement closebtn = driver.findElement(By.cssSelector(".mb-3:nth-child("+i+") > .all-buttons .col-6:nth-child(2) .d-flex"));	
				closebtn.click(); 
				driver.switchTo().alert().accept();
				Add_Log.info("campaign "+campaignName+" closed successfully !");
			}
		}catch(StaleElementReferenceException e) {
			e.printStackTrace();
		}
		
	  }
	}

}
