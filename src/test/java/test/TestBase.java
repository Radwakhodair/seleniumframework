package test;
//RESPONSIBLE FOR INITIALLIZE DRIVER &QUIT  DRIVER ,DEAL WITH ALL TEST CASES 

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utility.Helper;


public class TestBase {
	public static WebDriver driver;
public static String downloadpath=System.getProperty("user.dir")+"\\downloads";
	
	public static ChromeOptions chromeoption()
	{
		ChromeOptions options=new ChromeOptions();
		HashMap<String, Object> chromeprefs=new HashMap<String, Object>();
		chromeprefs.put("profile.default.content_settings.popups", 0);
		chromeprefs.put("download.default_directory", downloadpath);
		options.setExperimentalOption("prefs", chromeprefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
		
	}
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome")String browserName)
	
	{
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver=new ChromeDriver(chromeoption());
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		//headless browser testing
		else if (browserName.equalsIgnoreCase("headless"))
		{
			DesiredCapabilities caps =new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getProperty("user.dir")+"/drivers/phantomjs.exe");
			
			String[] phantomjaArgs= {"--Web-security=no","--ignore-ssl--errors=yes"};
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,phantomjaArgs );
			driver=new PhantomJSDriver(caps);
		}
		else if (browserName.equalsIgnoreCase("chrome-headless")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver=new ChromeDriver(options);
			
		}
		
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");
		
	}
	@AfterSuite
public void stopDriver()
{
	driver.quit();
}
	//take screenshoot when test case fail and add it in the screenshot folder 
	@AfterMethod
	public void screenschotafterfailure(ITestResult result)
	{
		if (result.getStatus()==ITestResult.FAILURE) {
			System.out.println("faile");
			System.out.println("Taking screenshot......");
			Helper.capturescreenschoot(driver, result.getName());
		}
	}
}
