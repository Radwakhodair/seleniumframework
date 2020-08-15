package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.Homepage;
import pages.Loginpage;
import pages.Userregistrationpage;

public class Userregistrationtestwithjavafaker extends TestBase {
	Homepage homeobject;
	Userregistrationpage registerobject;
	public Loginpage loginobject;
	public Loginpage logoutobject;
	Faker fakeData=new Faker();
	String firstname=fakeData.name().firstName();
	String lastname=fakeData.name().lastName();
	String email=fakeData.internet().emailAddress();
	String password=fakeData.number().digits(8).toString();
	
	
	@Test(priority=1,alwaysRun=true)
	public void usercanregistersuccessfully()
	{
		
		homeobject=new Homepage(driver);
		homeobject.openregistrationpage();
		registerobject=new Userregistrationpage(driver);
		registerobject.userregistration(firstname,lastname,email,password);
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
	 
	 Assert.assertTrue(registerobject.logoutlink.isDisplayed());
	}
	

}
