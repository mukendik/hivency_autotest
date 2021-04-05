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
	
	private static By pendingInfluencerTab = By.xpath("//div[contains( text(), 'pending influencers')]");
	private static By pendingshipementTab = By.xpath("//div[contains( text(), 'pending shipments')]");
	private static By pendingPublicationsTab = By.xpath("");
	private static By publicationsTab = By.xpath("");
    private static By checkbox = By.className("checkbox-container");
    private static By warningButtons = By.className("checkbox-container");
    private static By successButtons = By.className("success");
  
    private static By approveButton = By.xpath("//span[contains(text(),'Approve')]");
    private static By refuseButton = By.xpath("//span[contains(text(),'Refuse')]");
 //   private static By Orders = By.className("orders-container");//
    private static By campaignsOrders = By.className("campaign-order-container");//
   
   private static By shipbtn = By.xpath("//*[contains(text(),'ship')]");//

	
	
	public FollowUpPage(WebDriver driver) {
		super(driver);
	}

	public static void goPendingInfluencer() {
		driver.findElement(pendingInfluencerTab).click();
	}
		
	public static void goPendingshipement() {
		driver.findElement(pendingshipementTab).click();
	} 
	
	public static void goPendingPublicationsTab() {
		driver.findElement(pendingPublicationsTab).click();
	}
	
	public static void goPublicationsTab() {
		driver.findElement(publicationsTab).click();
	}
	
	public static void shipAll() throws InterruptedException {
		
		goPendingshipement();
		Thread.sleep(1000);
		WebElement checkboxContainer = driver.findElement(warningButtons);
		WebElement markAsShiped = driver.findElement(successButtons);
		
		checkboxContainer.click();
		Thread.sleep(200);
		markAsShiped.click();
		Thread.sleep(6000);
	}
	
	public static void shipOne() throws InterruptedException {
		
		goPendingshipement();
		Thread.sleep(1000);

		  List<WebElement> shipbtns = driver.findElements(shipbtn); 
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
		driver.findElement(publicationsLink).click();
		return new CampaignsPage(driver);
	}
	
	public static void acceptAllInfluencers() throws InterruptedException {
		List <WebElement> selectBoxes = driver.findElements(checkbox);
		System.out.println("There is "+ selectBoxes.size()/2 + " selected influencers");
		int i = 0;
		while(i < selectBoxes.size()) {
			selectBoxes.get(i).click();
			i = i+2;
		}
		driver.findElement(approveButton).click();
	}
	
	public static void refuseAllInfluencers() throws InterruptedException {
		List <WebElement> selectBoxes = driver.findElements(checkbox);
		System.out.println("There is : "+ selectBoxes.size()/2 + " selected influencers");
		int i = 0;
		while(i < selectBoxes.size()) {
			selectBoxes.get(i).click();
			i = i+2;
		}
		driver.findElement(refuseButton).click();
	}
	
		@SuppressWarnings("deprecation")
		public static void selectCampaign(String campaignName) throws NoSuchElementException {
			
		String campaignsXpath = StringInXpath.insertInSpanXpath(campaignName);
		List <WebElement> campaignsOrdersElements = driver.findElements(campaignsOrders);
		
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