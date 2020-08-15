package test;
//RESPONSIBLE FOR INITIALLIZE DRIVER &QUIT  DRIVER ,DEAL WITH ALL TEST CASES 

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
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
