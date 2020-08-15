package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.Loginpage;
import pages.Userregistrationpage;

public class Userregistrationtest extends TestBase {
	Homepage homeobject;
	Userregistrationpage registerobject;
	public Loginpage loginobject;
	public Loginpage logoutobject;
	
	
	@Test(priority=1,alwaysRun=true)
	public void usercanregistersuccessfully()
	{
		
		homeobject=new Homepage(driver);
		homeobject.openregistrationpage();
		registerobject=new Userregistrationpage(driver);
		registerobject.userregistration("radwa", "khodair", "radwptest0102@gmail.com", "12345678");
	Assert.assertTrue(registerobject.sucessmessage.getText().contains("Your registration completed"));
	
	}
	//---------------------------------------//
	@Test(dependsOnMethods= {"usercanregistersuccessfully"})
	public void registeredusercanlogout()
	{
		registerobject.userlogout();
	}
	//-------------------------------------//
	@Test(dependsOnMethods= {"registeredusercanlogout"})
	public void Registeredusercanlogin()
	{
	 homeobject.openloginpage();
	 loginobject=new Loginpage(driver);
	 loginobject.userlogin("radwptest0102@gmail.com", "12345678");
	 
	 Assert.assertTrue(registerobject.logoutlink.isDisplayed());
	}
	

}
