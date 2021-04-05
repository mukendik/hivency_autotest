package autotest.automate.webapp.influencer.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CompleteProfile {
	
	  protected static WebDriver driver;
	  
	  protected static By firstname = By.id("firstname");
	  protected static By lastname = By.id("lastname");
	 
	//  private static By birthDay = By.className("react-datepicker-wrapper");
	//  private static By gender = RelativeLocator.withTagName("input").below(birthDay);
	  private static By profilePicture = By.xpath("//span[contains(text(),'photo')]");
	  private static By selectCountry = By.xpath("//div[contains(text(),'Sélectionnez')]");
	  
	  private static By deco     = By.id("1"); // decoration
	  private static By food     = By.id("2"); // nourriture
	  private static By sport    = By.id("3"); // sport
	  private static By beauty   = By.id("4"); // beauté
	  private static By fashion  = By.id("5"); // mode
	  private static By childen  = By.id("6"); // enfants
	  private static By lifeStyle= By.id("7"); // style
	  private static By highTech = By.id("8"); // High tech
	  private static By travel   = By.id("9"); // voyage
	  private static By photo    = By.id("10"); // photographie
	  private static By art      = By.id("11"); // art
	  
	  
	  private static By check_terms = By.id("check_terms"); // check_terms and conditions
	  
	  private static By accessStorebtn = By.xpath("//span[contains(text(),'store')]"); // check_terms and conditions
	  
	  
	public CompleteProfile(WebDriver driver) {
		super();
		this.driver = driver;
	}


public static void completeProfile() throws InterruptedException{
		
		driver.findElement(firstname).sendKeys("AUTO");
		driver.findElement(lastname).sendKeys("TEST");
    //	driver.findElement(birthDay).sendKeys("21/03/2000");
		
    //	driver.findElement(gender).click();
    //	driver.findElement(profilePicture).sendKeys("");
    	
    //	driver.findElement(selectCountry).sendKeys("France");
		
		 JavascriptExecutor javascript = (JavascriptExecutor) driver;
		 javascript.executeScript("window.scrollBy(0,600)", "");
		 
    	
    	// Interrests 
	   WebElement beautyElement = driver.findElement(beauty);
	   WebElement decoElement = driver.findElement(deco);
	   WebElement fashionElement = driver.findElement(fashion);
	   WebElement lifeStyleElement = driver.findElement(lifeStyle);
	   WebElement childenElement = driver.findElement(childen);
	  
	   WebElement checkTerms = driver.findElement(check_terms);

	   
	   JavascriptExecutor executor = (JavascriptExecutor)driver;
	   
	   executor.executeScript("arguments[0].click();", beautyElement);
	   executor.executeScript("arguments[0].click();", decoElement);
	   executor.executeScript("arguments[0].click();", fashionElement);
	   executor.executeScript("arguments[0].click();", lifeStyleElement);
	   executor.executeScript("arguments[0].click();", childenElement);
 	
	   executor.executeScript("arguments[0].click();", checkTerms);
    	
    	driver.findElement(accessStorebtn).click();
    	
    	Thread.sleep(5000);
	}

}
