package autotest.automate.webapp.brand.pom;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;

import autotest.automate.utility.StringInXpath;

public class FollowUpPage extends BrandAppPage{
	
	// private static By pendingInfluencerTab = By.xpath("//div[contains( text(), 'pending influencers')]");
	static String pendingInfluencerTab = "pending_influencer_tab";
	//private static By pendingshipementTab = By.xpath("//div[contains( text(), 'pending shipments')]");
	static String pendingshipementTab = "pending_shipement_tab";
	//private static By pendingPublicationsTab = By.xpath("");
	static String pendingPublicationsTab = "pending_publications_tab";
	// private static By publicationsTab = By.xpath("");
	static String publicationsTab = "publications_tab";
    // private static By checkbox = By.className("checkbox-container");
    static String checkbox = "check_box";
    // private static By warningButtons = By.className("checkbox-container");
    static String warningButtons = "warning_buttons";
    // private static By successButtons = By.className("success");
    static String successButtons = "success_buttons";
  
   // private static By approveButton = By.xpath("//span[contains(text(),'Approve')]");
    static String approveButton = "approve_button";
    // private static By refuseButton = By.xpath("//span[contains(text(),'Refuse')]");
    static String refuseButton = "refuse_button";
 //   private static By Orders = By.className("orders-container");//
   //  private static By campaignsOrders = By.className("campaign-order-container");//
    static String campaignsOrders = "campaigns_orders";
   
   // private static By shipbtn = By.xpath("//*[contains(text(),'ship')]");//
   static String shipbtn = "ship_btn";

	
	
	public FollowUpPage(WebDriver driver) {
		super(driver);
	}

	public static void goPendingInfluencer() {
		getElementByXPath(pendingInfluencerTab).click();
	}
		
	public static void goPendingshipement() {
		getElementByXPath(pendingshipementTab).click();
	} 
	
	public static void goPendingPublicationsTab() {
		getElementByXPath(pendingPublicationsTab).click();
	}
	
	public static void goPublicationsTab() {
		getElementByXPath(publicationsTab).click();
	}
	
	public static void shipAll() throws InterruptedException {
		
		goPendingshipement();
		Thread.sleep(1000);
		WebElement checkboxContainer = getElementByXPath(warningButtons);
		WebElement markAsShiped = getElementByClass(successButtons);
		
		checkboxContainer.click();
		Thread.sleep(200);
		markAsShiped.click();
		Thread.sleep(6000);
	}
	
	public static void shipOne() throws InterruptedException {
		
		goPendingshipement();
		Thread.sleep(1000);

		  List<WebElement> shipbtns = getElementsByXPath(shipbtn); 
		  int shipmentNumber = shipbtns.size()-3;
		  
		  for (WebElement webElement : shipbtns) { 
			  System.out.println("Il y a ... "+ shipmentNumber + " ... Produits A envoyer " );
		  
		  for (int i=3; i < shipbtns.size(); i++) {
		  
		  System.out.println(webElement.getText() + " : " + i);
		  System.out.println(" button test  :  " + i + shipbtns.get(i));
		  
		  Thread.sleep(2000);
		  
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", shipbtns.get(i));
		  
		  driver.findElement(By.id("shipmentCarrier")).sendKeys("La poste");
		  driver.findElement(By.id("trackingNumber")).sendKeys("0124578 4654678 12");
		  driver.findElement(By.id("trackingLink")).sendKeys("https://laposte.fr");
		  
		  Thread.sleep(2500);
		  
		  // click on submit
		  
		  driver.findElement(By.xpath("//div[contains(text(),'Submit')]")).click();
		  
		  } 
	    } 
	}
	
	public static void goPendingPublications() {
		
	}
	
	public static CampaignsPage goPublications() {
		getElementByXPath(pendingPublicationsTab).click();
		return new CampaignsPage(driver);
	}
	
	public static void acceptAllInfluencers() throws InterruptedException {
		List <WebElement> selectBoxes = getElementsByClass(checkbox);
		System.out.println("There is "+ selectBoxes.size()/2 + " selected influencers");
		int i = 0;
		while(i < selectBoxes.size()) {
			selectBoxes.get(i).click();
			i = i+2;
		}
		getElementByXPath(approveButton).click();
	}
	
	public static void refuseAllInfluencers() throws InterruptedException {
		List <WebElement> selectBoxes = getElementsByClass(checkbox);
		System.out.println("There is : "+ selectBoxes.size()/2 + " selected influencers");
		int i = 0;
		while(i < selectBoxes.size()) {
			selectBoxes.get(i).click();
			i = i+2;
		}
		getElementByXPath(refuseButton).click();
	}
	
		@SuppressWarnings("deprecation")
		public static void selectCampaign(String campaignName) throws NoSuchElementException {
			
		String campaignsXpath = StringInXpath.insertInSpanXpath(campaignName);
		List <WebElement> campaignsOrdersElements = getElementsByClass(campaignsOrders);
		
		System.out.println("There is : "+campaignsOrdersElements.size() +" campaign(s)");
		
		if (campaignsOrdersElements.size()>0) {
			
			try {
				if (driver.findElement(By.xpath(campaignsXpath)) != null){
					for(WebElement oneCampElement : campaignsOrdersElements) {
						
						List <WebElement> allInOneElement = oneCampElement.findElements(By.className("campaign_campaignInformation__1kvdu"));
						WebElement campaignTitle = allInOneElement.get(0);
						
						if (campaignTitle.getText().equalsIgnoreCase(campaignName)) {
							System.out.println("The campaign to select is  "+ campaignName);
						 // System.out.println("The campaign to select has the index : " + campaignsOrdersElements.indexOf(oneCampElement));
								List <WebElement> allInOneArrowElement = driver.findElements(RelativeLocator.withTagName("svg"));
								// WebElement campaignArrow = allInOneArrowElement.get(17);
								WebElement campaignArrow = driver.findElement(By.xpath("//a[contains(@href, 'http://www.w3.org/2000/svg')]"));
							//	campaignArrow.click();
							//	new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(campaignsXpath)));
								new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.elementToBeClickable(campaignArrow)).click();
								
						}
					}

				}
				else {
					System.out.println("Aucune campagne ne porte le nom de " + campaignName);
				}
			}
			catch (NoSuchElementException e) {
				System.out.println(" (catch) Aucune campagne ne porte le nom de " + campaignName);
				e.printStackTrace();
			}
			
		}
		else {
			System.out.println("There is no pending campaign");	
		}
	}
}
