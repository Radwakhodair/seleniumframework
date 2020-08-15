package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.loadproperities;
import pages.Homepage;
import pages.Loginpage;
import pages.Userregistrationpage;

public class UserregistrationtestwithDDTANDPROPERITIESFILE extends TestBase {
	Homepage homeobject;
	Userregistrationpage registerobject;
	public Loginpage loginobject;
	public Loginpage logoutobject;
	String firstname =loadproperities.userData.getProperty("firstname");
	String lastname =loadproperities.userData.getProperty("lastname");
	String email=loadproperities.userData.getProperty("email");
	String password=loadproperities.userData.getProperty("password");
	
	@Test(priority=1,alwaysRun=true)
	public void usercanregistersuccessfully()
	{
		
		homeobject=new Homepage(driver);
		homeobject.openregistrationpage();
		registerobject=new Userregistrationpage(driver);
		registerobject.userregistration(firstname, lastname, email, password);
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
	 loginobject.userlogin(email, password);
	 
	// Assert.assertTrue(registerobject.logoutlink.isDisplayed());
	}
	

}
