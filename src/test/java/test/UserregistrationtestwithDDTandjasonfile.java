package test;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.jsondatareader;
import pages.Homepage;
import pages.Loginpage;
import pages.Userregistrationpage;

public class UserregistrationtestwithDDTandjasonfile extends TestBase {
	Homepage homeobject;
	Userregistrationpage registerobject;
	public Loginpage loginobject;
	public Loginpage logoutobject;
	
	
	@Test(priority=1,alwaysRun=true)
	public void usercanregistersuccessfully() throws IOException, ParseException
	{
		jsondatareader jsonReader=new jsondatareader();
		jsonReader.jasonReader();
		homeobject=new Homepage(driver);
		homeobject.openregistrationpage();
		registerobject=new Userregistrationpage(driver);
		registerobject.userregistration(jsonReader.firstname,jsonReader.lastname,jsonReader.email,jsonReader.password);
	Assert.assertTrue(registerobject.sucessmessage.getText().contains("Your registration completed"));
	registerobject.userlogout();
	homeobject.openloginpage();
	 loginobject=new Loginpage(driver);
	 loginobject.userlogin(jsonReader.email, jsonReader.password);
	 
	 Assert.assertTrue(registerobject.logoutlink.getText().contains("log out"));
	 registerobject.userlogout();
	}
}