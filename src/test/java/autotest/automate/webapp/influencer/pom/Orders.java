package autotest.automate.webapp.influencer.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Orders {
	
	protected static  WebDriver driver;
	
	private static By toPublishTab = By.xpath("//a[contains(@href,'/orders')]");
	private static By pendingValidationTab = By.xpath("//a[contains(href ='/orders/pending')]");
	private static By pastTab = By.xpath("//a[contains(href ='/orders/past')]");
	
	private static By publishedBtn = By.xpath("//span[contains(text(),'j'ai publié mon contenu')]");
	private static By allBtn = By.tagName("button");
	private static By validateBtn = By.xpath("//*[contains(text(),'valider')]");

	
	public Orders(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public static void publishContent() throws InterruptedException{
	//	WebElement iPublished= driver.findElement(publishedBtn);
		List<WebElement> buttons= driver.findElements(allBtn);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ipublishedBtn = buttons.get(9);
		// WebElement popo = js.executeScript("document.getElementsByClassName('button_button__3C5KM button_dark__3TMoA')");
		driver.findElement(toPublishTab).click();
	//	Thread.sleep(1000);
	//	buttons.get(9).click();
		Thread.sleep(2000);
		while(ipublishedBtn.isDisplayed()) {
			ipublishedBtn.click();
		//	new Actions(driver).moveToElement(iPublished).click().perform();
			ipublishedBtn.click();
			// driver.findElement(publishedBtn).click();
			Thread.sleep(600);
		}
		driver.findElement(validateBtn).click();
		
	}
}
