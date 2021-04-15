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
	//	System.out.println(System.getProperty("log4j.configuration", null));
	//	System.out.println(OptionConverter.getSystemProperty("log4j.configuration", null));
		Add_Log = Logger.getLogger("rootLogger");
		// BasicConfigurator.configure();
	//	PropertyConfigurator.configure("C:\\Users\\Utilisateur\\eclipse-workspace\\autotest\\log4j.properties");
		   
		// Add_Log = Logger.getRootLogger();
		
		// PropertyConfigurator.configure(ContentPublication.class.getClassLoader().getResource("log4j.properties"));
		//PropertyConfigurator.configure("C:\Users\Utilisateur\eclipse-workspace\autotest\log4j.properties");
		// PropertyConfigurator.configure("C:\\Users\\Utilisateur\\eclipse-workspace\\autotest\\log4j.properties");
		
		//Bellow given syntax will Insert log In applog.log file.
		Add_Log.info("Execution started for Hivency Automaton.");
		
		String paramMac = "//src//test//resources//property//Param.properties";
		String objectMac = "//src//test//resources//property//Param.properties";
		String paramWin = "\\src\\test\\resources\\property\\Param.properties";
		String objectWin = "\\src\\test\\resources\\property\\Param.properties";

		
		String paramProp = paramWin;
		String objectProp = objectWin;
		
		
		String OS = System.getProperty("os.name");
		
		
		System.out.println(System.getProperty("os.name"));
		
		if (OS.startsWith("Mac")) {
			paramProp = paramMac;
			objectProp = objectMac;
		}
		
		//Create object of Java Properties class
		Param = new Properties();
		
	
		FileInputStream fip = new FileInputStream(System.getProperty("user.dir")+ paramProp );
		Param.load(fip);
		Add_Log.info("Param.properties file loaded successfully.");	
		
		//Initialize Objects.properties file.
		Object = new Properties();
		fip = new FileInputStream(System.getProperty("user.dir")+ objectProp);
		Object.load(fip);
		Add_Log.info("Objects.properties file loaded successfully.");
	}
	
	public void loadWebBrowser(){
		
		String chromeDriverWin  = "\\src\\test\\resources\\Webdrivers\\Windows\\chrome\\chromedriver.exe";
		String chromeDriverMac  = "//src//test//resources//Webdrivers//Mac//chromedriver";
		
		String chromeDriver = chromeDriverWin;
		
		if (System.getProperty("os.name").startsWith("Mac")) {
			chromeDriver = chromeDriverMac;
		}
		
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
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ chromeDriver);
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

}
