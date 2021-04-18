package autotest.automate;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.helpers.OptionConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;



public abstract class BaseTest {
	
	public static Logger Add_Log = null;
	public boolean BrowseralreadyLoaded=false;
	public static Properties Param = null;
	public static Properties Object = null;
	protected static WebDriver driver=null;
	public static WebDriver ExistingchromeBrowser;
	public static WebDriver ExistingmozillaBrowser;
	protected static WebDriver ExistingIEBrowser;
	


	
	public void init() throws IOException{
		
		//To Initialize logger service.
		System.out.println(System.getProperty("log4j.configuration", null));
		System.out.println(OptionConverter.getSystemProperty("log4j.configuration", null));
		Add_Log = Logger.getLogger("rootLogger");
		// BasicConfigurator.configure();
		PropertyConfigurator.configure("C:\\Users\\Utilisateur\\eclipse-workspace\\autotest\\log4j.properties");
		   
		// Add_Log = Logger.getRootLogger();
		
		// PropertyConfigurator.configure(ContentPublication.class.getClassLoader().getResource("log4j.properties"));
		//PropertyConfigurator.configure("C:\Users\Utilisateur\eclipse-workspace\autotest\log4j.properties");
		// PropertyConfigurator.configure("C:\\Users\\Utilisateur\\eclipse-workspace\\autotest\\log4j.properties");
		
		//Bellow given syntax will Insert log In applog.log file.
		Add_Log.info("Execution started for Hivency Automaton.");
		
		//Create object of Java Properties class
		Param = new Properties();
		FileInputStream fip = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\property\\Param.properties");
		Param.load(fip);
		Add_Log.info("Param.properties file loaded successfully.");	
		
		//Initialize Objects.properties file.
		Object = new Properties();
		fip = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\property\\Objects.properties");
		Object.load(fip);
		Add_Log.info("Objects.properties file loaded successfully.");
	}
	
	public void loadWebBrowser(){
		
		// Browser logging again 
		LoggingPreferences logs = new LoggingPreferences();
		logs.enable(LogType.BROWSER, Level.ALL);
		
		//Check If any previous webdriver browser Instance Is exist then run new test In that existing webdriver browser Instance.
			if(Param.getProperty("testBrowser").equalsIgnoreCase("Mozilla") && ExistingmozillaBrowser!=null){
				driver = ExistingmozillaBrowser;
				return;
			}else if(Param.getProperty("testBrowser").equalsIgnoreCase("chrome") && ExistingchromeBrowser!=null){
				driver = ExistingchromeBrowser;
				return;
			}else if(Param.getProperty("testBrowser").equalsIgnoreCase("IE") && ExistingIEBrowser!=null){
				driver = ExistingIEBrowser;
				return;
			}		
		
		
			if(Param.getProperty("testBrowser").equalsIgnoreCase("Mozilla")){
				//To Load Firefox driver Instance. 
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Webdrivers\\Windows\\Mozilla\\geckodriver.exe");
				driver = new FirefoxDriver();
				ExistingmozillaBrowser=driver;
				Add_Log.info("Firefox Driver Instance loaded successfully.");
				
			}else if(Param.getProperty("testBrowser").equalsIgnoreCase("Chrome")){
				//To Load Chrome driver Instance.
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Webdrivers\\Windows\\chrome\\chromedriver.exe");
				driver = new ChromeDriver();
				ExistingchromeBrowser=driver;
				Add_Log.info("Chrome Driver Instance loaded successfully.");
				
			}else if(Param.getProperty("testBrowser").equalsIgnoreCase("IE")){
				//To Load IE driver Instance.
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Webdrivers\\Windows\\IE\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				ExistingIEBrowser=driver;
				Add_Log.info("IE Driver Instance loaded successfully.");
				
			}			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
	
	}
	
	public void closeWebBrowser(){
		driver.close();
		//null browser Instance when close.
		ExistingchromeBrowser=null;
		ExistingmozillaBrowser=null;
		ExistingIEBrowser=null;
	}
	
	public void connection(String mail, String password) {
		  
		  	WebElement email = driver.findElement(By.id("email"));
		    WebElement mot2passe = driver.findElement(By.id("password")); 
		    
		    email.sendKeys(mail);
		    mot2passe.sendKeys(password);
		    
		    try {
		    	driver.findElement(By.xpath("//span[contains(text(),'se connecter')]")).click();
			} catch (Exception e) {
				 driver.findElement(By.className("wrapper-input-submit")).click(); 
			}
		   	    
	  }
	
	
	//getElementByXPath function for static xpath
	public WebElement getElementByXPath(String Key){
		try{
			//This block will find element using Key value from web page and return It.
			return driver.findElement(By.xpath(Object.getProperty(Key)));
		}catch(Throwable t){
			//If element not found on page then It will return null.
			Add_Log.debug("Object not found for key --"+Key);
			return null;
		}
	}
	
	//getElementByXPath function for dynamic xpath
	public WebElement getElementByXPath(String Key1, int val, String key2){
		try{
			//This block will find element using values of Key1, val and key2 from web page and return It.
			return driver.findElement(By.xpath(Object.getProperty(Key1)+val+Object.getProperty(key2)));
		}catch(Throwable t){
			//If element not found on page then It will return null.
			Add_Log.debug("Object not found for custom xpath");
			return null;
		}
	}
	
	//Call this function to locate element by ID locator.
	public WebElement getElementByID(String Key){
		try{
			return driver.findElement(By.id(Object.getProperty(Key)));
		}catch(Throwable t){
			Add_Log.debug("Object not found for key --"+Key);
			return null;
		}
	}
	
	//Call this function to locate element by Name Locator.
	public WebElement getElementByName(String Key){
		try{
			return driver.findElement(By.name(Object.getProperty(Key)));
		}catch(Throwable t){
			Add_Log.debug("Object not found for key --"+Key);
			return null;
		}
	}
	
	//Call this function to locate element by cssSelector Locator.
	public WebElement getElementByCSS(String Key){
		try{
			return driver.findElement(By.cssSelector(Object.getProperty(Key)));
		}catch(Throwable t){
			Add_Log.debug("Object not found for key --"+Key);
			return null;
		}
	}
	
	//Call this function to locate element by ClassName Locator.
	public WebElement getElementByClass(String Key){
		try{
			return driver.findElement(By.className(Object.getProperty(Key)));
		}catch(Throwable t){
			Add_Log.debug("Object not found for key --"+Key);
			return null;
		}
	}
	
	//Call this function to locate element by tagName Locator.
	public WebElement getElementByTagName(String Key){
		try{
			return driver.findElement(By.tagName(Object.getProperty(Key)));
		}catch(Throwable t){
			Add_Log.debug("Object not found for key --"+Key);
			return null;
		}
	}
	
	//Call this function to locate element by link text Locator.
	public WebElement getElementBylinkText(String Key){
		try{
			return driver.findElement(By.linkText(Object.getProperty(Key)));
		}catch(Throwable t){
			Add_Log.debug("Object not found for key --"+Key);
			return null;
		}
	}
	
	//Call this function to locate element by partial link text Locator.
	public WebElement getElementBypLinkText(String Key){
		try{
			return driver.findElement(By.partialLinkText(Object.getProperty(Key)));
		}catch(Throwable t){
			Add_Log.debug("Object not found for key --"+Key);
			return null;
		}
	}

}
